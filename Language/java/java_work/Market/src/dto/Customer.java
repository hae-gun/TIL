package dto;

public class Customer extends Person {
	private final String TYPE = "CUSTOMER";
	private int point;
	public Customer() {
		
	}
	public Customer(String id, String pw, String name)  {
		super(id,pw,name);
	}
	
	public String getTYPE() {
		return TYPE;
	}
	
	public void fillPoint(int money) {
		if(money>0)
			this.point += money;
	}
	
	@Override
	public String toString() {
		String str = "[" + TYPE + "]---" + super.toString() + "[Point: "+point+"]";
		return str;
	}
	
	
	
}
