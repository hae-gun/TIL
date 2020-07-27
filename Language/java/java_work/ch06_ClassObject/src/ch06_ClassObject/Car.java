package ch06_ClassObject;

public class Car {
	// 기본값을 줄 수도 있고 자동 초기화 시킬 수 있다.
	String brand = "HD";
	String color = "red";
	int price;
	int maxSpeed = 220;
	int speed;
	
	//method
	void drive() {
		System.out.println("쌩~");
	}
	void stop() {
		speed = 0;
	}
	public void speedUp() {
		System.out.println("speed UP!");
		this.speed+=10;
		
	}
	public void speedDown() {
		System.out.println("speed DOWN!");
		this.speed-=10;
		
	}
}
