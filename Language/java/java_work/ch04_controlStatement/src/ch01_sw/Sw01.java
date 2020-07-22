package ch01_sw;
/*
 * switch(판별식/값)
 * case 1(정수): ~~~~~ break;
 * case 2(정수): ~~~~~ break;
 * case 3(정수): ~~~~~ break;
 * default: ~~~~~;

*/

import java.util.Scanner;

public class Sw01 {

	public static void main(String[] args) {
		// Scanner로 입력받아 숫자에 맞는 단어 출력
		// msg 1: "Love", 2: "Belief", 3: "Hope", 4: "Money" 그 이외의 수 : "Hate"
		System.out.println("1~4 사이의 숫자 입력>>>>>.");
		Scanner scan = new Scanner(System.in);
		int msg = scan.nextInt();
		
		switch (msg) {
		case 1:
			System.out.println("Love");
			break;
		case 2:
			System.out.println("Belief");
			break;
		case 3:
			System.out.println("Hope");
			break;
		case 4:
			System.out.println("Money");
			break;

		default:
			System.out.println("Hate");
			break;
		}
		scan.close();
		
	}

}
