package interface02;

public class RemoEx {
	public static void main(String[] args) {
		TV tv = new TV();
		//tv 객체로 메소드 사용 - 리모콘 사용 안 함
		tv.turnOn();
		tv.setVolume(7);
		System.out.println("------------------------");
		//만능리모콘에 tv 등록
		RemoteControl rc = tv;
		rc.turnOn();
		rc.play();
		rc.setVolume(9);
		System.out.println("------------------------");
		Audio audio = new Audio();
		rc = audio;
		rc.turnOn();
		rc.setMute(true);
		rc.turnOff();
		System.out.println("------------------------");
		SmartTV st = new SmartTV();
		rc = st;
		rc.turnOn();
		
		
//		SmartTV stv = new SmartTV();
//		rc = stv;
//		rc.turnOn();
		// 바로 사용 불가능.
//		rc.search();
		// 아래 같이 사용
		((SmartTV)rc).search("naver");
		
		System.out.println("------------------------");
		Computer ct = new Computer();
		Searchable[] sc = {st,ct};
		
		for(Searchable s: sc) {
			s.search("google");
		}
		rc.setMute(true);
	}
}
