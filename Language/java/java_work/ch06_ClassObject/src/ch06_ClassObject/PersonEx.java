package ch06_ClassObject;

public class PersonEx {
	public static void main(String[] args) {
		
		Person chk = new Person(); // new - class로 객체를 찍어내는 틀. 힙메모리에 Person 클래스의 object를 등록.
		
		// 메모리에 로드된 object(상태) - instance.
		
		chk.age=27;
		chk.name = "최혜근";
		chk.nationality = "Korea";
		chk.nickName = "근";
		
		
		System.out.println("이름: " + chk.name);
		System.out.println("나이: " + chk.age);
		
		
		Person kkk = new Person();
		kkk.age=27;
		kkk.name = "asdf";
		kkk.nationality = "Korea";
		kkk.nickName = "aaa";
		System.out.println("---------");
		Person[] ps ={chk,kkk};
		
		for(Person p : ps) {
			System.out.println("이름: " + p.name);
			System.out.println("나이: " + p.age);
			System.out.println("---------");
		}
		
		Car car1 = new Car();
		
		chk.car = car1;
		System.out.println(chk.car.brand); // . 의 의미 : '.' 앞에 객체 안을 의미함.
	}
}
