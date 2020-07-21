package dataType;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerEx {
	public static void main(String[] args) throws FileNotFoundException {
		
		// System의 입력 데이터를 읽어들이는 Scanner 객체 생성
		Scanner scan = new Scanner(System.in);
		System.out.println("아무 값이나 입력>>>");
		String str = scan.nextLine(); // 입력값 한 줄을 문자열로 받아서 str에 저장.
		System.out.println(str);
	
		System.out.println("덧셈할 첫 번째 정수입력>>");
		String input = scan.nextLine();
		int num1 = Integer.parseInt(input); // 매개변수 값을 정수로 형변환
		
		System.out.println("덧셈할 두 번째 정수입력>>");
		input = scan.nextLine();
		int num2 = Integer.parseInt(input);
		
		System.out.printf("num1: %d 와 num2: %d 의 합계는 %d 입니다\n",num1,num2,num1+num2);
		
		scan.close(); // inputstream을 닫아줌 - 메모리절약, 충돌방지.
		
		File file = new File("a.txt"); 
		Scanner sc = new Scanner(file); // File 읽기도 가능하다.
		System.out.println(sc.nextLine());
	}
}
