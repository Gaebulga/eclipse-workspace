package global.sesoc.vo;

public class StatSurvey {
	private int survey_id;				// ������ȣ
	private int question_id;			// �ش� ���� �������� ������ȣ
	private String question;			// ����
	private String answer1;				// �亯1
	private int cnt1;					// 1���� ���� �亯 Ƚ��
	private String answer2;				// �亯2
	private int cnt2;					// 2���� ���� �亯 Ƚ��
	private String answer3;				// �亯3
	private int cnt3;					// 3���� ���� �亯 Ƚ��
	private String answer4;				// �亯4
	private int cnt4;					// 4���� ���� �亯 Ƚ��
	private String answer5;				// �亯5
	private int cnt5;					// 5���� ���� �亯 Ƚ��
	
	public StatSurvey() {
		// TODO Auto-generated constructor stub
	}

	public int getSurvey_id() {
		return survey_id;
	}

	public void setSurvey_id(int survey_id) {
		this.survey_id = survey_id;
	}

	public int getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer1() {
		return answer1;
	}

	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public int getCnt1() {
		return cnt1;
	}

	public void setCnt1(int cnt1) {
		this.cnt1 = cnt1;
	}

	public String getAnswer2() {
		return answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	public int getCnt2() {
		return cnt2;
	}

	public void setCnt2(int cnt2) {
		this.cnt2 = cnt2;
	}

	public String getAnswer3() {
		return answer3;
	}

	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}

	public int getCnt3() {
		return cnt3;
	}

	public void setCnt3(int cnt3) {
		this.cnt3 = cnt3;
	}

	public String getAnswer4() {
		return answer4;
	}

	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}

	public int getCnt4() {
		return cnt4;
	}

	public void setCnt4(int cnt4) {
		this.cnt4 = cnt4;
	}

	public String getAnswer5() {
		return answer5;
	}

	public void setAnswer5(String answer5) {
		this.answer5 = answer5;
	}

	public int getCnt5() {
		return cnt5;
	}

	public void setCnt5(int cnt5) {
		this.cnt5 = cnt5;
	}

	@Override
	public String toString() {
		return "StatSurvey [survey_id=" + survey_id + ", question_id=" + question_id + ", question=" + question
				+ ", answer1=" + answer1 + ", cnt1=" + cnt1 + ", answer2=" + answer2 + ", cnt2=" + cnt2 + ", answer3="
				+ answer3 + ", cnt3=" + cnt3 + ", answer4=" + answer4 + ", cnt4=" + cnt4 + ", answer5=" + answer5
				+ ", cnt5=" + cnt5 + "]";
	}
}
