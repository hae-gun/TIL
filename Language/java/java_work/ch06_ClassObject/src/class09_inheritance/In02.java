package class09_inheritance;

import java.util.Date;

class Tire {
	String brand;
	Date produced;
}

class Car {
	String color;
	int door;
	Tire[] tires; // 포함관계 차는 타이어를 갖고 있다.

	void drive() {
		System.out.println("차가 달려간다.");
	}

	void stop() {
		System.out.println("차가 멈춘다.");
	}

	void print() {
		System.out.println(this.getClass() + "=> color: " + color + " / door: " + door);
	}

	void fly() {
		System.out.println("차가 난다.");
	}
}

// 상속관계 : 앰뷸런스는 자동차이다.
class Ambulance extends Car {
	String cross;

	@Override
	void drive() {
		super.drive();
		System.out.println("앰뷸런스다. 길을 비켜라");
	}

	void siren() {
		System.out.println("앰뷸 앰뷸");
	}
}

class FireEngine extends Car{
	String hose;
	
	@Override
	void drive() {
		super.drive();
		System.out.println("불자동차임. 길을비켜라");
	}
	void extinguish() {
		System.out.println("물 뿌려");
	}
}

public class In02 {
	public static void main(String[] args) {
		
		Car car1 = new Car();
		car1.color = "blue";
		car1.door = 4;
		car1.print();
		System.out.println("----------------------");
		Ambulance am1 = new Ambulance();
		FireEngine fe1 = new FireEngine();
		car1.drive();
		am1.drive();
		fe1.drive();
		System.out.println("----------------------");
		
		Car car2 = new Ambulance();
		Car car3 = new FireEngine();
		
		Car[] garage = {car1,car2,car3};
		 
		for(Car c: garage) {
			c.drive();
			if(c instanceof Ambulance) {
				((Ambulance) c).siren();
			}else if(c instanceof FireEngine) {
				((FireEngine) c).extinguish();
			}
			c.stop();
			System.out.println(">>>>>>>>>>>>>>>>>>");
		}
		
		
	}
}
