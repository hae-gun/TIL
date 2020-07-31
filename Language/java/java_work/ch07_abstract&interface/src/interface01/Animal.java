package interface01;

public interface Animal {

	String OWNER = "TOM";
	public static final String KIND = "cat";
	
	// 메소드는 추상메소드만 가질 수 있음.
	abstract void sound();
	void eat();
	
	
}
