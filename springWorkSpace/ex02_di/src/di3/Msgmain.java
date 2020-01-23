package di3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Msgmain {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("di3/applicationCtx.xml"); // spring 컨테이너 생성함.
		
		MessageBean bean = ctx.getBean("m2", MessageBean.class); 
		bean.Message("Spring~");
		
		bean = (MessageBean)ctx.getBean("kr");
		bean.Message("Spring");
 	}
}
