package di5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEntry {

	public static void main(String[] args) {

		ApplicationContext context = 
				new ClassPathXmlApplicationContext("di5/AppCtx.xml");
		
		SprotImp show1 = (SprotImp)context.getBean("show1");
		show1.print();
		SprotImp show2 = (SprotImp)context.getBean("show2");
		show1.print();
		SprotImp show3 = (SprotImp)context.getBean("show3");
		show1.print();
	}

}
