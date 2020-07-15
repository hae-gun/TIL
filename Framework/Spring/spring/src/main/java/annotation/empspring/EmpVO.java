package annotation.empspring;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

//<bean id="vo" class="xxx.EmpVO">
@Component("vo")
public class EmpVO {
	String name;
	double salary;
	String deptname;
	
	//생성자추가 / toString
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

}
