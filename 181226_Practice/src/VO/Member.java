package VO;

public class Member {
	private String userId;
	private String userPw;
	
	public Member(String userId, String userPw) {
		super();
		this.userId = userId;
		this.userPw = userPw;
	}
	
	
	public Member() {
		super();
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	
	@Override
	public String toString() {
		return "Member [userId=" + userId + ", userPw=" + userPw + "]";
	}
	
	
}
