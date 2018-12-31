package global.sesoc.dao;

import java.util.List;
import java.util.Map;

import global.sesoc.vo.Answer;
import global.sesoc.vo.Question;
import global.sesoc.vo.Survey;
import global.sesoc.vo.StatSurvey;

public interface SurveyMapper {
	/**
	 * ������ ����ϴ� �޼���
	 * @param survey
	 * @return ��Ͽ� ���� ��� ����
	 */
	public int insertSurvey(Map<String, Object> survey);
	
	/**
	 * ���� ���� ��ȣ�� ��ȸ�ϴ� �޼���
	 * @return ��ȸ�� ���� ���� ��ȣ
	 */
	public int selectSurveyId();
	
	/**
	 * �ϳ��� ������ �亯 5���� VO�� ��� ����ϴ� �޼���
	 * @param question ������ ���� �亯�� ����� VO ��ü
	 * @return ��ϵ� ��� ����
	 */
	public int insertQuestion(Question question);
	
	/**
	 * ���� �������� �ѱ��� ���� ���� ����� ��ȸ�ϴ� �޼���
	 * @return
	 */
	public List<Survey> viewSurveyList();
	
	/**
	 * ���� ��ȣ�� �ش��ϴ� ��������� ��ȸ�ϴ� �޼���
	 * @param survey_id ��ȸ�ϰ��� �ϴ� ������ȣ
	 * @return ���� ��� 
	 */
	public List<Question> viewQuestion(int survey_id);
	
	/**
	 * ���� ��ȣ�� �ش��ϴ� ��踦 ��ȸ�ϴ� �޼���
	 * @param survey_id ������ȣ
	 * @return ������ ���� �亯���� ����� ���� List�� ��ȯ
	 */
	public List<StatSurvey> statSurvey(int survey_id);
	
	/**
	 * ������ ������ ����ڰ� ������ ���Ǹ� �����ϴ� �޼���
	 * @param map �亯�� ����� Map��ü
	 */
	public int insertAnswer(Map<String, Object> map);
	
	/**
	 * ����ڰ� ������ ���� ������ ���������� �ִ��� ��ȸ�ϴ� �޼���
	 * @param map ����� �̸��ϰ� ������ȣ�� ����� Map ��ü
	 * @return �亯�� ���� 
	 */
	public Answer checkAnswer(Map<String, Object> map);
	
	
	/**
	 * ���� ��ȣ�� �ش��ϴ� ���信 ���� Ƚ���� ��ȸ�ϴ� �޼���
	 * @param survey_id ������ȣ
	 * @return ���� Ƚ��
	 */
	public int countAnswer(int survey_id);
}
