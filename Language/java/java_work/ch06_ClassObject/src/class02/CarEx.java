package class02;

public class CarEx {
	public static void main(String[] args) {
		Car c1 = new Car(); // 기본 생성자를 이용.
		c1.brand = "porche";
		c1.color = "yellow";
		c1.price = 5000;
		
		c1.print();
		
		Car c2 = new Car("BMW");
		c2.print();
		
		Car c3 = new Car("SM5","black",1000);
		c3.print();
		
		Car c4 = new Car();
		c4.print();
	}
}
