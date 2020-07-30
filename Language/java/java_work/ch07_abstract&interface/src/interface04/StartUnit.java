package interface04;

class Marine extends GroundUnit implements Attackable{

	public Marine() {
		super(30);
		hitPoint = MAX_HP;
	}

	@Override
	public String toString() {
		return "Marine";
	}

	@Override
	public void attack(Unit u) {
		int damage = 10;
		System.out.println("Attack");
		u.hitPoint -= damage;
		System.out.println(u.hitPoint);
	}
}

class Tank extends GroundUnit implements Repairable {

	public Tank() {
		super(150);
		hitPoint = MAX_HP;
	}

	@Override
	public String toString() {
		return "Tank";
	}
}

class DropShip extends AirUnit implements Repairable {

	public DropShip() {
		super(100);
		hitPoint = MAX_HP;
	}

	@Override
	public String toString() {
		return "DropShip";
	}
}

class SCV extends GroundUnit {
	
	public SCV() {
		super(80);
		hitPoint = MAX_HP;
	}

	@Override
	public String toString() {
		return "SCV";
	}
	
	void repair(Repairable r) {
		Unit unit = (Unit) r;
		System.out.println(unit.hitPoint);
		
		
		while (unit.hitPoint < unit.MAX_HP) {
			unit.hitPoint++;
			System.out.println(unit.hitPoint);
		}
		System.out.println(r + " 수리 완료!");
	}
}

public class StartUnit {
	
}
