package class06_singleton;

public class DBEx {
	public static void main(String[] args) {
		
		// 아래와 같이 사용 불가능.
//		DBConnection dbk = new DBConnection();
		
		// 아래와 같이 싱글톤 객체를 가져옴
		DBConnection dbk = DBConnection.getInstance();
		DBConnection dbk2 = DBConnection.getInstance();
		
		//두 객체는 같은 객체
		if(dbk == dbk2) {
			System.out.println("same singleton object");
		}else {
			System.out.println("another object");
		}
		
		
	}
}
