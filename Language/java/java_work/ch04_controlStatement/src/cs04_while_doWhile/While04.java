package cs04_while_doWhile;

import java.util.Scanner;

public class While04 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = 0;
		boolean flag = true;

		while (flag) {
			System.out.println("보고싶은 구구단>>>  (2~9사이 입력,0:중단)");
			num = sc.nextInt();

			if (num == 0) {
				flag = false;
			} else if (num >= 2 && num <= 9) {
				System.out.printf("%d단 출력\n", num);
				for (int i = 1; i < 10; i++) {
					System.out.printf("%d * %d = %d\n", num, i, num * i);
				}
			} else {
				System.out.println("Error");
			}
		}
		
		System.out.println("시스템 종료...");

	}
}
