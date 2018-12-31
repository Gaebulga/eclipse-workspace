package global.sesoc.vo;

public class Survey {
	private int survey_id;		// 설문번호
	private String title;		// 설문 제목
	private String startdate;	// 조사 시작일
	private String enddate;		// 조사 종료일
	
	public Survey() {
		// TODO Auto-generated constructor stub
	}
	
	public int getSurvey_id() {
		return survey_id;
	}
	public void setSurvey_id(int survey_id) {
		this.survey_id = survey_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	@Override
	public String toString() {
		return "Survey [survey_id=" + survey_id + ", title=" + title + ", startdate=" + startdate + ", enddate="
				+ enddate + "]";
	}
}
