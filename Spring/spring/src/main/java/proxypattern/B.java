package proxypattern;

public class B implements ProxyInter {

	ProxyInter p;
	
	public void setP(ProxyInter p) {
		this.p = p;
	}

	@Override
	public void action() {
		System.out.println("B 클래스 action 시작");
		p.action();
		System.out.println("B 클래스 action 종료");
	}

}
