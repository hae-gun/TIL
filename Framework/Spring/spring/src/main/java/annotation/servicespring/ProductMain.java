package annotation.servicespring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductMain {

	public static void main(String[] args) {

		ApplicationContext factory = new ClassPathXmlApplicationContext("annotation/servicespring/product.xml");

		ProductService service1 = factory.getBean("service", ProductService.class);
		ProductVO vo1 = service1.sell();
		System.out.println(vo1 + "\n");

		ProductService service2 = factory.getBean("service05", ProductService.class);
		ProductVO vo2 = service2.sell();
		System.out.println(vo2 + "\n");

		ProductService service3 = factory.getBean("service12", ProductService.class);
		ProductVO vo3 = service3.sell();
		System.out.println(vo3);
	}

}
