package class08_getter_setter.exercise;

import java.util.Scanner;

public class AccountService {

	// Account 객체 100개 저장할 수 있는 배열
	private static Account[] accountArray = new Account[100];
	private static Scanner scan = new Scanner(System.in);

	// field 초기화 static 블록
	static {
		String[][] account = { { "1111", "a", "1", "10000" }, { "2222", "b", "2", "40000" },
				{ "3333", "c", "3", "110000" }, { "4444", "d", "4", "500000" } };
		for (int i = 0; i < account.length; i++) {
			accountArray[i] = new Account("", "", "", 0);
			for (int j = 0; j < account[i].length; j++) {
				switch (j) {
				case 0:
					accountArray[i].setAccountNo(account[i][j]);
					break;
				case 1:
					accountArray[i].setOwner(account[i][j]);
					break;
				case 2:
					accountArray[i].setPwd(account[i][j]);
					break;
				case 3:
					accountArray[i].setBalance(Integer.parseInt(account[i][j]));
					break;
				}
			}
		}
	}

	/* 송금 method */
	void send() {
		Account account;
		Account account2 = null; // runtime exception
		int balance;
		String accountNo2;
		boolean flag = true;
		boolean flag2 = false;
		boolean pwdF = true;

		System.out.printf("본인의 계좌번호를 입력 해 주세요. >> ");
		String accountNo = scan.next();
		System.out.printf("본인의 비밀번호를 입력 해 주세요. >> ");
		String pwd = scan.next();

		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] != null) {
				if (accountArray[i].getAccountNo().equals(accountNo)) { // 계좌번호 확인. 생성 된 객체들이 가진 계좌 번호 중 동일한 것이 존재한다면
																		// if문 진입
					if ((account = pwdCheck(accountNo, pwd)) != null) { // 비밀번호 확인 method. 계좌의 비밀번호와 일치 할 경우 해당 객체를 반환하며
																		// if문 진입
						account = pwdCheck(accountNo, pwd); // account에 나의 계좌 객체 대입
						while (flag) {
							System.out.printf("송금할 계좌번호를 입력 해 주세요.>> ");
							accountNo2 = scan.next();

							// 송금할 계좌번호가 존재하는지 확인. 존재 할 시 account2에 송금 할 계좌의 객체 대입
							for (int j = 0; j < accountArray.length; j++) {
								if (accountArray[j] != null) {
									if (accountArray[j].getAccountNo().equals(accountNo2)) {
										account2 = accountArray[j];
										flag = false;
										flag2 = true;
										break;
									}
								}
							}

							if (flag2 == false) {
								System.out.println("존재하지 않는 계좌번호 입니다.");
							}
						}
						// set method를 이용하여 송금 금액만큼 각 계좌에서 더하고 빼준다.
						System.out.printf("송금할 금액을 입력 해 주세요. >> ");
						balance = scan.nextInt();
						if (account.getBalance() < balance) {
							System.out.println("잔액이 부족합니다.");
							System.out.println("현재 계좌의 잔액은 " + account.getBalance() + "원 입니다.");
							System.out.println();
							return;
						}
						account.setBalance(-balance);
						account2.setBalance(balance);
						System.out.println("출금이 완료 되었습니다. 잔액은 " + account.getBalance() + "원 입니다.");
						System.out.println();
						return;
					}
					pwdF = false;
				}

			}
		}
		if (pwdF == false) {
			System.out.println("비밀번호가 잘못되었습니다.");
			System.out.println();
		} else {
			System.out.println("계좌번호가 잘못되었습니다.");
			System.out.println();
		}
	}

	/* 출금 method */
	void withdraw() {
		String accountNo;
		String pwd;
		Account account;
		boolean pwdF = true;

		while (true) {

			System.out.printf("계좌번호를 입력 해 주세요. >> ");
			accountNo = scan.next();
			System.out.printf("비밀 번호를 입력 해 주세요. >> ");
			pwd = scan.next();

			for (int i = 0; i < accountArray.length; i++) {
				if (accountArray[i] != null) {
					if (accountArray[i].getAccountNo().equals(accountNo)) { // 계좌번호 확인. 생성 된 객체들이 가진 계좌 번호 중 동일한 것이
																			// 존재한다면 if문 진입
						if ((account = pwdCheck(accountNo, pwd)) != null) { // 비밀번호 확인. 객체를 반환.
							System.out.printf("출금할 금액을 입력 해 주세요. >> ");
							int balance = scan.nextInt();
							if (account.getBalance() < balance) {
								System.out.println("잔액이 부족합니다.");
								System.out.println("현재 계좌의 잔액은 " + account.getBalance() + "원 입니다.");
								System.out.println();
								return;
							}
							account.setBalance(-balance);
							System.out.println("출금이 완료 되었습니다. 잔액은 " + account.getBalance() + "원 입니다.");
							System.out.println();
							return;
						}
						pwdF = false;
					}
				}
			} // for

			if (pwdF == false) {
				System.out.println("비밀번호가 틀렸습니다.");
				System.out.println();
			} else {
				System.out.println("계좌번호가 틀렸습니다.");
				System.out.println();
			}
		}
	}

	/* 입금 method */
	void deposit() {
		boolean flag = true;
		String accountNo;
		while (flag) {
			System.out.printf("계좌번호를 입력해 주세요. >> ");
			accountNo = scan.next();
			for (int i = 0; i < accountArray.length; i++) {
				if (accountArray[i] != null) {
					if (accountArray[i].getAccountNo().equals(accountNo)) {
						System.out.printf("입금할 금액을 입력 해 주세요. >> ");
						int balance = scan.nextInt();
						accountArray[i].setBalance(accountArray[i].getBalance()+balance);
						System.out.println("입금이 완료 되었습니다. 잔액은 : " + accountArray[i].getBalance());
						flag = false;
						return; // 메소드 종료
					}
				}
			} // for end
			System.out.println("계좌번호가 틀렸습니다.");
			System.out.println();
		}
	}

	/* 계좌 정보 확인 method */
	void myAccount() {
		System.out.printf("조회 하실 계좌번호를 입력 해 주세요. >> ");
		String accountNo = scan.next();
		System.out.printf("비밀 번호를 입력하세요. >> ");
		String pwd = scan.next();
		if (pwdCheck(accountNo, pwd) != null) {
			System.out.println(pwdCheck(accountNo, pwd));
		} else {
			System.out.println("계좌 정보가 틀렸습니다.");
			System.out.println();
			return;
		}
	}

	/* 비밀번호 확인 method */
	Account pwdCheck(String accountNo, String pwd) {
		Account account = null;
		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] != null) {
				if (accountArray[i].getAccountNo().equals(accountNo) && accountArray[i].getPwd().equals(pwd)) {
					account = accountArray[i];
					return account;
				}
			}
		}
		return account;
	}

	/* 계좌 생성 method */
	void createAccount(String accountNo, String owner, String pwd, int balance) {

		Account account = new Account(accountNo, owner, pwd, balance);
		while (findAccount(account) != null) {
			System.out.println("이미 동일한 계좌번호가 존재합니다.");
			System.out.println();
			return;
		}
		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] == null) {
				accountArray[i] = account;
			}
		}
		System.out.println();
		System.out.println("\t계좌를 생성 하였습니다!");
		System.out.println();
		System.out.println(account);
		System.out.println("\t비밀 번호 : " + account.getPwd());
		System.out.println();
	}// create

	/* 계좌 존재여부 확인 method */
	Account findAccount(Account account) {
		Account newAccount = null;
		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] != null) {
				if (accountArray[i].getAccountNo().equals(account.getAccountNo())) {
					newAccount = accountArray[i];
					return accountArray[i];
				}
			}
		}
		return newAccount;
	}
	
}
