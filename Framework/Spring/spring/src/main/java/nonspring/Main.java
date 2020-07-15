package nonspring;

public class Main {

	public static void main(String[] args) {
		// 객체 변경시 코드 수정 불가피 = 결합도가 높다. coupling 높다.(나쁜코드 지양해야함)
		// tv변수 생성 객체가 MultiTV, OtherTV 2중하나.
		// dependency:직접 객체 생성.-->위임
		
		TVFactory factory = new TVFactory();

		TV tv = factory.getTV(args[0]); // 상속받은 인터페이스로 형변환 가능.
		tv.powerOn();
		tv.soundUp();
		tv.soundDown();
		tv.powerOff();
	}

}
