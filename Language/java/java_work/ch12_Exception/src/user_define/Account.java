package user_define;

class Acc {
	private long balance;

	public long getBalance() {
		return balance;
	}

	public void deposit(long balance) {
		this.balance += balance;
	}

	// 사용자 정의 Exception을 발생시키고 매서드를 호출한 곳으로 던져준다.
	void withdraw(int money) throws BalanceInsufficentException {
		if (balance < money) {
			throw new BalanceInsufficentException("잔고부족: " + (money - balance) + "$ 부족함");
//			System.out.println("잔고부족");
		}
		balance -= money;
	}
}

public class Account {
	public static void main(String[] args) {

		Acc ac1 = new Acc();
		ac1.deposit(50000);
		try {
			ac1.withdraw(70000);
		} catch (BalanceInsufficentException e) {
			System.out.println(e.getMessage());
		}
	}
}
