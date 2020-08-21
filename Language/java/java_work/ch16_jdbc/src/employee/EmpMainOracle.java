package employee;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import employee.dao.EmpDao;
import employee.dao.EmpDaoImpl;
import employee.dto.Employee;

public class EmpMainOracle {
	public static void main(String[] args) {
		EmpDao dao = EmpDaoImpl.getInstance();
		
		
//		List<Employee> li = dao.selectAll();
//		for(Employee e:li) {
//			System.out.println(e);
//		}
		System.out.println("===================================================================================================");
		
		List<Employee> li1 = dao.selectName("강");
		for(Employee e:li1) {
			System.out.println(e);
		}
		
		System.out.println("===================================================================================================");

		Employee e1 = new Employee();
		e1.setName("이혜빈");
		e1.setBirth(Date.valueOf(LocalDate.of(1992,2,29)));
		e1.setTel("010-3333-7777");
		e1.setAddr("서울 이태원");
		e1.setEmail("rrr@bbb.com");
		
		boolean result = dao.insertEmployee(e1);
		if(result) {
			System.out.println("insert succeed");
		}else {
			System.out.println("insert failed");
		}
		
		
		System.out.println("===================================================================================================");
		
		// 4번 공갈탄 삭제	
		boolean result3 = dao.deleteEmpl(5);
		if(result) {
			System.out.println("삭제완료");
		}else {
			
		}
		
	}
}
