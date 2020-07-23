package cs02_sw;

import java.util.Scanner;

public class Sw05 {
	// Scanner로 입력 받아서 가위바위보 게임
	public static void main(String[] args) {

		int me, com;

		Scanner sc = new Scanner(System.in);

		System.out.println("가위(1) 바위(2) 보(3) >>");

		me = sc.nextInt();
		com = (int) (Math.random() * 3) + 1;

		System.out.printf("나: %d vs com: %d \n", me, com);
		/*	가위(1)바위(2)보(3)
		 *  com-me 값으로 판정
		 *  내가낸값	승(com-me)	패(com-me)	비김(com-me)	
				1		3(2)		2(1)		1(0)
				2		1(-1)		3(1)		2(0)
				3		2(-1)		1(-2)		3(0)
		*/
		switch (com - me) {
		case 1:
		case -2:
			System.out.println("컴퓨터 승리");
			break;
		case 2:
		case -1:
			System.out.println("내가이김");
			break;
		case 0:
			System.out.println("비김");
		default:
			System.out.println("잘못된 입력");
			break;
		}
	}
}
