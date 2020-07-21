package dataType;

public class Dt06 {

	// field (전역변수)
	String name; // 자동 초기화

	public static void main(String[] args) {
		int intV = 10;
		double doubleV = 5.5;

		double result1 = intV + doubleV; // 자동형변환 : int + double -> double
		int result2 = (int) (intV + doubleV); // 강제형변환
		int result3 = intV + (int) doubleV; // 강제형변환

		System.out.println(result1 + " : " + result2 + " : " + result3);

		char a = 'A';
		char b = 'A' + 1; // 'B'
		System.out.println(a + " : " + b);

		int c = a + 1;// => 65 + 1

		char d = (char) (a + 1); // 변수를 정수와 연산하면 int값으로 반환된다. 따라서 (char)를 해줘야 함

		System.out.println(c + " : " + d);

		// 필드 변수 자동 초기화 값
		String str = ""; // 빈 문자열로 초기화
		int num = 0;
		float fl = 0.0f;
//		char e = ''; // char는 빈 문자로 초기화 할 수 없다.

		byte b1 = 10;
		byte b2 = 20;
		byte result = (byte) (b1 + b2); // int 보다 작은 타입을 연산하면 자동으로 int로 형변환된다.
		System.out.println(result);

	}

}
