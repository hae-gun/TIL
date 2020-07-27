package class04_static;

public class Static_Careful {

	int field1; //인스턴스 변수
	//생성된 객체를 통해서만 사용가능한 메소드
	void method1() {
		System.out.println("method1");
	}
	
	static int field2;//객체들이 공유하는 변수 - 클래스 변수
	//객체 생성 없이 쓸 수 있는 메소드
	static void method2() {
		System.out.println("method2");
	}
	
	public Static_Careful() {
		System.out.println("생성자");
		field1 = 15;
		method1();
	}
	
	//static 블록(static 초기화 블록)
	static {
		System.out.println("static block");
		field2 =10;
		method2(); //프로그램 실행시 자동 실행 
		
		//field1 = 5; //field1은 아직 없네요. 
		//method1();
		
		//static 블록에서 static이 아닌 변수와 메소드를 다루려면 객체부터 생성
		Static_Careful sc = new Static_Careful();
		sc.field1 = 5;
		sc.method1();
		System.out.println(sc.field1);
		
	}
}
