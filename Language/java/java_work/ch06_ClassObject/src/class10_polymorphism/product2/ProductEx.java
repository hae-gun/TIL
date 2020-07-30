package class10_polymorphism.product2;

public class ProductEx {
	public static void main(String[] args) {
		
		Customer ct = new Customer();
		ct.purchaseList();
		ct.buy(new TV());
		ct.buy(new Computer());
		ct.buy(new TV());
		SmartPhone sp = new SmartPhone();
		ct.buy(sp);
		ct.purchaseList();
		
		ct.refund(sp);
		ct.purchaseList();
	}
}
