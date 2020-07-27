package class06_singleton;

// Design Pattern: 객체를 생성하는 방식
// 싱글톤: 사용자가 여럿이어도 객체를 하나만 반환하는 방식
public class DBConnection {

	// 미리 클래스의 객체를 생성하여 참조변수 (객체 이름) instance
	// private: 클래스 내부에서만 보이게 만드는 접근제한자
	// private: 클래스 내부에서만 보이게 만드는 접근제한자
	
//	private static DBConnection instance = new DBConnection();
	private static DBConnection instance;
	
	private DBConnection() {
		
	}
	
	public static DBConnection getInstance() {
		if(instance == null) {
			instance = new DBConnection();
		}
		return instance;
	}
	
	
}
