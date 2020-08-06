package thread_ACC;

public class Account {
	
	String accNo;
	String owner;
	int balance;
	
	public Account() {
	
	}

	public Account(String accNo, String owner, int balance) {
		super();
		this.accNo = accNo;
		this.owner = owner;
		this.balance = balance;
	}
	
	void deposit(int money) {
		balance+=money;
	}
	
	int withdraw(int money) {
		if(balance<money) {
			return 0;
		}
		balance -=money;
		return money;
	}
	
}
