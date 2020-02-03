package annotation.aop1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopMain {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("annotation/aop1/aop.xml");
		Member m = factory.getBean("member",Member.class);
		Board b = factory.getBean("board",Board.class);
		
		//공통관심 = 횡단관심 = aspect 클래스.
		//Common c = factory.getBean("common", Common.class); Spring이 만들예정.
		
		//호출시간
		m.login("spring");
		//호출시간
		b.inserBoard(100);
		//호출시간
		b.getList();
		//호출시간
		m.logout();
	}

}
