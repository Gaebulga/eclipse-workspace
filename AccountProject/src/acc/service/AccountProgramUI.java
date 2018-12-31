package acc.service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import acc.dto.Account;

public class AccountProgramUI {
	private Scanner input = new Scanner(System.in);
	private AccountService aService = new AccountService();
	
	public AccountProgramUI() {
		while (true) {
			try {
				this.printMainMenu();
				int num = input.nextInt();
				switch (num) {
				case 1: // 계좌 생성

					break;
				case 2: // 계좌 거래
					this.printInputOutputMenu();

					break;
				case 3: // 계좌 검색
					this.printSearchMenu();

					break;
				case 4: // 계좌 삭제

					break;
				case 9: // 종료
					System.exit(0);
					break;
				default: // 예외처리(번호)

					break;
				}

			} catch (InputMismatchException e) {
				System.out.println("Input타입미스매치 오류>>");
				e.printStackTrace();
				input.nextLine();
				continue;
			}
		}
	}

	/**
	 * 주메뉴를 화면에 출력한다.
	 */
	public void printMainMenu() {
		System.out.println("\n--------------------");
		System.out.println("   KITA BANK ATM");
		System.out.println("--------------------");
		System.out.println("1. 계좌 생성");
		System.out.println("2. 계좌 거래");
		System.out.println("3. 계좌 검색");
		System.out.println("4. 계좌 삭제");
		System.out.println("9. 프로그램 종료");
		System.out.println("--------------------");
		System.out.print("번호 선택 >> ");
	}

	/**
	 * 계좌 거래메뉴를 화면에 출력한다.
	 */
	public void printInputOutputMenu() {
		System.out.println("--------------------");
		System.out.println("    계좌 거래");
		System.out.println("--------------------");
		System.out.println("1. 입금");
		System.out.println("2. 출금");
		System.out.println("3. 계좌이체");		
		System.out.println("9. 이전으로");
		System.out.println("--------------------");
		System.out.print("번호 선택 >> ");
		int no = input.nextInt();
		switch (no) {
		case 1:
			
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		case 9:
			
			break;

		default:
			break;
		}
	}

	/**
	 * 계좌 검색메뉴를 화면에 출력한다.
	 */
	public void printSearchMenu() {
		System.out.println("--------------------");
		System.out.println("    계좌 검색");
		System.out.println("--------------------");
		System.out.println("1. 단일 계좌 검색");
		System.out.println("2. 총 계좌리스트 검색");
		System.out.println("9. 이전으로");
		System.out.println("--------------------");
		System.out.print("번호 선택 >> ");
		int no = input.nextInt();
		switch (no) {
		case 1:
			
			break;
		case 2:
			
			break;
		case 9:
			
			break;

		default:
			break;
		}
	}

	/** 생성 (null값 검증은 여기서)
	 * 필요한 항목(계좌번호, 계좌주 이름, 비밀번호, 잔고, 이율)에 대한 값을 입력받은 후
	 * 계좌 객체 데이터에 저장하기 위해 Account 객체를 생성한다.
	 * 생성된 객체를 db에 넣기위해 service메소드 호출한다.
	 * 메소드 반환값에 따라 성공여부를 출력한다.
	 */
	public void createAcc() {

	}

	/** 입금 (본인계좌) (null값 검증은 여기서)
	 * 필요한 항목(계좌번호, 비밀번호, 입금액)에 대한 값을 입력받은 후
	 * service메소드 호출한다. 반환받은 값(result)에 따라 오류 및 성공 메세지를 출력한다. 
	 */
	public void deposit() {

	}

	/** 출금 (본인계좌) (null값 검증은 여기서)
	 * 필요한 항목(계좌번호, 비밀번호, 출금액)에 대한 값을 입력받은 후
	 * service메소드 호출한다. 반환받은 값(result)에 따라 오류 및 성공 메세지를 출력한다. 
	 */
	public void withdraw() {

	}
	
	/** 계좌이체 (타계좌) (null값 검증은 여기서)
	* 필요한 항목(계좌번호, 비밀번호, 이체금액, 이체계좌번호)에 대한 값을 입력받은 후
	 * service메소드 호출한다. 반환받은 값(result)에 따라 오류 및 성공 메세지를 출력한다. 
	 */
	public void accountTransfer() {
		
	}

	/**
	 * 필요한 항목(계좌번호, 비밀번호)에 대한 값을 입력받은 후
	 * service메소드 호출한다. 반환받은 값(result)에 따라 오류 및 성공 메세지를 출력한다. 
	 */
	public void delete() {

	}

	/**
	 * 필요한 항목(계좌번호)에 대한 값을 입력받은 후
	 * service메소드 호출한다. 반환받은 객체의 정보를 출력한다.
	 * 반환받은 객체 값이 null일 경우 검색결과가 없다는 오류메세지를 출력한다. 
	 */
	public void searchAccount() {

	}

	/**
	 * 필요한 항목(마스터키)에 대한 값을 입력받은 후
	 * service메소드 호출한다. 반환받은 객체의 정보를 출력한다.
	 */
	public void searchAllAccount() {

	}
	
} // class
