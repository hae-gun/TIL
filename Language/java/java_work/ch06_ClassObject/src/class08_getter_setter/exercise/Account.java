package class08_getter_setter.exercise;

class Account {
	
	/*field*/
	private String accountNo;
	private String owner;
	private String pwd;
	private int balance; //잔고
	
	/*constructor*/
	public Account(String accountNo, String owner, String pwd, int balance) {
		this.accountNo = accountNo;
		this.owner = owner;
		this.pwd = pwd;
		this.balance = balance;
	}
	
	/*method(getter and setter)*/
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
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	//예금
	void deposit(int amount) {
		this.balance += amount;
	}
	
	// 출금
	String withdraw(int amount) {
		if(balance < amount) {
			return "0";
		}
		balance -= amount;
		return "현재잔고: " + this.balance;
	}

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", owner=" + owner + ", pwd=" + pwd + ", balance=" + balance + "]";
	}
	
}
