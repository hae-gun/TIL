package di4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainEntry {

	public static void main(String[] args) {

		ApplicationContext context = 
				new ClassPathXmlApplicationContext("di4/AppCtx.xml");
		
		ScoreShowImp show = (ScoreShowImp)context.getBean("show");
		show.print();
	}

}
