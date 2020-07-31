package interface01;

// 설계도들의 설계도
// 상수, 추상메소드만 있다.
// 인터페이스를 구현한 자식 클래스들은 추상메소드를 오버라이딩해야 한다.
// interface 연결.
// 자식 클래스들의 연결고리 역할 - 다형성
public interface Robot {

	void recharge();
//	void go();

}



class DanceRobot implements Robot {
	void dance() {
		System.out.println("춤");
	}

	@Override
	public void recharge() {
		System.out.println("dance recharge");
	}
}

class SingRobot implements Robot {
	void sing() {
		System.out.println("노래");
	}

	@Override
	public void recharge() {
		System.out.println("sing recharge");
	}
}

class DrawRobot implements Robot {
	void draw() {
		System.out.println("그림");
	}

	@Override
	public void recharge() {
		System.out.println("draw recharge");
	}
}

// 구현한 인터페이스의 추상메소드를 오버라이딩하지 않을 거면 자신이 추상클래스 여야 한다.
abstract class CodingRobot implements Robot {
	String name;

	abstract void program();
}

class JavaRobot extends CodingRobot {

	@Override
	public void recharge() {
		// TODO Auto-generated method stub
		System.out.println("JavaRobot recharge");
	}

	@Override
	void program() {
		// TODO Auto-generated method stub
		System.out.println("JAVA");
	}

}
