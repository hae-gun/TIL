package cs04_while_doWhile;

import java.util.Scanner;

public class While03 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num, sum = 0;
		boolean flag = true;

		while (flag) {
			sum = 0;
			System.out.println("1부터의 합계 구하고픈 숫자 입력, 중단:0 >>>");
			num = sc.nextInt();

			if (num == 0) {
				flag = false;
			} else {

				for (int i = 1; i <= num; i++) {
					sum += i;
				}
				System.out.printf("1부터 %d 까지의 합: %d\n", num, sum);
			}
		}

		System.out.println("프로그램 종료..");
		sc.close();

	}
}
