package dto;

import java.util.Date;

public class User {
	
	private String id;
	private String name;
	private int age;
	private Date hiredate;
	
	
	


	public User(String id, String name, int age, Date hiredate) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.hiredate = hiredate;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Date getHiredate() {
		return hiredate;
	}


	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}


	@Override
	public String toString() {
		return "User [age=" + age + ", id=" + id + ", name=" + name + ", hiredate=" + hiredate + "]";
	}
	
	
	
	
	
	
}
