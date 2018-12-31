package global.sesoc.vo;

public class Question {
	private int question_id;	// ������ȣ
	private int survey_id;		// ���� ��ȣ
	private String question;	// ������ ���� ����
	private String answer1;		// ������ ù ��° �亯
	private String answer2;		// ������ �� ��° �亯
	private String answer3;		// ������ �� ��° �亯
	private String answer4;		// ������ �� ��° �亯
	private String answer5;		// ������ �ټ� ��° �亯
	
	public Question() { }

	public int getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}

	public int getSurvey_id() {
		return survey_id;
	}

	public void setSurvey_id(int survey_id) {
		this.survey_id = survey_id;
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

	public String getAnswer2() {
		return answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	public String getAnswer3() {
		return answer3;
	}

	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}

	public String getAnswer4() {
		return answer4;
	}

	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}

	public String getAnswer5() {
		return answer5;
	}

	public void setAnswer5(String answer5) {
		this.answer5 = answer5;
	}

	@Override
	public String toString() {
		return "Question [question_id=" + question_id + ", survey_id=" + survey_id + ", question=" + question
				+ ", answer1=" + answer1 + ", answer2=" + answer2 + ", answer3=" + answer3 + ", answer4=" + answer4
				+ ", answer5=" + answer5 + "]";
	}
}
