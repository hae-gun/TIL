package class10_polymorphism.product;

public class ProductEx {
	public static void main(String[] args) {
		Customer ct = new Customer();
		ct.buy(new TV());
		System.out.println(ct.money + " : "+ ct.bonuspoint);
		ct.buy(new Computer());
		System.out.println(ct.money + " : "+ ct.bonuspoint);
	}
}
