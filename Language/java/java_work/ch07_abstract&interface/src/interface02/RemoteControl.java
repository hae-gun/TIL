package interface02;

//인터페이스: 자신을 구현하는 클래스들의 연결고리, 설계도
//다형성 활용: 자신을 구현한 클래스의 객체들이 자신의 타입으로 각자가 재정의한 메소드를 사용할 수 있게 해줌
//특징: 상수와 메소드만 포함(생성자 없음): 추상메소드, 디폴트 메소드, static 메소드
public interface RemoteControl {
	//상수
	//static final int MAX_VOLUME = 10;
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	
	//추상 메소드
	void turnOn();
	void turnOff();
	void setVolume(int volume);
	void play();
	
	//default method: interface의 일반 메소드
	// -- interface의 기능 확장
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("무음 처리");
		}else {
			System.out.println("무음 해제");
		}
	}
	
	//static method: 인터페이스명.메소드명
	static void changeBattery() {
		System.out.println("리모콘 건전지 교환");
	}
}










