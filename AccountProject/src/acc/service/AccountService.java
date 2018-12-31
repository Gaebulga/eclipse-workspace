package acc.service;

import java.util.List;

import acc.dto.Account;
/*
 * Scanner에서 입력받은 값의 null값 검사는 UI에서 걸러낸다.
 */
public class AccountService {
	/**
	 * 인자로 받은 객체(새로 만들 계좌)의 정보 중 계좌번호 중복 검색하고
	 * 비밀번호 조건(영어소문자,숫자 하나씩 포함해서 총 6자리이상) 검사 후
	 * 이상이 없을 시 계좌 객체 데이터에 저장하기 위한 dao 메소드 호출한다.
	 * 리턴값 result을 정하여 호출한 곳으로 반환한다.
	 * @param 계좌객체 newAcc
	 * @return result 0.dao에서안됨 1.계좌번호중복 2.비밀번호조건부적합 3.insert성공
	 */
	public int createAcc(Account newAcc) {
		int result = 0;
		
		return result;
	}
	
	/**
	 * 인자의 정보 중 계좌번호로 기존 데이터를 검색(service의 검색 메소드 사용)하여 
	 * 일치하는 계좌를 찾아낸다. 일치하는 계좌가 있을 경우 인자의 패스워드로 데이터를 비교한다.
	 * 패스워드가 일치할 경우, 계좌 객체 데이터에 삭제하기 위한 dao 메소드 호출한다.
	 * 리턴값 result을 정하여 호출한 곳으로 반환한다.
	 * @param 계좌번호 accNo, 비밀번호 password
	 * @return result 0.dao에서안됨 1.계좌번호없음 2.비밀번호불일치 3.delete 성공
	 */
	public int delete(String accNo, String password) {
		int result = 0;
		
		return result;

	}
	
	/** 입금 (본인계좌)
	 * 인자의 정보 중 계좌번호로 기존 데이터를 검색(service의 검색 메소드 사용)하여 
	 * 일치하는 계좌를 찾아낸다. 일치하는 계좌가 있을 경우 인자의 패스워드로 데이터를 비교한다.
	 * 패스워드가 일치할 경우 해당 계좌의 잔고와 인자의 money를 합산한 값으로 잔고를 수정(set)하고,
	 * dao 메소드를 호출한다.
	 * 리턴값 result을 정하여 호출한 곳으로 반환한다.
	 * @param 계좌번호 accNo, 비밀번호 password, 입금액 money
	 * @return result 0.dao에서안됨 1.계좌번호없음 2.비밀번호불일치 3.deposit 성공
	 */
	public int deposit(String accNo, String password, int money) {
		int result = 0;
		
		return result;
	}

	/** 출금 (본인계좌)
	 * 인자의 정보 중 계좌번호로 기존 데이터를 검색(service의 검색 메소드 사용)하여 
	 * 일치하는 계좌를 찾아낸다. 일치하는 계좌가 있을 경우 인자의 패스워드로 데이터를 비교한다.
	 * 패스워드가 일치할 경우 해당 계좌의 잔고에서 인자의 money를 뺀 값으로 잔고를 수정(set)하고,
	 * dao 메소드를 호출한다.
	 * if 출금시 출금금액이 계좌 잔고보다 클 경우, 출금은 불가하다.
	 * 리턴값 result을 정하여 호출한 곳으로 반환한다.
	 * @param 계좌번호 accNo, 비밀번호 password, 출금액 money
	 * @return result 0.dao에서안됨 1.계좌번호없음 2.비밀번호불일치 3.deposit 성공 4.잔고부족
	 */
	public int withdraw(String accNo, String password, int money) {
		int result = 0;
		
		return result;
	}
	
	/** 계좌이체 (타계좌)
	 * 인자의 정보 중 나의 계좌번호와 상대방의 계좌번호로 기존 데이터를 검색(service의 검색 메소드 사용)하여 
	 * 일치하는 계좌 각각 찾아낸다.
	 * 일치하는 계좌가 모두 있을 경우 인자의 패스워드로 My 계좌 데이터를 비교한다.
	 * 패스워드가 일치할 경우 My 계좌의 잔고에서 인자의 money를 뺀 값으로 잔고를 수정(set)하고,
	 * Target 계좌의 잔고와 인자의 money를 합산한 값으로 잔고를 수정(set)하고,
	 * dao 메소드를 호출한다. (두 계좌가 모두 수정되어야하죵)
	 * if 이체시 이체금액이 My 계좌 잔고보다 클 경우, 이체는 불가하다.
	 * 리턴값 result을 정하여 호출한 곳으로 반환한다.
	 * @param 내계좌번호 myAccNo, 비밀번호 password, 이체금액 money, 상대방계좌번호 targetAccNo
	 * @return result 0.dao에서안됨 1.계좌번호없음 2.비밀번호불일치 3.accountTransfer 성공 4.잔고부족
	 */
	public int accountTransfer(String myAccNo, String password, int money, String targetAccNo) {
		int result = 0;
		
		return result;
	}

	/**
	 * 인자로 받은 계좌번호로 데이터베이스에서 검색(dao 메소드 실행)한다.
	 * 리턴받은 객체를 반환한다.
	 * @param 계좌번호 accNo
	 */
	public Account searchAccountByNo(String accNo) {
		Account findAccount = null;
		
		return findAccount;
	}

	/**
	 * 인자로 받은 마스터키가 일치할 경우, 데이터베이스에 있는 계좌데이터를 
	 * 전부 검색(dao 메소드 실행)한다.
	 * @param 마스터키 masterKey
	 */
	public List<Account> searchAllAccount(String masterKey) {
		String absoluteKey = "iambetter";
		List<Account> accList = null;
		if (masterKey.equals(absoluteKey)) {
			
		}
		return accList;
	}
}
