package ch06_ClassObject;
// class란? 객체를 정의해 놓은 것 - 객체 생성의 도구 - 객체 찍어내는 툴 - 추상화의 결과.
public class Person {
	// 속성 : 클래스의 특징, 특성 - 객체 집합이 공통적으로 갖는 성격 - 멤버 변수, 전역변수, 필드 - DB table의 컬럼 명
	// field, attribute, member variable(맴버변수), instance variable(인스턴스)
	
	String name; // null
	int age; // 0
	String nickName;
	String nationality;
	Car car;
	
	// 기능 : 메소드(method), 행위(behavior), 함수(function) - 함수는 살짝 다른 의미.
	
	void smile(){
		System.out.println("깔깔깔");
	}
	
}
