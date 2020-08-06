package dto;

public class Seller extends Person{
	private final String TYPE = "SELLER";
	
	public Seller() {
		
	}
	public Seller(String id, String pw, String name)  {
		super(id,pw,name);
	}
	
	public String getTYPE() {
		return TYPE;
	}
	
	@Override
	public String toString() {
		String str = "[" + TYPE + "]---" + super.toString(); 
		return str;
	}
	
	
}
