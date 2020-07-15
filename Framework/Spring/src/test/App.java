package test;

public class App {

	public static void main(String[] args) {

		
		UserDAO user = new UserDAO();
		
		UserVO us = user.login("chlgprms", "123456");
		
		if((us.getId()==null)||(us.getPw()==null)) {
			System.out.println("실패");
		}else {
			System.out.println("성공");
		}

	}
}
