package class02;

public class Student {
	String name;
	String school;
	int grade;

	public Student() {
	}

	public Student(String name) {
		this.name = name;
	}

	public Student(String name, String school) {
		this.name = name;
		this.school = school;
	}

	public Student(String name, String school, int grade) {
		this.name = name;
		this.school = school;
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", school=" + school + ", grade=" + grade + "]";
	}
	
}
