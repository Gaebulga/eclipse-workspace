package global.sesoc.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import global.sesoc.vo.Answer;
import global.sesoc.vo.Member;
import global.sesoc.vo.Question;
import global.sesoc.vo.Survey;
import global.sesoc.vo.StatSurvey;

public class SurveyDAOManager {
	/**
	 * �������� �̸��ϰ� ��й�ȣ�� �̿��� ��й�ȣ�� �̸����� ��Ȯ���� �Ǵ��Ͽ� �� ����� ����
	 * @param email ������ �̸���
	 * @param password ������ ��й�ȣ
	 * @return �̸��ϰ� ��й�ȣ�� ��Ȯ���� ���θ� ���� (1:���̵�� ��й�ȣ�� ��Ȯ�� ��� ����, 0: ���̵� ��й�ȣ�� ��Ȯ���� ���� ��� ����)
	 */
	public int adminCheck(String email, String password) {
		SqlSession session = MybatisConfig.getSqlSessionFactory().openSession();
		
		Map<String, String> map = new HashMap<>();
		map.put("email", email);
		map.put("password", password);
		
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		Member member = mapper.selectOne(map);
		
		if(member != null && member.getEmail().equals(email) && member.getPassword().equals(password)) {
			session.close();
			return 1;
		}
		session.close();		
		return 0;
	}
	
	/**
	 * ���� ����� �Է� ���� ���� �Ⱓ�� �����ϴ� �޼���
	 * @param title ��������(��������)
	 * @param term ���� �Ⱓ
	 * @return DB �Է� ���� ���� 
	 */

	public int insertSurvey(String title, int term) {
		SqlSession session = MybatisConfig.getSqlSessionFactory().openSession();
		
		Map<String, Object> survey = new HashMap<>();
		survey.put("title", title);
		survey.put("term", term);
		
		SurveyMapper mapper = session.getMapper(SurveyMapper.class);
		int result = mapper.insertSurvey(survey);
		
		session.commit();
		session.close();	
		
		return result;
		
	}

	/**
	 * ���� ����� �亯�� ���޹޾� DB�� �����ϴ� �޼���
	 * �̶� �̹� ���� ��ȣ�� ����Ǿ� �����Ƿ� ������ ���� ��ȣ�� ��ȸ�Ͽ� �ش� ������ȣ�� VO ���� setting �ؾ� �Ѵ�.
	 * @param q ���� ����
	 * @param answer �亯���� 5���� ���� List
	 * @return
	 */
	public int insertQuestion(String q, List<String> answer) {
		SqlSession session = MybatisConfig.getSqlSessionFactory().openSession();
		
		Question question = new Question();

		question.setQuestion(q);
		question.setAnswer1(answer.get(0));
		question.setAnswer2(answer.get(1));
		question.setAnswer3(answer.get(2));
		question.setAnswer4(answer.get(3));
		question.setAnswer5(answer.get(4));
		
		SurveyMapper mapper = session.getMapper(SurveyMapper.class);
		int survey_id = mapper.selectSurveyId();
		
		question.setSurvey_id(survey_id);
		
		int result = mapper.insertQuestion(question);
		
		session.commit();
		session.close();	
		
		return result;
	}

	/**
	 * ���� �������� ������ ���� ����� DB���� ���� �� �����ϴ� �޼���
	 * @return DB�� ���� ���� ���� �������� ���� ��� List
	 */
	public List<Survey> viewSurveyList() {
		// 1) Code here
		 /*SurveyMapper�� viewSurveyList �޼��带 ���� ���� ����� list�� ���� ���*/
		SqlSession session = MybatisConfig.getSqlSessionFactory().openSession();
		
		SurveyMapper mapper = session.getMapper(SurveyMapper.class);
		List<Survey> listSurvey = mapper.viewSurveyList();
		
		session.close();
		return listSurvey;
	}
	
	/**
	 * ��踦 ���� ���Ͽ� Ư�� ������ ���� ����� Ƚ����  ��ȸ�� �� �� ����� �����ϴ� �޼���
	 * @param survey_id ������ ���� 
	 * @return DB�� ���� ���� ���� ���� ��� �ڷ� List
	 */
	public List<StatSurvey> statSurvey(int survey_id) {

		// Code Here
		
		
		
		
		
		
		return null;
	}

	/**
	 * ������ ������ ����ڰ� ȭ�鿡 �� �亯 ����� DB���� ��ȸ�Ͽ� �����ϴ� �޼���
	 * @param survey_id ���� ���� ��ȣ
	 * @return �亯 ��� List
	 */
	public List<Question> viewQuestion(int survey_id) {
		SqlSession session = MybatisConfig.getSqlSessionFactory().openSession();
		
		SurveyMapper mapper = session.getMapper(SurveyMapper.class);
		List<Question> listQuestion = mapper.viewQuestion(survey_id);
		
		session.close();
		return listQuestion;
	}

	/**
	 * ������ ������ ������� �亯�� DB�� �����ϱ� ���� map ��ü�� �����Ͽ� ����ϴ� �޼��� 
	 * @param email ����ڷκ��� �Է¹��� �̸���
	 * @param survey_id ���� ��ȣ
	 * @param question_id �ϳ��� ������ ���� ���� ��ȣ
	 * @param answer ����ڰ� ������ ��ȣ
	 */
	public void insertAnswer(String email, int survey_id, int question_id, int answer) {
		SqlSession session = MybatisConfig.getSqlSessionFactory().openSession();
		
		Map<String, Object> map = new HashMap<>();
		map.put("email", email);
		map.put("survey_id", survey_id);
		map.put("question_id", question_id);
		map.put("answer", answer);
		
		SurveyMapper mapper = session.getMapper(SurveyMapper.class);
		mapper.insertAnswer(map);
		
		session.commit();
		session.close();
		return ;
	}

	/**
	 * ������ ���� ������ ������ ��������� Ȯ���ϱ� ���� ���� ��ȣ�� �̸����� Map�� �־� ��ȸ�ϴ� �޼���
	 * @param survey_id ������ȣ
	 * @param email ����� �̸���
	 * @return ��ȸ����� ���޹��� ���
	 */
	public Answer checkAnswer(int survey_id, String email) {
		SqlSession session = MybatisConfig.getSqlSessionFactory().openSession();
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("survey_id", survey_id);
		map.put("email", email);
		
		SurveyMapper mapper = session.getMapper(SurveyMapper.class);
		Answer answer = mapper.checkAnswer(map);
		
		session.close();
		return answer;
	}

	/**
	 * ������ ������ �ο����� DB�κ��� ���� �� ����
	 * @param survey_id ������ȣ
	 * @return ������ ������ ������ ��.
	 */
	public int countAnswer(int survey_id) {
		
		// Code Here
		
		
		
		
		
		
		
		
		
		return 0;
	}
}
