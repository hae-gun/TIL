package di2;

public class Msgmain {

	public static void main(String[] args) {
		
		MessageBean en = new MessageBeanimpEn();
		en.Message("Spring");
		
		MessageBean kor = new MessageBeanimpKor();
		kor.Message("스프링");
 	}

}
