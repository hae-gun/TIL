package proxypattern;

public class ProxyMain {

	public static void main(String[] args) {
		ProxyInter p = new C();
		B b1 = new B(); // A,C 객체 실행 공통 실행 내용 객체.
		b1.setP(p);
		b1.action(); // B + (A or C)
		
		System.out.println("====================================");
		p.action();
		
	}

}
