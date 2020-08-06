package dto;

import java.io.Serializable;

public class Person implements Serializable,User{
	
	private String id;
	private String pw;
	private String name;
	
	public Person() {
		
	}
	
	public Person(String id, String pw, String name) {
		this.id = id;
		this.pw = pw;
		this.name = name;
	}

	public String getId() {
		return id;
	}


	public String getPw() {
		return pw;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		int code =0;
		
		for(int i=0; i<id.length();i++) {
			code = id.charAt(i)*(int)Math.pow(10, i);
		}
		// TODO Auto-generated method stub
		return id.charAt(0);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(((Person)obj).getId().equals(this.getId())&&
				((Person)obj).getPw().equals(this.getPw())) {
			return true;
		}
		return false;
	}
	

	@Override
	public boolean login(String id, String pw) {
		if(id.equals(this.id) && pw.equals(this.pw)) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Person [id=" + id +", name=" + name + "]";
	}
	
	
	
	
	
}
