package class03_method;

public class Calculator {
	
	int memory;
	
	// void 는 return 값이 없는 매서드.
	void powerOn() {
		System.out.println("power on, welcome!");
	}
	
	// 반환값이 있는 매서드 : 요청을 처리하고 호출한 쪽으로 결과를 반환 - 결과타입 : int 
	int plus(int a, int b) {
		this.memory += (a+b);
		return a+b;
	}
	
	int minus(int a, int b) {
		this.memory += (a-b);
		return a-b;
	}
	
	int multi(int a, int b) {
		this.memory += (a*b);
		return a*b;
	}
	
	void devide(int a, int b) {
		this.memory += (a/b);
		System.out.println(a/b);
	}
	
	void powerOff() {
		System.out.println("power off, BYE!");
	}

	@Override
	public String toString() {
		return "Calculator [memory=" + memory + "]";
	}
	
}
