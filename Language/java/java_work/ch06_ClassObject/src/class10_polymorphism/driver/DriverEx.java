package class10_polymorphism.driver;

public class DriverEx {
	public static void main(String[] args) {
		Vehicle v = new Vehicle();
		Bus b = new Bus();
		Taxi t = new Taxi();
		
		Driver d = new Driver();
		d.drive(b);
		d.drive(b);
		d.drive(t);
	}
}
