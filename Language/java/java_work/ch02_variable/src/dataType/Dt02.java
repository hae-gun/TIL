package dataType;
// Char : 문자형 - 알고보면 정수형
public class Dt02 {
	public static void main(String[] args) {
		
		char c1 = 'A';
		char c2 = 65;
		char c3 = '\u0041';
		
		System.out.println("c1: " + c1);
		System.out.println("c2: " + c2);
		System.out.println("c3: " + c3);
		
		// ASCII code 0A0D : 개행문자 \n
		
		int ic = c1; // char 타입의 변수값을 int 타입으로 형변환 - 자동형변환 : 크기가 작은 타입에서 큰 타입으로 형변환됨.
		System.out.println(ic);
		
		char c4 = '가';
		System.out.println(c4);
		
		ic = c4;
		System.out.println(ic); // 한글은 유니코드값으로 저장됨 가 -> 44032
		
		char c5 = 44033;
		System.out.println(c5);
		
	}

}
