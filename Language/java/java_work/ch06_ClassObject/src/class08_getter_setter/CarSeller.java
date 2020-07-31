package class08_getter_setter;

public class CarSeller {

	String name;
	int wallet;
	int stockOfCar;
	static final int CAR_PRICE = 10000;
	
	public CarSeller() {
		
	}
	
	
	public CarSeller(String name, int wallet, int stockOfCar) {
		this.name = name;
		this.wallet = wallet;
		this.stockOfCar = stockOfCar;
	}



	public int sell(int money) {
		int order_num = money / CAR_PRICE ;
		
		if(order_num>stockOfCar) {
			System.out.println(name + ": not enough car");
			return 0;
		}else {
			stockOfCar -= order_num;
			wallet += money;
			return order_num;
		}
	}
	
	void print() {
		System.out.println("판매자 이름: "+name);
		System.out.println("현금 보유액: "+wallet);
		System.out.println("보유 차량수: "+stockOfCar);
		System.out.println("--------------------");
	}

}
