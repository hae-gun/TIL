package class09_inheritance;

class A{
	int a =1;
	
	void a() {
		System.out.println("parent a()");
	}
	
	@Override
	public String toString() {
		return "a = " + a + " 안녕";
	}
}

// 상속(extends): super class(부모클래스)와 변수와 메소드를 그대로 물려받고
// 추가로 자기 변수와 자기 메소드를 가질 수도 있으며, 물려받은 변수와 메소드를 고쳐서 쓸 수도 있다.
class B extends A{
	
	int b = 7;
	void b() {
		System.out.println("child b()");
	}
	
	@Override
	void a() {
		System.out.println("child a()");
		super.a();
	}
	
}


public class In01 {
	public static void main(String[] args) {
		A a1 = new A();
		a1.a();
		System.out.println(a1.a);
		System.out.println(a1);
		System.out.println("-------------");
		
		B b1 = new B();
		b1.a();
		System.out.println(b1.a);
		System.out.println(b1);
		b1.b();
		System.out.println(b1.b);
		System.out.println(b1);
		System.out.println("-------------");
		
		
		// 자식이 부모옷을 입음
		A a2 = new B();
		a2.a(); // 부모 옷을 입고 있어도 재정의 (overriding) 한 메소드는 자기 메소드 실행. 다형성
		
		B b2 = (B)a2;
		b2.b();
		((B)a2).b();
		
	}
}
