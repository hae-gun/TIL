package class10_polymorphism.driver;

public class DriverEx {
	public static void main(String[] args) {
		Vehicle v = new Vehicle();
		Bus b = new Bus();
		Taxi t = new Taxi();
		
		Driver d = new Driver();
		d.drive(b);
//		d.drive(v); //drive 메소드가 매개변수로 Bus를 받으므로 에러
//		d.drive(t);
		System.out.println("----매개변수를 Vehicle 로 바꾸면 ㅋㅋ-------------");
		d.drive(v);
		d.drive(b); 
		d.drive(t);
	}
}
