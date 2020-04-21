package string;

import java.util.Scanner;

public class RepeatString {
	// 백준 2675번 문제
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int Case = scan.nextInt();
		for (int k = 0; k < Case; k++) {
			int repeat = scan.nextInt();
			char[] S = scan.next().toCharArray();
			for (int i = 0; i < S.length; i++) {
				for (int j = 0; j < repeat; j++) {
					System.out.print(S[i]);
				}
			}
			System.out.println();
		}
	}

}
