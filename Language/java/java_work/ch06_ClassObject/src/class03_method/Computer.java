package class03_method;

public class Computer {

	// field
	String power = "off";
	String owner;

	public Computer() {

	}

	public Computer(String name) {
		this.owner = name;
	}

	void powerOn() {
		this.power = "on";
	}

	void powerOff() {
		this.power = "off";
	}

	void whoseCom() {
		System.out.println("이 컴퓨터는 " + owner + "의 것입니다.");
	}

	void useCase(String name) {
		
		if (name.equals("tom")) {
			System.out.println("게임중...");
		} else if (name.equals("jane")) {
			System.out.println("공부중...");
		} else {
			System.out.println("도난컴...");
		}
	}

}
