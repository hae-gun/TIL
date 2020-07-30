package interface01;

// java 7 이후부터 interface에 default method, static method 가 추가됨
public interface RemoteControl {
//	static final int MAX_VOLUME = 10;
	// 아래 둘다 static final 
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	
	// 추상 메소드
	void turnOn();
	void turnOff();
	void setVolume(int volume);
	void play();
	
	// default method
	// interface 기능확장
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("무음처리");
		}else {
			System.out.println("무음해제");
		}
	}
	
	// static method : 인터페이스명.메소드명
	// 
	
}

