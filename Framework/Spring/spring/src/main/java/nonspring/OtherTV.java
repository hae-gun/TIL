package nonspring;

public class OtherTV implements TV {
	public void powerOn() {
		System.out.println("Othertv:전원켜다.");
	}

	public void powerOff() {
		System.out.println("Othertv:전원끄다.");
	}

	public void soundUp() {
		System.out.println("Othertv:볼륨높이다.");
	}

	public void soundDown() {
		System.out.println("Othertv:볼륨낮추다.");
	}

}
