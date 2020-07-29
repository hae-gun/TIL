package class08_getter_setter;

public class Person {
	
	private String name;
	private String idNo;
	private int age;

	public Person() {
	}

	public Person(String name, String idNo, int age) {
		this.name = name;
		this.idNo = idNo;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", idNo=" + idNo + ", age=" + age + "]";
	}

}
