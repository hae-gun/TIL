package class05_final;

public class Final01 {
	// 선언하면서 초기화
	final String nation = "Korea";
	final String idNo;
	String name;
	
//	public Final01() {
//		this.idNo = "";
//	}
	
	public Final01(String idNo,String name) {
		this.idNo = idNo;
		this.name = name;
	}
	
	
	public static void main(String[] args) {
		Final01 fi = new Final01("1234","tom");
		
		System.out.println(fi.nation);
		System.out.println(fi.idNo);
		System.out.println(fi.name);
//		fi.nation = "USA";
//		System.out.println(fi.nation);
		
	}
}
