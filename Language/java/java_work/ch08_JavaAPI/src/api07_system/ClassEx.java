package api07_system;

public class ClassEx {
	public static void main(String[] args) throws ClassNotFoundException {

		Car car = new Car();

		// 생성된 객체의 instance 를 반환.
		Class c1 = car.getClass();
		System.out.println(c1.getPackage().getName());
		System.out.println(c1.getName());

		// 경로를 잘 잡아야 한다.
		Class c2 = Class.forName("api07_system.Car");
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());

		Class c3;
		String driver = "";
		
		try {
			c3 = Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}

class Car {

}