package interface01;

public class Cat implements Animal {

	String name;

	public Cat(String name) {
		this.name = name;
	}

	@Override
	public void eat() {
		System.out.println(OWNER + " 의 고양이 " + name + " 이 냠");
	}

	@Override
	public void sound() {
		
		System.out.println(OWNER + " 의 고양이 " + name + " 이 야옹야옹");
	}
}
