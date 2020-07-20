package variable;

// 변수란? 값을 저장할 수 있는 메모리 공간
// 변수를 만든다 = 메모리 공간을 만든다.
// 해당 변수를 사용하면 주소를 가져와서 해당값을 받는다.
// 변수를 쓰는 이유: 값을 재활용, 일괄 수정
// 변수명명 규칙 : 대소문자 구분, 변수나 메소드 첫 글자는 소문자 - CamelCase, 상수는 모두 대문자.
// ace_of_kings : snake_case
public class Var01 {
	public static void main(String[] args) {
		// java 에서는 변수 선언시 타입 부여해야 한다.
		int num1; // 정수형 변수 num1을 선언 - 메모리에 4byte 공간을 확보하고 그 주소를 num1에 넣어줌
//		System.out.println(num1); 초기화 시키지 않아 사용 불가능
		num1 = 3; // 변수 num1을 3으로 초기화
		System.out.println(num1);
		num1 = 7;
		System.out.println(num1);
		
		int num2 = 333;
		int num3 = num1 + num2;
		System.out.println(num1 + " + " + num2 + " = " + num3);
	}
	
	
}
