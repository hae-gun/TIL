package class07_access_modifier.pack1;

/*
 * 접근제한자: 
 * public: 프로젝트 전체에서 접근 가능
 * protected: 같은 패키지와 다른 패키지의 상속 받은 클래스에서 접근 가능
 * default: 같은 패키지에서 접근 가능
 * private: 클래스 내부에서만 접근 가능
 */

public class A {
	
	//field
	public int public_int = 0;
	protected int protected_Int=1;
	int default_int=2;
	private int private_int =3;
	
	//constructor
	public A() {}
	protected A(boolean t) {}
	A(String s) {}
	private A(int d) {}
	
	public static void main(String[] args) {
		A a1 = new A();
		A a2 = new A(true);
		A a3 = new A("hi");
		A a4 = new A(3);
		
		System.out.println(a1.public_int);
		System.out.println(a1.protected_Int);
		System.out.println(a1.default_int);
		System.out.println(a1.private_int);
	}
	
	
	
}
