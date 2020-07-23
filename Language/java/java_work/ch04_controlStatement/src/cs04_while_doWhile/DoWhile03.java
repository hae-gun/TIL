package cs04_while_doWhile;

import java.util.Scanner;

// Up Down 게임
public class DoWhile03 {
	public static void main(String[] args) {

		int answer, input, num;
		int times = 0;

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("게임을 하려면 1~9 중단하려면 0을 입력하세요>>>");
			num = sc.nextInt();
			if (num == 0) {
				break;
			} else {
				answer = (int) (Math.random() * 100) + 1;
			}

			do {
				System.out.println("1~100 사이 정수입력>>>>");

				input = sc.nextInt();

				if (answer > input) {
					System.out.println("Up");
				} else if (answer < input) {
					System.out.println("Down");
				}

				times++;

			} while (input != answer);

			System.out.printf("%d 번만에 맞춤\n", times);
			times = 0;
//			while(input != answer) {
//				
//			}

		}
		System.out.println("겜끝");
		sc.close();

	}
}
