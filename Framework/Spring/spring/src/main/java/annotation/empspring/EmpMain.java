package annotation.empspring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpMain {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("annotation/empspring/emp.xml");
		//SPRING BEAN CONFIGURATION XML
		//factory.getBean("a",EmpVO.class);
		// 스프링 설정내용 객체생성: 1개 만든 생성자를 공유: singleton 방식.
		EmpDAO dao = factory.getBean("dao", EmpDAO.class);
		dao.insertEmp(); 
		// 2
//		EmpDAO dao2 = factory.getBean("dao", EmpDAO.class);
//		EmpDAO dao3 = factory.getBean("dao", EmpDAO.class);
//		EmpDAO dao4 = factory.getBean("dao", EmpDAO.class);
		
	}

}
