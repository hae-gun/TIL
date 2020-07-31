package api01_object;

class Student{
	
	int studentId;
	String studentName;
	
	public Student(int studentId, String studentName){
		this.studentId = studentId;
		this.studentName = studentName;
	}
	
	public String toString(){
		return studentId + "," + studentName;
	}

	@Override // object 클래스의 equals (객체 주소 비교) 를 오버라이딩
	public boolean equals(Object obj) { // 매개변수 Object 타입 - 모든 객체를 다 받을 수 있다.
		if(obj instanceof Student){// 만약 매개변수로 받은 오브젝트가 Student의 객체라면
			Student std = (Student)obj; // Student type으로 강제 형변환
			if( studentId == std.studentId) // this 객체의 id가 매개변수로 받은 객체의 id와 주소가 같다면 
				return true;
			else return false;
		}
		// 매개변수로 받은 객체가 Student 객체가 아닐때
		return false;
	}
//
	@Override
	public int hashCode() {
		return studentId;
	}
	
}

public class EqualsTest {

	public static void main(String[] args) {

		Student studentLee = new Student(100, "이상원");
		Student studentLee2 = studentLee; //
		Student studentSang = new Student(100, "이상원");
		// 동일한 주소의 두 인스턴스 비교
		if(studentLee == studentLee2)
			System.out.println("studentLee와 studentLee2의 주소는 같습니다.");
		else
			System.out.println("studentLee와 studentLee2의 주소는 다릅니다.");
		if(studentLee.equals(studentLee2))
			System.out.println("studentLee와 studentLee2는 동일합니다.");
		else
			System.out.println("studentLee와 studentLee2는 동일하지 않습니다.");
		
//		//주소는 다르지만 equals 의 결과가 true 인 경우
		if(studentLee == studentSang)
			System.out.println("studentLee와 studentSang의 주소는 같습니다.");
		else
			System.out.println("studentLee와 studentSang의 주소는 다릅니다.");
		if(studentLee.equals(studentSang))
			System.out.println("studentLee와 studentSang은 동일합니다.");
		else
			System.out.println("studentLee와 studentSang은 동일하지 않습니다.");
//
		System.out.println("studentLee의 hashCode :" +studentLee.hashCode());
		System.out.println("studentSang의 hashCode :" +studentSang.hashCode());
//		
		System.out.println("studentLee의 실제 주소값 :"+ System.identityHashCode(studentLee));
		System.out.println("studentSang의 실제 주소값 :"+ System.identityHashCode(studentSang));
	
	}
}
