package class09_inheritance;

class Parent{
	String name;
	int age;
	int allowance = 5000;
	
	public Parent() {}
	public Parent(String name, int age) {
		this.name = name; 
		this.age = age;
	}
	
	void print() {
		System.out.println("name: " + name);
		System.out.println("age: "+ age);
	}
}

class Student extends Parent{
	int grade;
	int allowance = 20000;
	
	public Student() {} //부모의 기본 생성자가 없으면 에러
	public Student(String name, int age, int grade) {
		//this.name = name; this.age = age;
		super(name, age); //부모 생성자 빌려쓰기 - 부모 객체부터 만들어야 자식 객체 생성 가능하기 때문
		this.grade = grade;
	}
	
	@Override
	void print() {
		super.print();
		System.out.println("grade: "+ grade);
	}
}

public class In03 {
	public static void main(String[] args) {
		Parent p1 = new Parent("tom", 52);
		//p1.print();
		
		Parent p2 = new Student("ace", 23, 3);
		
		Parent[] pr = new Parent[3];
		pr[0] = p1;
		pr[1] = p2;
		pr[2] = new Student("jack", 21, 1);
		
		for(Parent p : pr) {
			p.print();
			if(p instanceof Student) {
				System.out.println(((Student)p).allowance);
			}else {
				System.out.println(p.allowance);
			}
			System.out.println("===========================");
		}
	}
	
	
}






