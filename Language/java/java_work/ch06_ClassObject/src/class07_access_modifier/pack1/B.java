package class07_access_modifier.pack1;

public class B {
	public static void main(String[] args) {
		A a1 = new A();
		A a2 = new A(true);
		A a3 = new A("hi");
		//private은 클래스 내부에서만 접근 가능
		//A a4 = new A(3);
		
		System.out.println(a1.public_int);
		System.out.println(a1.protected_Int);
		System.out.println(a1.default_int);
		//System.out.println(a1.private_int);
	}
}
