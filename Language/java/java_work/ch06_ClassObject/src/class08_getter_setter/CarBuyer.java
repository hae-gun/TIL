package class08_getter_setter;

public class CarBuyer {
	String name;
	int wallet;
	int stockOfCar;
	
	public CarBuyer(String name, int wallet) {
		this.name = name;
		this.wallet = wallet;
	}
	
	void buy(CarSeller cs, int money) {
		if(money <= wallet && money > 0) {
			int order_num = cs.sell(money);
			if(order_num>0) {
				stockOfCar += order_num;
				wallet -= money;
			}else {
				System.out.println(name + ": 차도 없이 차를 파는가");
			}
		}else {
			System.out.println(name + ": 누가 내돈 훔처감");
		}
	}
	
	void print() {
		System.out.println("구매자 이름: "+name);
		System.out.println("현금 보유액: "+wallet);
		System.out.println("보유 차량수: "+stockOfCar);
		System.out.println("--------------------");
	}
}
