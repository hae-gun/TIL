package class08_getter_setter;

class Account {

	/* field */
	private String accountNo;
	private String owner;
	private String bankName;
	private int balance; // 잔고

	/* constructor */
	public Account(String accountNo, String owner, String bankname, int balance) {
		this.accountNo = accountNo;
		this.owner = owner;
		this.bankName = bankname;
		this.balance = balance;
	}

	/* method(getter and setter) */
	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getPwd() {
		return bankName;
	}

	public void setPwd(String pwd) {
		this.bankName = pwd;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	// 예금
	void deposit(int amount) {
		this.balance += amount;
	}

	// 출금
	int withdraw(int amount) {
		if (balance < amount) {
			System.out.println("잔고부족");
			return 0;
		}
		balance -= amount;
		System.out.println("현재잔고: " + this.balance);
		return amount;
	}

	// 송금
	String transfer(Account ac, int amount) {
		if (balance < amount) {
			return "송금실패";
		}
		this.balance -= amount;
		ac.balance += amount;

		return "송금 완료 - " + this.owner + ":" + this.balance 
				+ " / " + ac.owner + ":" + ac.balance;
	}

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", owner=" + owner + ", bankName=" + bankName + ", balance="
				+ balance + "]";
	}

	

}
