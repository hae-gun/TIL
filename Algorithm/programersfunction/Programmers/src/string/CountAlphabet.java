package string;

import java.util.Scanner;

public class CountAlphabet {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String S = scan.next();

		int[] count = new int[(int) ('z' - 'a')];
		char[] split = S.toCharArray();

		for (int i = 0; i < count.length; i++) {
			count[i] = -1;
		}
		for (int i = 0; i < split.length; i++) {
			if (count[split[i] - 'a'] == -1) {
				count[split[i] - 'a'] = i;
			}
		}

		for (int Cnt : count) {
			System.out.print(Cnt + " ");
		}

	}

}
