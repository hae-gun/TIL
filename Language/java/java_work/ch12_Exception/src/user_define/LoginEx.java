package user_define;

public class LoginEx {
	public static void main(String[] args) {
		
		try {
			Login("bluq"
					+ "e","2134");
		} catch (NoSuchIDException e) {
			System.out.println(e.getMessage());
		} catch (WrongPWException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("login success");
	}

	private static void Login(String id, String pw) throws NoSuchIDException, WrongPWException{
		if(!id.equals("blue")) {
			throw new NoSuchIDException("그런 ID 없음.");
		}
		if(!pw.equals("2134")) {
			throw new WrongPWException("패스워드가 틀림");
		}
		
	}
}
