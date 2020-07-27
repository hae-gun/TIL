package ch06_ClassObject;

public class CarEx {
	public static void main(String[] args) {
		Car myCar = new Car(); //myCar : 참조변수 (reference variable)
		
		System.out.println(myCar.brand);
		System.out.println(
				myCar.color);
		System.out.println(myCar.maxSpeed);
		System.out.println(myCar.speed);
		
		System.out.println("------------------");
		
		myCar.drive();
		myCar.speedUp();
		System.out.println(myCar.speed);
		myCar.speedUp();
		System.out.println(myCar.speed);
		myCar.speedDown();
		System.out.println(myCar.speed);
		myCar.stop();
		System.out.println(myCar.speed);
		
	}
}
