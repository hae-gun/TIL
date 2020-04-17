package string;

import java.util.Scanner;

public class AsciiCode {

	
	// 백준 	11654 번 문제
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 입력값을 스트링으로 받음.
		String ascii = scan.next();
		// 받은 String 문자열중 첫번째 요소를 꺼내 char 형태로 저장.
		char Asc = ascii.charAt(0);
		// int casting 을 통해 아스키 code 출력
		System.out.println((int)Asc);
		scan.close();
	}
}