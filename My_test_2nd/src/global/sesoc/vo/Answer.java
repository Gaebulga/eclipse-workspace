package global.sesoc.vo;

public class Answer {
	private int answer_id;		// 답변 번호
	private String email;		// 설문에 참여하는 사람의 이메일
	private int survey_id;		// 설문 번호
	private int question_id;	// 질문 번호
	private int answer;			// 설문 참여자의 답변번호 

	public Answer() {
		// TODO Auto-generated constructor stub
	}

	public int getAnswer_id() {
		return answer_id;
	}

	public void setAnswer_id(int answer_id) {
		this.answer_id = answer_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Answer [answer_id=" + answer_id + ", email=" + email + ", survey_id=" + survey_id + ", question_id="
				+ question_id + ", answer=" + answer + "]";
	}
	
}

