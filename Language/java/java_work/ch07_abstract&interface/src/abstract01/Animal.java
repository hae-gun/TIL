package abstract01;

//추상 클래스: 상속 받은 자식클래스들에게 재정의를 강요하는 추상 메소드를 가지고 있는 클래스이다.
public abstract class Animal {
	String kind;
	
	public Animal() {
		
	}
	public Animal(String kind) {
		this.kind = kind;
	}
	
	void breathe() {
		System.out.println(kind + "이 숨을쉽니다.");
	}
	abstract void sound() ;
}

class Cat extends Animal{
	@Override
	void sound() {
		System.out.println("야옹");
	}
}
class Dog extends Animal{
	@Override
	void sound() {
		System.out.println("멍");
	}
}



