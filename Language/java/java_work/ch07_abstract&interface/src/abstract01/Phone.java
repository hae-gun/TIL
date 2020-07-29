package abstract01;

// 추상 클래스는 생성 불가능.
public abstract class Phone {
	String owner;
	
	public Phone(String owner) {
		this.owner = owner;
	}
	
	void turnOn() {
		System.out.println("Power On");
	}
	
	void turnOff() {
		System.out.println("Power Off");
	}
	
	abstract void connectInternet();
}

class TwoGPhone extends Phone{
	
	public TwoGPhone(String owner) {
		super(owner);
	}
	
	@Override
	void connectInternet() {
		
		System.out.println("can not connect");
	}
}
class ThreeGPhone extends Phone{
	
	public ThreeGPhone(String owner) {
		super(owner);
	}
	
	@Override
	void connectInternet() {
		
		System.out.println("3G ~~~~");
	}
}
class FiveGPhone extends Phone{
	
	public FiveGPhone(String owner) {
		super(owner);
	}
	
	@Override
	void connectInternet() {
		
		System.out.println("5G ~~~~");
	}
}

