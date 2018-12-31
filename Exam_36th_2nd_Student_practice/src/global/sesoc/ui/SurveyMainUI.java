package global.sesoc.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import global.sesoc.dao.SurveyDAOManager;
import global.sesoc.vo.Question;
import global.sesoc.vo.Survey;
import global.sesoc.vo.StatSurvey;
import global.sesoc.vo.Answer;

public class SurveyMainUI {
	Scanner input = new Scanner(System.in);
	SurveyDAOManager dao = new SurveyDAOManager();

	/**
	 * ������
	 */
	public SurveyMainUI() {
		String mNum = null;

		while(true) {
			try {
				mainMenu();
				mNum = input.next();
				input.nextLine();

				switch(mNum) {
				case "1":
					surveyAdministrator();	// ���� ���
					break;
				case "2":
					participantSurvey();	// ���� ����
					break;
				case "9":					// ����
					System.out.println("*** ������ ������ �ּż� �����մϴ�. ���α׷� �����մϴ�.");
					return;
				default : 
					System.out.println("���� >> �Է��� �߸��Ͽ����ϴ�. �ٽ� �Է��� �ּ���");
					continue;
				}
			} catch (Exception e) {
				System.out.println(">> �����߻�. �ٽ� �Է��� �ּ���");
				input.nextLine();
				continue;
			}
		}
	}

	/**
	 * �� �޴� ȭ��
	 */
	public void mainMenu() {
		System.out.println("\n[ SCIT MASTER �������� ]");
		System.out.println("1. ���� ���� (������ ����)");
		System.out.println("2. ���� ����");
		System.out.println("9. ����");
		System.out.print  ("** �޴� ���� : ");
	}
	
	/**
	 * ������ ����ϱ� ���� �޴� ȭ��
	 */
	public void registSurveyMenu() {
		System.out.println("\n[ SCIT MASTER ���� ���� (Administrator Only) ]");
		System.out.println("1. ���� ���");
		System.out.println("2. ��ϵ� ���� ����");
		System.out.println("3. ��� ����");
		System.out.println("9. ���� �޴�");
		System.out.print  ("** �޴� ���� : ");
	}
	
