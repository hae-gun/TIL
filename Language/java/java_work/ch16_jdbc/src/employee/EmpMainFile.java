package employee;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import employee.dto.Employee;

public class EmpMainFile {
	public static void main(String[] args) {
		Employee e1 = new Employee("홍길동", Date.valueOf(LocalDate.of(1999,12,31)), "123123", "to", "uesd");
		Employee e2 = new Employee("tom", Date.valueOf(LocalDate.of(1999,12,31)), "123123", "to", "uesd");
		System.out.println(e1);
		
		File file = new File("emp.txt");
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			// 선언은 부모 타입으로 생성은 자식 객체로: 객체 활용의 융통성 etc
			List<Employee> emList = new ArrayList<>();
			emList.add(e1);
			emList.add(e2);
			
			for (Employee k : emList){
				System.out.println(k);
			}
			for (Employee k : emList) {
				oos.writeObject(k);
			}
			oos.flush();
			fos.close();
			oos.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
