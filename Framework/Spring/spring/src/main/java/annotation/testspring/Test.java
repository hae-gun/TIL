package annotation.testspring;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {

		ApplicationContext factory = new ClassPathXmlApplicationContext("annotation/testspring/test.xml");
		
		TestServiceImpl service = factory.getBean("service", TestServiceImpl.class);
		TestVO vo = service.test();
		System.out.println(vo.getMember1()+" : "+vo.getMember2());
	}
}