	/**
	 * �����ڰ� ������ �߰��ϱ� ���� �޴�. �����ڸ��� ������ ����� �� �ִ�.
	 * �̸��ϰ� ��й�ȣ�� �Է��Ͽ� ������ �̸��ϰ� ��й�ȣ�� ���� ��쿡�� ����� �� �ִ� ȭ������ �̵��Ѵ�.
	 *     SurveyDAOManager Ŭ������  adminCheck ȣ�� --> MemberMapper �������̽��� adminCheck �� ���� �Է¹��� ������ �̸��ϰ� ��й�ȣ�� ��Ȯ���� üũ
	 *     (���ϰ�  0 : �̸���, ��й�ȣ�� ��Ȯ���� ����) 
	 * 
	 */
	public void surveyAdministrator() {
		int result = 0;
		String email = null;
		String password = null;

		try {
			System.out.print("Input your Email : ");	email = input.nextLine();
			System.out.print("Input your Password : ");	password = input.nextLine();
			result = dao.adminCheck(email, password);

			if(result == 0) throw new Exception("Wrong Email or password. Please retry!");

		} catch(Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		registSurvey();
	}
	
	/**
	 * ������ ��� �ϱ� ���� �޴� (Administrator)
	 **/
	public void registSurvey() {
		String sMenu = null;

		while(true) {
			try {
				registSurveyMenu();
				sMenu = input.next();
				input.nextLine();

				switch(sMenu){
				case "1" : registQuestion(); 	break;	// ���� ���
				case "2" : viewSurveyList();	break; 	// ��ϵ� ���� ����
				case "3" : statSurvey();		break;	// ��� ����
				case "9" : return;
				default :
					throw new Exception();
				}
			} catch(Exception e) {
				System.out.println(">> �����߻�. �ٽ� �Է��� �ּ���");
				input.nextLine();
				continue;
			}
		}
	}
	
	/**
	 * ���� �����ڰ� �������� ���� ����� ��ȸ�� �� �ش� ������ ���� ������ �ϸ� ������ ���� �����Ͽ� ��� �ϵ��� �Ѵ�.
	 * 
	 *     1) �������� ���� ��� ��ȸ : SurveyDAOManager Ŭ������ viewSurveyList ȣ�� --> SurveyMapper�� viewSurveyList�� �̿��� ��ȸ�Ͽ� ȭ�鿡 ���
	 *     2) ������������ �̸��ϰ� ������ȣ ��ȸ : SurveyDAOManager Ŭ������ checkAnswer ȣ�� --> SurveyMapper�� checkAnswer�� �̿��� ���� ������ ������ �� �ִ��� ��ȸ��
	 *     3) ���������� ���� ��� �ش� ������ ������ ȭ�鿡 ��� : SurveyDAOManager Ŭ������ viewQuestion ȣ�� --> SurveyMapper�� viewQuestion�� �̿���  �ش� ������ ��� ������ List�� ����
	 *     4) �����ڰ� �� ���� ������ ������ ���� : SurveyDAOManager Ŭ������ insertAnswer ȣ�� --> SurveyMapper�� insertAnswer�� ���� �亯�� ����
	 * 
	 * @throws Exception
	 */
	private void participantSurvey() throws Exception{
		// ������ ���� ���
		while(true) {
			System.out.println("\n[ ���� �����ϱ� ]");
			System.out.println("���� ���� ���� ������ �Ʒ��� �����ϴ�.");
			
			
			// DB�� ���� ���� ����� ��ȣ�� ���� ������ ��� ����� ��ȸ�� �� ����ϴ� �ڵ带 �ϼ��Ͻÿ�
			// 1) Code Here
			
			
			
			
			
			
			System.out.print(">> �����ϰ��� �ϴ� ���� ��ȣ : ");
			int survey_id = input.nextInt();
			
			input.nextLine();			// ���� ����
			
			System.out.print(">> Email�� �Է��ϼ��� : ");
			String email = input.nextLine();

			// DB�� ���� ����ڰ� ������ ���� ������ ������ �� �ִ��� Ȯ���Ͽ� ������ ���� ���� ��� �޽����� ��� �� �������� ���ư���  �ڵ� �ϼ�
			// 2) Code Here

			
			
			
			
			
			
			
			if(email.trim().length() < 1) {
				System.out.println(">> ���� : EMail�� �Է��� �ּ���..");
				continue;
			}
			List<Question> question = dao.viewQuestion(survey_id);
			
			for(int i=0; i<question.size(); i++ ) {
				System.out.println((i+1) + ". " + question.get(i).getQuestion());
				System.out.println("  1) " + question.get(i).getAnswer1());
				System.out.println("  2) " + question.get(i).getAnswer2());
				System.out.println("  3) " + question.get(i).getAnswer3());
				System.out.println("  4) " + question.get(i).getAnswer4());
				System.out.println("  5) " + question.get(i).getAnswer5());
				System.out.print  ( "   �亯 : "); 
				int answer = input.nextInt();
				
				Answer ans = new Answer();
				
				ans.setSurvey_id(survey_id);
				ans.setQuestion_id(question.get(i).getQuestion_id());
				ans.setEmail(email);
				ans.setAnswer(answer);
				
				dao.insertAnswer(email,  survey_id , question.get(i).getQuestion_id() , answer);
			}
			System.out.println("\n** ���� ���簡 �������ϴ�. ������ �ּż� �����մϴ�.");
			return;
		}
	}

	/**
	 * ���� ����� ���
	 *    SurveyDAOManager Ŭ������ viewSurveyList ȣ�� --> 
	 *    SurveyMapper�� viewSurveyList �޼��带 ���� ���� ����� list�� ���� ���
	 */
	private void viewSurveyList() {
		// Code Here
		List<Survey> list = dao.viewSurveyList();	 /*SurveyDAOManager Ŭ������ viewSurveyList ȣ���ؼ� ����Ʈ�� ��� */ 
		
		System.out.println(list.size());  ////
		for (Survey survey : list) {
			System.out.println(survey.toString());
		}	////
		
		// ���� ���蹮���� �𸣹Ƿ� �뷫������ ���ڰ� ������ֽ�
		for (Survey survey : list) {
			int survey_id = survey.getSurvey_id();
			String title = survey.getTitle();
			String startdate = survey.getStartdate();
			String enddate = survey.getEnddate();
			System.out.println("���� ��ȣ : " + survey_id + "\n");
			System.out.println("���� ���� : " + title + "\n");
			System.out.println("���� ��¥ : " + startdate + "\n");
			System.out.println("���� ��¥ : " + enddate);
		}
		
	}

	/**
	 * ������ ������ ������� ��Ը� ��ȸ�Ͽ� ���
	 *    SurveyDAOManager Ŭ������  viewSurveyList ȣ�� --> SurveyMapper�� viewSurveyList�� ���� ���� ��� ����� ���� ȭ�鿡 ���
	 *    
	 * ������ �� ��ȸ
	 * 	  SurveyDAOManager Ŭ������ countAnswer ȣ�� --> SurveyMapper�� countAnswer�� ����  ������ ������ ����� �ο����� ��ȸ�� �� ȭ�鿡 ���
	 * 
	 * Ư�� ������ ���� ����Ƚ�� ��ȸ
	 *    SurveyDAOManager Ŭ������ statSurvey ȣ�� --> SurveyMapper�� statSurvey�� ���� Ư�� ������ȣ�� ���� ����Ƚ�� ��ȸ�Ͽ� ȭ�鿡 ���
	 *    
	 * @throws Exception
	 */
	private void statSurvey() throws Exception{
		System.out.println("\n[ ���� ��� ���� ]");

		List<Survey> survey = dao.viewSurveyList();
		
		System.out.println("���� ���� ���� ������ �Ʒ��� �����ϴ�. ��踦 ���� ���� ���� ��ȣ�� �Է��� �ּ���");

		for(int i=0; i<survey.size(); i++) {
			System.out.print("** ���� ��ȣ : " + survey.get(i).getSurvey_id());
			System.out.println("\t ���� ���� : " + survey.get(i).getTitle());
		}

		System.out.print(">> ��� Ȯ���� ���� ��ȣ : ");
		int survey_id = input.nextInt();

		// ������ �� ��ȸ�Ͽ� �����ڰ� ������ ���� ȭ������ �ǵ��ư���.
		int count = dao.countAnswer(survey_id);
		if(count < 1) {
			System.out.println("** ����� ������ �����ϴ�. ");
			return;
		}
		
		System.out.println("\n>>> �� ���� ������ �� : " + count+"��");
		
		// �� ��信 ���� Ƚ��
		List<StatSurvey> statSurvey = dao.statSurvey(survey_id);

		// ��� ���
		for(int i=0; i<statSurvey.size(); i++) {
			System.out.println((i+1) +")" + statSurvey.get(i).getQuestion());
			System.out.println("   "+ statSurvey.get(i).getAnswer1()+ " => " + statSurvey.get(i).getCnt1()+"��");
			System.out.println("   "+ statSurvey.get(i).getAnswer2()+ " => " + statSurvey.get(i).getCnt2()+"��");
			System.out.println("   "+ statSurvey.get(i).getAnswer3()+ " => " + statSurvey.get(i).getCnt3()+"��");
			System.out.println("   "+ statSurvey.get(i).getAnswer4()+ " => " + statSurvey.get(i).getCnt4()+"��");
			System.out.println("   "+ statSurvey.get(i).getAnswer5()+ " => " + statSurvey.get(i).getCnt5()+"��");
			System.out.println();
		}
	}

	/**
	 * ������ �����
	 *    Ű����κ��� ��������� ����Ⱓ�� �Է¹޾�  SurveyDAOManager Ŭ������ insertSurvey ȣ�� --> SurveyMapper�� insertServey()�� ���� DB�� ���
	 *    ����� �Ϸ�Ǹ� �ش� ������ �亯����� �Է¹ޱ� ����  registerAnswer() �޼��� ȣ�� 
	 * @throws Exception
	 */
	private void registQuestion() throws Exception {
		System.out.println("[ ���� ��� ] ");
		System.out.println("  * �ϳ��� ������ ���� �亯�� 5�� �Է��ؾ� �մϴ�. �亯 ����� ������ �� ���  Enter�� ġ����");
		System.out.print  ("  * ���� ������ �Է��ϼ��� : ");
		
		String title = input.nextLine(); 	// ��) ��Ʃ�� �Ϸ� ��� �ð��� ���� ����

		System.out.println("  * ���� ���� �Ⱓ : ");
		System.out.println("    �� �Ϸ�");
		System.out.println("    �� ������");
		System.out.println("    �� 15��");
		System.out.println("    �� �Ѵ�");
		System.out.println("    �� 6����");
		System.out.print  ("    >> ���� ����Ⱓ�� �����ϼ��� : "); 
		
		int term = Integer.parseInt(input.next());
		input.nextLine();
		
		int result = dao.insertSurvey(title, term);
		if (result != 1) {
			System.out.println("Error!!");
			return ;
		}
		registerAnswer();
	}

	/**
	 * ������ ���� �亯 ���
	 *     ����ϰ��� �ϴ� �亯�� �Է¹޾� ArrayList�� ���� ��  SurveyDAOManager Ŭ������ insertQuestion ȣ�� --> SurveyMapper�� insertQuestion�� ��� DB�� ����
	 */
	private void registerAnswer() {
		String question = null;
		
		// ���� ���
		for(int i=0; i<20; i++){
			System.out.print ("\n"+ (i+1) + "��° ���� ��� : ");
			question = input.nextLine();
			if(question == null || question.trim().length() == 0) {
				System.out.println("** ���� ����� ��Ĩ�ϴ�. ���� ȭ������ �̵��մϴ�.");
				break;
			}
			List<String> answer = new ArrayList<>();
			
			// ������ ���� �亯�� ����ϴ� �ڵ�. �亯�� �� 5�� �̹Ƿ� 5�� �ݺ��ؼ� �亯 ����� �޾ƾ� �Ѵ�.
			// �亯�� 1~5 ������ ��ȣ�� �ƴ� ��ȣ�� �Էµ� ��� �ٽ� �Է¹޴´�.
			// ����� �ϼ��� �亯�� ���� answer List�� �߰��Ѵ�.
			
			for(int j=0; j<5; j++) {
				// 3) Code Here
				System.out.print ("\n"+ (j+1) + "��° �亯 ��� : ");
				String answerStr= input.nextLine();
				if(answerStr == null || answerStr.trim().length() == 0) {
					System.out.println("** ���� ����� ��Ĩ�ϴ�. ���� ȭ������ �̵��մϴ�.");
					break;
				} else {
					answer.add(answerStr);
				}
				
			}
			// ������ �ϳ��� �Ϸ� �ɶ����� DB�� �����Ѵ�.
			dao.insertQuestion(question, answer);
		} // End for
	}
}
