package class09_inheritance;

class Airplane{
	void fly() {
		System.out.println("normal flying");
	}
	void takeOff(){
		System.out.println("take off!!!");
	}
	void land() {
		System.out.println("landing");
	}
}

class Supersonic extends Airplane{
	static final int NORMAL = 0;
	static final int SUPERSONIC = 1;
	
	int flymode = NORMAL;
	
	@Override
	void fly() {
		if(flymode == SUPERSONIC) {
			System.out.println("sonic boom! supersonic power!!!");
		}else {
			super.fly();
		}
	}
	
	@Override
	public String toString() {
		String[] mode = {"NORMAL", "SUPERSONIC"};
		return "현재 비행모드: " + mode[flymode];
	}
	
}
public class In05 {
	public static void main(String[] args) {
		Supersonic ss = new Supersonic();
		ss.takeOff();
		ss.fly();
		System.out.println(ss);
		ss.flymode = Supersonic.SUPERSONIC;
		ss.fly();
		System.out.println(ss);
		ss.flymode = 0;//Supersonic.NORMAL
		ss.fly();
		ss.land();
	}
}



