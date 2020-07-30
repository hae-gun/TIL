package interface01;

public class RemoEx {
	public static void main(String[] args) {
		TV tv = new TV();
		// TV 객체로 매서드 사용.
		tv.turnOn();
		tv.setVolume(7);
		System.out.println("----------------------");
		// 만능 리모콘에 tv 등록
		RemoteControl rc = tv;
		rc.turnOn();
		rc.play();
		rc.setVolume(9);
		
		System.out.println("----------------------");
		Audio ad = new Audio();
		rc = ad;
		rc.turnOn();
		rc.setMute(true);
		rc.turnOff();
		
	}
}
