package thread_ACC;

public class Bank {
	Account acc1;
	Account acc2;
	
	synchronized void transfer(int money) {
		acc1.withdraw(money);
		System.out.println(acc1.owner + " 계좌: "+money+" 인출");
		acc2.deposit(money);
		System.out.println(acc2.owner+" 계좌: "+money+" 입금");
	}
	
	synchronized int getTotal() {
		return acc1.balance + acc2.balance;
	}
}
