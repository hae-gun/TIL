package class09_inheritance;

final class Ant {

}

//class SuperAnt extends Ant{
//	
//}

class Vehicle {
	final int price = 50000;

	final void stop() {
		System.out.println("stop");
	}

	void drive() {

	}
}

class Bus extends Vehicle {
	// final method는 오버라이딩 불가능
//	@Override
//	void stop() {
//		System.out.println("Bus Stop!!!");
//	}
	@Override // - 부모의 메서드를 재정의 - 반환타입, 메소드 이름, 매개변수의 타입과 수가 다른지 체크
	void drive() { // 접근제한자 축소 불가
		// TODO Auto-generated method stub
		super.drive();
//		throw new Exception();
	}
}

public class In06 {

}
