package interface02;

public class SmartTV implements RemoteControl, Searchable {
	private int volume;

	@Override
	public void turnOn() {
		System.out.println("SmartTV on");
	}

	@Override
	public void turnOff() {
		System.out.println("SmartTV off");
	}

	@Override
	public void setVolume(int volume) {
		if (volume > MAX_VOLUME) {
			this.volume = MAX_VOLUME;
		} else if (volume < MIN_VOLUME) {
			this.volume = MIN_VOLUME;
		} else {
			this.volume = volume;
		}
		System.out.println("현재 SmartTV 볼륨: " + this.volume);
	}

	@Override
	public void play() {
		System.out.println("SmartTV 영상 재상");
	}

	@Override
	public void search(String URL) {
		System.out.println("SmartTV 리모콘으로 " + URL + " 을 검색.");
	}
}
