package global.sesoc.vo;

public class Member {
	private String email;		// 관리자 이메일
	private String password;	// 관리자 비밀번호

	public Member() { }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Member [email=" + email + ", password=" + password + "]";
	}
}
