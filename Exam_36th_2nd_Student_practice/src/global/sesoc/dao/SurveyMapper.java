package global.sesoc.dao;

import java.util.List;
import java.util.Map;

import global.sesoc.vo.Answer;
import global.sesoc.vo.Question;
import global.sesoc.vo.Survey;
import global.sesoc.vo.StatSurvey;

public interface SurveyMapper {
	/**
	 * 설문을 등록하는 메서드
	 * @param survey
	 * @return 등록에 대한 결과 리턴
	 */
	public int insertSurvey(Map<String, Object> survey);
	
	/**
	 * 현재 설문 번호를 조회하는 메서드
	 * @return 조회된 현재 설문 번호
	 */
	public int selectSurveyId();
	
	/**
	 * 하나의 질문에 답변 5개를 VO에 담아 등록하는 메서드
	 * @param question 질문에 대한 답변이 저장된 VO 객체
	 * @return 등록된 결과 리턴
	 */
	public int insertQuestion(Question question);
	
	/**
	 * 조사 종료일을 넘기지 않은 설문 목록을 조회하는 메서드
	 * @return
	 */
	public List<Survey> viewSurveyList();
	
	/**
	 * 설문 번호에 해당하는 질문목록을 조회하는 메서드
	 * @param survey_id 조회하고자 하는 설문번호
	 * @return 질문 목록 
	 */
	public List<Question> viewQuestion(int survey_id);
	
	/**
	 * 설문 번호에 해당하는 통계를 조회하는 메서드
	 * @param survey_id 설문번호
	 * @return 질문에 대한 답변자의 목록을 담을 List를 반환
	 */
	public List<StatSurvey> statSurvey(int survey_id);
	
	/**
	 * 질문에 참여한 사용자가 응답한 질의를 저장하는 메서드
	 * @param map 답변이 저장된 Map객체
	 */
	public int insertAnswer(Map<String, Object> map);
	
	/**
	 * 사용자가 이전에 같은 설문에 참여한적이 있는지 조회하는 메서드
	 * @param map 사용자 이메일과 설문번호가 저장된 Map 객체
	 * @return 답변에 대한 
	 */
	public Answer checkAnswer(Map<String, Object> map);
	
	
	/**
	 * 설문 번호에 해당하는 응답에 대한 횟수를 조회하는 메서드
	 * @param survey_id 설문번호
	 * @return 응답 횟수
	 */
	public int countAnswer(int survey_id);
}
