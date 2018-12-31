package acc.dto;

public class Account {
	private String accNo; // 계좌 번호 (primary key)
	private String owner; // 계좌주 이름 (not null)
	private String password; // 계좌비밀번호 (not null)
	private int balance; // 계좌 잔고 (입력없으면 default 0)
	private double interest; // 계좌 이율 (입력없으면 default 0.10)

}
