package string;

import java.util.Scanner;

public class CountWord {

	public static void main(String[] args) {

//		Scanner scan = new Scanner(System.in);
//		String input = scan.nextLine();
//		
//		
//		
//		//String input = " abc def0 ";
//		char[] temp = input.toCharArray();
//		
//		if(temp[0]==' ') {
//			temp[0]='x';
//		}
//		if(temp[temp.length-1]==' ') {
//			temp[temp.length-1]='x';
//		}
//		StringBuffer refactor = new StringBuffer();
//		
//		refactor.append(temp);
//		
//		
//		String[] word = refactor.toString().split(" ");
//		System.out.println(word.length);
// 		위 코드의 문제점 
//		아무것도 입력하지 않았을 때도 1이 출력됨
//		ex) " " 을 입력했을 때도 1이 출력이 됨.
		
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine().trim();
		// 변수 사용없이 trim 을 이용하여 받은 값을 바로 적용.
		if (input.isEmpty()) {
			System.out.println("0");
		} else {
			System.out.println(input.split(" ").length);
		}

	}

}
