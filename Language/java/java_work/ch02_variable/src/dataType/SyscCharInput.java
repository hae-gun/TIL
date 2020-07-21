package dataType;

import java.io.IOException;

public class SyscCharInput {

	public static void main(String[] args) throws IOException {

		char a = '0';
		System.out.println(a);
		System.out.println((int) a);

		System.out.println("2부터 9사이의 숫자를 입력하세요>>> ");
//		int num = System.in.read() - 48;
		int num = System.in.read() - '0';
		System.out.printf("입력한 숫자는 %d입니다. \n", num);
		
		// enter 값 발생 : 다음입력을 위해 처리
		// \r\n : 엔터키 값. 13 10
		// 두 값을 받아서 변수에 저장하지 않으면 쓰레기 처리반 (garbage collector 가 처리)
//		System.in.read(); // \r
//		System.in.read(); // \n
		
		System.in.skip(2); // 입력 2개 건너뛰기
		
		System.out.println("a~z 사이의 문자 하나를 입력하세요>>> ");
		char input = (char) System.in.read();

		System.out.printf("입력한 문자는 %c입니다. \n", input);

	}

}