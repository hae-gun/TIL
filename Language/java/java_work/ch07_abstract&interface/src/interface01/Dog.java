package interface01;

public class Dog implements Animal {

	String name;

	public Dog(String name) {
		this.name = name;
	}

	@Override
	public void eat() {
		System.out.println(OWNER + " 의 강아지 " + name + " 이 쩝");
	}

	@Override
	public void sound() {
		System.out.println(OWNER + " 의 강아지 " + name + " 이 멍멍");
		
	}
}
