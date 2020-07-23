package cs04_while_doWhile;

import java.util.Scanner;

public class While_05 {
	public static void main(String[] args) {
		int me, com;
		int myWin = 0, comWin = 0;
		int times=0;
		boolean flag = true;
		
		String[] kind = {"가위","바위","보"};
		Scanner sc = new Scanner(System.in);
		while (flag) {
			System.out.println("가위(1) 바위(2) 보(3) >> (1~3만 입력)");
			

			me = sc.nextInt();
			
			if(me>3 || me <1) {
				System.out.println("잘못된 입력");
				continue;
			}
			com = (int) (Math.random() * 3) + 1;

			System.out.printf("나: %s vs com: %s \n", kind[me-1], kind[com-1]);
			/*
			 * 가위(1)바위(2)보(3) com-me 값으로 판정 내가낸값 승(com-me) 패(com-me) 비김(com-me) 1 3(2) 2(1)
			 * 1(0) 2 1(-1) 3(1) 2(0) 3 2(-1) 1(-2) 3(0)
			 */
			switch (com - me) {
			case 1:
			case -2:
				System.out.println("컴퓨터 승리");
				comWin++;
				break;
			case 2:
			case -1:
				System.out.println("내가이김");
				myWin++;
				break;
			case 0:
				System.out.println("비김");
				break;
			default:
				System.out.println("잘못된 입력");
				break;

			}
			times++;
			System.out.printf("나(%d) : 컴(%d)\n",myWin, comWin);
			if (myWin >= 3 || comWin >= 3) {
				flag = false;
			}
		}
		System.out.printf(">>>>>>>>총 %d판<<<<<<<<\n",times);
		System.out.printf("나(%d) : 컴(%d)\n",myWin, comWin);
		sc.close();
	
	}
}
