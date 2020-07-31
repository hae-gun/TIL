package interface04;

public class StarEx {
	public static void main(String[] args) {
		Marine m = new Marine();
		Tank t = new Tank();
		DropShip d = new DropShip();
		SCV scv = new SCV();
		
		scv.repair(t);
		m.attack(d);
		scv.repair(d);
		
	}
}
