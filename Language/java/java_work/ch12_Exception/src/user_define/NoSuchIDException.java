package user_define;

public class NoSuchIDException extends Exception {
	
	public NoSuchIDException(){
		
	}
	public NoSuchIDException(String msg) {
		super(msg);
	}
}
