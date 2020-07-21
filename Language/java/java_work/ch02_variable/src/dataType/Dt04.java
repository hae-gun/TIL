package dataType;

//import java.lang.*; 이 자동 import 됨.

// String : 문자열 - 기본데이터 타입이 아니다. 그러나 기본 데이터 타입처럼 사용이 가능하다.
// 참조변수 - 클래스 타입
public class Dt04 {
	public static void main(String[] args) {
		
		String str = "홍길동";
		System.out.println(str);
		
		System.out.println(str.charAt(0));
		System.out.println(str.charAt(1));
		System.out.println(str.charAt(2));
		
		// public   char  charAt  (int     index) 메소드 구성
		// 접근제한자  반환타입 메소드이름 매개변수타입 매개변수이름
	}
}
