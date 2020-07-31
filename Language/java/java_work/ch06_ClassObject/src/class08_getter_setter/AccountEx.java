package class08_getter_setter;

public class AccountEx {
	public static void main(String[] args) {

		Account ac1 = new Account("1234", "tom", "KB", 0);
		System.out.println(ac1.getOwner());
		System.out.println(ac1);
		Account ac2 = new Account("3456", "sam", "KB", 40000);

		ac1.deposit(100000);
		System.out.println(ac1);
		ac1.withdraw(2000);
		System.out.println("-------------------------------------");
		
		System.out.println(ac1);
		System.out.println(ac2);
		
		System.out.println(ac1.transfer(ac2, 20000));
		
		System.out.println(ac1);
		System.out.println(ac2);

	}
}
