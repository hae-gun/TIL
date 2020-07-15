package tvspring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		// TVFactory--> 스프링으로 위임.
		ApplicationContext factory = new ClassPathXmlApplicationContext("tvspring/tv.xml");
		TV tv = factory.getBean("tv", TV.class); // 상속받은 인터페이스로 형변환 가능.
		tv.powerOn();
		tv.soundUp();
		tv.soundDown();
		tv.powerOff();
		
		TV tv2 = factory.getBean("tv2", TV.class); // 상속받은 인터페이스로 형변환 가능.
		tv2.powerOn();
		tv2.soundUp();
		tv2.soundDown();
		tv2.powerOff();
	}

}
