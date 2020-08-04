package user_define;

// 사용자 정의 익셉션 클래스는 Exception 클래스를 상속받아야 한다.
public class BalanceInsufficentException extends Exception {
	
	public BalanceInsufficentException() {
		// TODO Auto-generated constructor stub
	}
	
	public BalanceInsufficentException(String msg) {
		super(msg);
	}
	
	
}
