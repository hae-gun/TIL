package class02;

// Constructor : 클래스로 객체를 만들기 위한 메소드. 클래스 이름과 같은 이름을 사용.
public class Car {
	String brand = "HD";
	String color = "red";
	int price=2000;
	int maxSpeed = 220;
	int speed;

	// constructor
	public Car() {
		this("k3","gold",2000);
	} // 기본 생성자. 다른 생성자가 있으면 자동으로 생성되지 않음.
	
	// 매개변수(arguments) 1개짜리 생성자. 생성하면서 brand를 받아 객체의 field 값에 입력.
	public Car(String brand) {
		this.brand = brand;
	}
	
	public Car(String brand,String color, int price) {
		this.brand = brand;
		this.color = color;
		this.price = price;
	}
	
	// method
	void print() {
		System.out.printf("brand: %s, color: %s, price: %d\n", brand, color, price);
	}

}
