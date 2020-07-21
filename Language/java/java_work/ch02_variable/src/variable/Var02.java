package variable;

public class Var02 {
	public static void main(String[] args) {
		int var1 = 15;
		int var2,var3;
//		var4 = 10; // 타입을 부여하지 않고 (선언하지 않고) 초기화 불가능.
		var2 = 015; // 8진수
		var3 = 0x15; // 16진수
		System.out.println("var1: "+ var1);
		System.out.println("var2: "+ var2);
		System.out.println("var3: "+ var3);
		int var5 = 1;
		System.out.println(var5);
	}
}
