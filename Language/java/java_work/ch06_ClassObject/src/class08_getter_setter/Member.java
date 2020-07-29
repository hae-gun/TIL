package class08_getter_setter;

public class Member {
	
	private String name;
	private int age;
	private String id;
	private String pwd;
	
	private boolean login = false;

	
	
	
	public Member(String name, int age, String id, String pwd) {
		super();
		this.name = name;
		this.age = age;
		this.id = id;
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public boolean isLogin() {
		return login;
	}

	public void setLogin() {
//		if(this.login==true) {
//			this.login = false;
//		}else {
//			this.login = true;
//		}
		this.login = !login;
	}

	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + ", id=" + id + ", pwd=" + pwd + ", login=" + login + "]";
	}
	
	
	
}
