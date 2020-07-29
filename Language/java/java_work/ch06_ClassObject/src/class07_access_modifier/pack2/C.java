package class07_access_modifier.pack2;

import class07_access_modifier.pack1.A;

public class C extends A{
	public static void main(String[] args) {
		//import하면 다른 패키지의 public 생성 가능
		A a1 = new A();
		//import 해도 생성불가
//		A a2 = new A(true);
//		A a3 = new A("big");
//		A a4 = new A(4); 
		
		//패키지가 다른 경우 public만 사용 가능
		System.out.println(a1.public_int);
		//pack1의 A 클래스를 상속받았으므로 자기 객체 생성 이후 
		//A의 protected에 접근 가능
		C c = new C();
		System.out.println(c.protected_Int);
		//System.out.println(c.default_int);
		
	}
}
