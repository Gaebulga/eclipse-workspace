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
	 * 생성자
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
					surveyAdministrator();	// 설문 등록
					break;
				case "2":
					participantSurvey();	// 설문 참여
					break;
				case "9":					// 종료
					System.out.println("*** 설문에 참여해 주셔서 감사합니다. 프로그램 종료합니다.");
					return;
				default : 
					System.out.println("오류 >> 입력을 잘못하였습니다. 다시 입력해 주세요");
					continue;
				}
			} catch (Exception e) {
				System.out.println(">> 오류발생. 다시 입력해 주세요");
				input.nextLine();
				continue;
			}
		}
	}

	/**
	 * 주 메뉴 화면
	 */
	public void mainMenu() {
		System.out.println("\n[ SCIT MASTER 설문조사 ]");
		System.out.println("1. 설문 관리 (관리자 계정)");
		System.out.println("2. 설문 참여");
		System.out.println("9. 종료");
		System.out.print  ("** 메뉴 선택 : ");
	}
	
	/**
	 * 설문을 등록하기 위한 메뉴 화면
	 */
	public void registSurveyMenu() {
		System.out.println("\n[ SCIT MASTER 설문 관리 (Administrator Only) ]");
		System.out.println("1. 설문 등록");
		System.out.println("2. 등록된 설문 보기");
		System.out.println("3. 통계 보기");
		System.out.println("9. 이전 메뉴");
		System.out.print  ("** 메뉴 선택 : ");
	}
	
	/**
	 * 관리자가 설문을 추가하기 위한 메뉴. 관리자만이 설문을 등록할 수 있다.
	 * 이메일과 비밀번호를 입력하여 관리자 이메일과 비밀번호가 맞을 경우에만 등록할 수 있는 화면으로 이동한다.
	 *     SurveyDAOManager 클래스의  adminCheck 호출 --> MemberMapper 인터페이스의 adminCheck 를 통해 입력받은 관리자 이메일과 비밀번호가 정확한지 체크
	 *     (리턴값  0 : 이메일, 비밀번호가 정확하지 않음) 
	 * 
	 */
	public void surveyAdministrator() {
		int result = 0;
		String email = null;
		String password = null;

		try {
			System.out.print("Input your Email : ");	email = input.next();
			System.out.print("Input your Password : ");	password = input.next();
			result = dao.adminCheck(email, password);

			if(result == 0) throw new Exception("Wrong Email or password. Please retry!");

		} catch(Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		registSurvey();
	}
	
	/**
	 * 설문을 등록 하기 위한 메뉴 (Administrator)
	 **/
	public void registSurvey() {
		String sMenu = null;

		while(true) {
			try {
				registSurveyMenu();
				sMenu = input.next();
				input.nextLine();

				switch(sMenu){
				case "1" : registQuestion(); 	break;	// 질문 등록
				case "2" : viewSurveyList();	break; 	// 등록된 질문 보기
				case "3" : statSurvey();		break;	// 통계 보기
				case "9" : return;
				default :
					throw new Exception();
				}
			} catch(Exception e) {
				System.out.println(">> 오류발생. 다시 입력해 주세요");
				input.nextLine();
				continue;
			}
		}
	}
	
	/**
	 * 설문 참여자가 진행중인 설문 목록을 조회한 후 해당 설문에 대한 선택을 하면 설문에 각각 참여하여 등록 하도록 한다.
	 * 
	 *     1) 진행중인 설문 목록 조회 : SurveyDAOManager 클래스의 viewSurveyList 호출 --> SurveyMapper의 viewSurveyList를 이용해 조회하여 화면에 출력
	 *     2) 설문참여자의 이메일과 설문번호 조회 : SurveyDAOManager 클래스의 checkAnswer 호출 --> SurveyMapper의 checkAnswer를 이용해 같은 설문에 참여한 적 있는지 조회함
	 *     3) 참여한적이 없을 경우 해당 설문의 질문을 화면에 출력 : SurveyDAOManager 클래스의 viewQuestion 호출 --> SurveyMapper의 viewQuestion을 이용해  해당 설문의 모든 질문을 List로 얻어옴
	 *     4) 참여자가 한 개씩 응답할 때마다 저장 : SurveyDAOManager 클래스의 insertAnswer 호출 --> SurveyMapper의 insertAnswer를 통해 답변을 저장
	 * 
	 * @throws Exception
	 */
	private void participantSurvey() throws Exception{
		// 설문의 종류 출력
		while(true) {
			System.out.println("\n[ 설문 참여하기 ]");
			System.out.println("현재 진행 중인 설문은 아래와 같습니다.");
			
			
			// DB로 부터 설문 목록의 번호와 설문 제목이 담긴 목록을 조회한 후 출력하는 코드를 완성하시오
			// 1) Code Here
			
			List<Survey> list = dao.viewSurveyList();
			for (int i = 0; i < list.size(); i++) {
				System.out.println("** 설문 번호 : " + (i+1) + "\t설문 제목 : " + list.get(i).getTitle());
			}
			System.out.print(">> 참여하고자 하는 설문 번호 : ");
			int survey_id = input.nextInt();
			
			input.nextLine();			// 버퍼 삭제
			
			System.out.print(">> Email을 입력하세요 : ");
			String email = input.nextLine();

			// DB로 부터 사용자가 이전에 같은 설문에 참여한 적 있는지 확인하여 참여한 적이 있을 경우 메시지를 띄운 후 이전으로 돌아가는  코드 완성
			// 2) Code Here

			
			
			
			
			
			if(email.trim().length() < 1) {
				System.out.println(">> 오류 : EMail을 입력해 주세요..");
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
				System.out.print  ( "   답변 : "); 
				int answer = input.nextInt();
				
				Answer ans = new Answer();
				
				ans.setSurvey_id(survey_id);
				ans.setQuestion_id(question.get(i).getQuestion_id());
				ans.setEmail(email);
				ans.setAnswer(answer);
				
				dao.insertAnswer(email,  survey_id , question.get(i).getQuestion_id() , answer);
			}
			System.out.println("\n** 설문 조사가 끝났습니다. 참여해 주셔서 감사합니다.");
			return;
		}
	}

	/**
	 * 설문 목록의 출력
	 *    SurveyDAOManager 클래스의 viewSurveyList 호출 --> 
	 *    SurveyMapper의 viewSurveyList 메서드를 통해 설문 목록을 list로 얻어와 출력
	 */
	private void viewSurveyList() {
		// Code Here
		
		
		
		
		
		
	}

	/**
	 * 설문에 참여한 사람들의 통게를 조회하여 출력
	 *    SurveyDAOManager 클래스의  viewSurveyList 호출 --> SurveyMapper의 viewSurveyList를 통해 설문 통계 목록을 얻어와 화면에 출력
	 *    
	 * 참여자 수 조회
	 * 	  SurveyDAOManager 클래스의 countAnswer 호출 --> SurveyMapper의 countAnswer를 통해  설문에 참여한 사람의 인원수를 조회한 후 화면에 출력
	 * 
	 * 특정 질문에 대한 응답횟수 조회
	 *    SurveyDAOManager 클래스의 statSurvey 호출 --> SurveyMapper의 statSurvey를 통해 특정 질문번호에 대한 응답횟수 조회하여 화면에 출력
	 *    
	 * @throws Exception
	 */
	private void statSurvey() throws Exception{
		System.out.println("\n[ 설문 통계 보기 ]");

		List<Survey> survey = dao.viewSurveyList();
		
		System.out.println("현재 진행 중인 설문은 아래와 같습니다. 통계를 보고 싶은 설문 번호를 입력해 주세요");

		for(int i=0; i<survey.size(); i++) {
			System.out.print("** 설문 번호 : " + survey.get(i).getSurvey_id());
			System.out.println("\t 설문 제목 : " + survey.get(i).getTitle());
		}

		System.out.print(">> 통계 확인할 설문 번호 : ");
		int survey_id = input.nextInt();

		// 참여자 수 조회하여 참여자가 없으면 이전 화면으로 되돌아간다.
		int count = dao.countAnswer(survey_id);
		if(count < 1) {
			System.out.println("** 조사된 설문이 없습니다. ");
			return;
		}
		
		System.out.println("\n>>> 총 설문 참여자 수 : " + count+"명");
		
		// 총 대답에 대한 횟수
		List<StatSurvey> statSurvey = dao.statSurvey(survey_id);

		// 결과 출력
		for(int i=0; i<statSurvey.size(); i++) {
			System.out.println((i+1) +")" + statSurvey.get(i).getQuestion());
			System.out.println("   "+ statSurvey.get(i).getAnswer1()+ " => " + statSurvey.get(i).getCnt1()+"명");
			System.out.println("   "+ statSurvey.get(i).getAnswer2()+ " => " + statSurvey.get(i).getCnt2()+"명");
			System.out.println("   "+ statSurvey.get(i).getAnswer3()+ " => " + statSurvey.get(i).getCnt3()+"명");
			System.out.println("   "+ statSurvey.get(i).getAnswer4()+ " => " + statSurvey.get(i).getCnt4()+"명");
			System.out.println("   "+ statSurvey.get(i).getAnswer5()+ " => " + statSurvey.get(i).getCnt5()+"명");
			System.out.println();
		}
	}

	/**
	 * 설문을 등록함
	 *    키보드로부터 설문제목과 조사기간을 입력받아  SurveyDAOManager 클래스의 insertSurvey 호출 --> SurveyMapper의 insertServey()를 통해 DB에 등록
	 *    등록이 완료되면 해당 설문의 답변목록을 입력받기 위해  registerAnswer() 메서드 호출 
	 * @throws Exception
	 */
	private void registQuestion() throws Exception {
		System.out.println("[ 설문 등록 ] ");
		System.out.println("  * 하나의 설문에 대한 답변은 5개 입력해야 합니다. 답변 등록을 끝내야 할 경우  Enter를 치세요");
		System.out.print  ("  * 설문 제목을 입력하세요 : ");
		
		String title = input.nextLine(); 	// 예) 유튜브 하루 사용 시간에 관한 조사

		System.out.println("  * 설문 조사 기간 : ");
		System.out.println("    ① 하루");
		System.out.println("    ② 일주일");
		System.out.println("    ③ 15일");
		System.out.println("    ④ 한달");
		System.out.println("    ⑤ 6개월");
		System.out.print  ("    >> 설문 조사기간을 선택하세요 : "); 
		
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
	 * 설문에 대한 답변 등록
	 *     등록하고자 하는 답변을 입력받아 ArrayList에 저장 후  SurveyDAOManager 클래스의 insertQuestion 호출 --> 
	 *     SurveyMapper의 insertQuestion을 통애 DB에 저장
	 */
	private void registerAnswer() {
		String question = null;
		
		// 질문 등록
		for(int i=0; i<20; i++){
			System.out.print ("\n"+ (i+1) + "번째 질문 등록 : ");
			question = input.next();
			if(question == null || question.trim().length() == 0) {
				System.out.println("** 질문 등록을 마칩니다. 이전 화면으로 이동합니다.");
				break;
			}
			List<String> answer = new ArrayList<>();
			
			// 질문에 대한 답변을 등록하는 코드. 답변이 각 5개 이므로 5번 반복해서 답변 등록을 받아야 한다.
			// 답변에 1~5 사이의 번호가 아닌 번호가 입력될 경우 다시 입력받는다.
			// 등록이 완성된 답변은 위의 answer List에 추가한다.
			
			for(int j=0; j<5; j++) {
				// 3) Code Here
				String question2 = null;
				System.out.print ("\t"+ (j+1) + "번째 답변 등록 : ");
				question2 = input.next();
				
				if(question2 == null || question2.trim().length() == 0) {
					break;
				}
				answer.add(j, question2);
			}
			System.out.print("답변 : ");
			int asdf = input.nextInt();
			if (asdf < 1 || asdf > 5) {
				System.out.println("잘못 입력했습니다.");
				return;
			}
			registerAnswer();
			// 질문이 하나씩 완료 될때마다 DB에 저장한다.
			dao.insertQuestion(question, answer);
		} // End for
	}
}
