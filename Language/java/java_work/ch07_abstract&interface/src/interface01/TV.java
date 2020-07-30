package interface01;

public class TV implements RemoteControl {
	int volume;

	@Override
	public void turnOn() {
		System.out.println("TV on");
	}

	@Override
	public void turnOff() {
		System.out.println("TV off");
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
		System.out.println("현재 TV 볼륨: " + this.volume);
	}

	@Override
	public void play() {
		System.out.println("TV 영상 재생");
	}

}
