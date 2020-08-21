package employee.dto;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable{
	
	private int bunho;
	private String name;
	private Date birth;
	private String tel;
	private String addr;
	private String email;

	public Employee() {
		
	}
	
	public Employee(String name, Date birth, String tel, String addr, String email) {
		this.name = name;
		this.birth = birth;
		this.tel = tel;
		this.addr = addr;
		this.email = email;
	}
	
	public Employee(int bunho, String name, Date birth, String tel, String addr, String email) {
		this.bunho = bunho;
		this.name = name;
		this.birth = birth;
		this.tel = tel;
		this.addr = addr;
		this.email = email;
	}

	public int getBunho() {
		return bunho;
	}

	public void setBunho(int bunho) {
		this.bunho = bunho;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [bunho=" + bunho + ", name=" + name + ", birth=" + birth + ", tel=" + tel + ", addr=" + addr
				+ ", email=" + email + "]";
	}
	
	
    
    
	
	
}
