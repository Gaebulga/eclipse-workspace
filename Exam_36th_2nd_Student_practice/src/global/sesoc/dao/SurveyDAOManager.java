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
	 * 관리자의 이메일과 비밀번호를 이용해 비밀번호와 이메일이 정확한지 판단하여 그 결과를 리턴
	 * @param email 관리자 이메일
	 * @param password 관리자 비밀번호
	 * @return 이메일과 비밀번호가 정확한지 여부를 리턴 (1:아이디와 비밀번호가 정확한 경우 리턴, 0: 아이디나 비밀번호가 정확하지 않은 경우 리턴)
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
	 * 설문 제목과 입력 받은 조사 기간을 저장하는 메서드
	 * @param title 설문제목(설문주제)
	 * @param term 조사 기간
	 * @return DB 입력 성공 여부 
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
	 * 질문 내용과 답변을 전달받아 DB에 저장하는 메서드
	 * 이때 이미 설문 번호가 저장되어 있으므로 마지막 설문 번호를 조회하여 해당 설문번호도 VO 내에 setting 해야 한다.
	 * @param q 질문 내용
	 * @param answer 답변내용 5개를 담은 List
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
	 * 현재 진행중인 설문에 대한 목록을 DB에서 얻어온 후 리턴하는 메서드
	 * @return DB로 부터 얻어온 현재 진행중인 설문 목록 List
	 */
	public List<Survey> viewSurveyList() {
		// 1) Code here
		 /*SurveyMapper의 viewSurveyList 메서드를 통해 설문 목록을 list로 얻어와 출력*/
		SqlSession session = MybatisConfig.getSqlSessionFactory().openSession();
		
		SurveyMapper mapper = session.getMapper(SurveyMapper.class);
		List<Survey> listSurvey = mapper.viewSurveyList();
		
		session.close();
		return listSurvey;
	}
	
	/**
	 * 통계를 보기 위하여 특정 질문에 대한 대답의 횟수를  조회한 후 그 목록을 리턴하는 메서드
	 * @param survey_id 설문에 대한 
	 * @return DB로 부터 얻은 현재 설문 통계 자료 List
	 */
	public List<StatSurvey> statSurvey(int survey_id) {

		// Code Here
		
		
		
		
		
		
		return null;
	}

	/**
	 * 설문에 참여한 사용자가 화면에 볼 답변 목록을 DB에서 조회하여 리턴하는 메서드
	 * @param survey_id 현재 설문 번호
	 * @return 답변 목록 List
	 */
	public List<Question> viewQuestion(int survey_id) {
		SqlSession session = MybatisConfig.getSqlSessionFactory().openSession();
		
		SurveyMapper mapper = session.getMapper(SurveyMapper.class);
		List<Question> listQuestion = mapper.viewQuestion(survey_id);
		
		session.close();
		return listQuestion;
	}

	/**
	 * 설문에 응답한 사용자의 답변을 DB에 저장하기 위해 map 객체를 생성하여 사용하는 메서드 
	 * @param email 사용자로부터 입력받은 이메일
	 * @param survey_id 설문 번호
	 * @param question_id 하나의 설문에 대한 질문 번호
	 * @param answer 사용자가 응답한 번호
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
	 * 이전에 같은 설문에 응답한 사용자인지 확인하기 위해 설문 번호와 이메일을 Map에 넣어 조회하는 메서드
	 * @param survey_id 설문번호
	 * @param email 사용자 이메일
	 * @return 조회결과를 전달받은 목록
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
	 * 설문에 참여한 인원수를 DB로부터 얻어온 후 리턴
	 * @param survey_id 설문번호
	 * @return 설문에 참여한 참여자 수.
	 */
	public int countAnswer(int survey_id) {
		
		// Code Here
		
		
		
		
		
		
		
		
		
		return 0;
	}
}
