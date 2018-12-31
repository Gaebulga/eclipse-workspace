package VO;

public class Board {
	private String userId;
	private String message;
	// ��� ������ ���̹�Ƽ���� ���ư�����, ������� ����(SET�� �Ⱦ��� ���ؼ�)
	public Board(String userId, String message) {
		super();
		this.userId = userId;
		this.message = message;
	}
	// �⺻�����ڸ� ����� �ȵ��ư���.

	public Board() {
		super();
	}
	
	//	����.. ���̹�Ƽ�������� getter/setter�� ������ ����� �� ����.

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
	
	//	�굵 ��� ��.   ������� ���Ǹ� ���ؼ�. 
	@Override
	public String toString() {
		return "Board [userId=" + userId + ", message=" + message + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}