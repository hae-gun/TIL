package class03_method;

class Greeting{
	
	// recursion : 재귀함수.
	void greet(int x) {
		System.out.println("hi, I'm "+x);
		if(x<1) {
			return; //method 종료
		}
		greet(--x); // 자기 자신을 호출
	}
}

public class Recur01 {
	
	public static void main(String[] args) {
		Greeting greeting = new Greeting();
		
//		greeting.greet(3);
		greeting.greet(10000);
	}
}
