package class10_polymorphism.driver;

public class Vehicle {
	void run() {
		System.out.println("차량이 달립니다.");
	}
}

class Taxi extends Vehicle{
	@Override
	void run() {
		System.out.println("택시가 달립니다.");
	}
	void payMoney() {
		System.out.println("돈 받고 달립니다.");
	}
}

class Bus extends Vehicle{
	@Override
	void run() {
		System.out.println("버스가 달립니다.");
	}
	void transit() {
		System.out.println("환승입니다.");
	}
}
