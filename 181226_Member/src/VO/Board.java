package VO;

public class Board {
	private String userId;
	private String message;
	// 얘는 지워도 마이바티스가 돌아가지만, 사용자의 편의(SET을 안쓰기 위해서)
	public Board(String userId, String message) {
		super();
		this.userId = userId;
		this.message = message;
	}
	// 기본생성자를 지우면 안돌아간다.

	public Board() {
		super();
	}
	
	//	저런.. 마이바티스에서는 getter/setter가 없으면 사용할 수 없다.

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	//	얘도 없어도 됨.   사용자의 편의를 위해서. 
	@Override
	public String toString() {
		return "Board [userId=" + userId + ", message=" + message + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
