package variable;

//scope : 변수 사용 범위
public class Var03 {

	int num; // field: 자동 초기화 - 저절로 0값이 들어감.
//	static String s;
//	static boolean a;
	// 메소드 안에서 선언하는 변수 : local 변수 - 해당 method 안에서만 인식된다.
	public static void main(String[] args) {
		int var1; // 로컬 변수는 초기화 해야 사용이 가능하다.
		var1 = 30;
		if (true) {
			int var2; // if 문 안에서만 참조 가능.
			var1 = 77;
			var2 = 33;
			System.out.println("var1: " + var1);
			System.out.println("var2: " + var2);
			System.out.println("------------------------");
//		var2 = 17;
			
		}
//		System.out.println(s + a);

	}
	
	void print() {
//		System.out.println(var1); // main 메소드에서 선언한 변수이므로 참조가 불가능하다.
	}
}
