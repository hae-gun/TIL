package abstract01;

public class PhoneEx {
	public static void main(String[] args) {
		
		// abstract class inner class형태로 선언
		Phone phone = new Phone("jane") {
			@Override
			void connectInternet() {
				System.out.println("?????");
			}
		};
		phone.connectInternet();
		System.out.println("------------------------------");
		// 이 객체는 main에서만 볼수있다.
		// 메서드 안에서 만들어 지는 객체 : 익명 객체 (anonymous object)
		
		TwoGPhone twoGPhone = new TwoGPhone("ace");
		System.out.println(twoGPhone.owner + "의 전화기");
		twoGPhone.turnOn();
		twoGPhone.turnOff();
		System.out.println("------------------------------");
		Phone[] ph = {twoGPhone, new ThreeGPhone("tom"),new FiveGPhone("bc")};
		for(Phone p : ph) {
			System.out.println(p.owner + "의 전화기");
			p.turnOn();
			p.connectInternet();
			p.turnOff();
			System.out.println("------------------------------");
		}
		
	}
}
