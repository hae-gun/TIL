package emp;

import java.util.Date;

public class EmpVo {
	private int EmpNo;
	private String ename;
	private String EmpId;
	private String EmpPassword;
	private String Email;
	private int Salary;
	private Date JoinDate;
	private int sales;
	
	public EmpVo(int empNo, String eName, String empId, String empPassword, String email, int salary) {
		EmpNo = empNo;
		ename = eName;
		EmpId = empId;
		EmpPassword = empPassword;
		Email = email;
		Salary = salary;
	}

	

	public EmpVo(int empNo, String eName, String empId, String empPassword, String email, int salary, Date joinDate, int sales) {
		super();
		EmpNo = empNo;
		ename = eName;
		EmpId = empId;
		EmpPassword = empPassword;
		Email = email;
		Salary = salary;
		this.JoinDate = joinDate;
		this.sales = sales;
	}



	public int getEmpNo() {
		return EmpNo;
	}

	public void setEmpNo(int empNo) {
		EmpNo = empNo;
	}

	

	public String getEname() {
		return ename;
	}



	public void setEname(String ename) {
		this.ename = ename;
	}



	public String getEmpId() {
		return EmpId;
	}

	public void setEmpId(String empId) {
		EmpId = empId;
	}

	public String getEmpPassword() {
		return EmpPassword;
	}

	public void setEmpPassword(String empPassword) {
		EmpPassword = empPassword;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public int getSalary() {
		return Salary;
	}

	public void setSalary(int salary) {
		Salary = salary;
	}

	public Date getJoinDate() {
		return JoinDate;
	}

	public void setJoinDate(Date joinDate) {
		JoinDate = joinDate;
	}

	
	
	public int getSales() {
		return sales;
	}



	public void setSales(int sales) {
		this.sales = sales;
	}



	@Override
	public String toString() {
		return "EmpVo [EmpNo=" + EmpNo + ", ename=" + ename + ", EmpId=" + EmpId + ", EmpPassword=" + EmpPassword
				+ ", Email=" + Email + ", Salary=" + Salary + ", JoinDate=" + JoinDate + ", sales=" + sales + "]";
	}

	
}
