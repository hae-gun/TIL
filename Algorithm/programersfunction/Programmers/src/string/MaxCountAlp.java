package string;

import java.util.Scanner;

public class MaxCountAlp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String S = scan.next();
		S = S.toUpperCase();
		int index = 0;
		int maxCount = 0;
		int count = 0;
		char[] set = S.toCharArray();

		int[] alpha = new int['z' - 'a' + 1];

		for (int i = 0; i < set.length; i++) {

			alpha[set[i] - 65]++;

		}
		
		for (int a : alpha) {
			System.out.print(a + " ");
		}
		
		System.out.println();
		
		for (int i = 0; i < alpha.length; i++) {
			maxCount = Math.max(maxCount, alpha[i]);
		}
		for (int i = 0; i < alpha.length; i++) {
			index = maxCount == alpha[i] ? i : index;
			if (maxCount == alpha[i]) {
				count++;
			}
		}

		System.out.println("최다 빈도수 : " + maxCount);
		System.out.println("Index : " + index);
		if (count == 1) {
			System.out.println((char) (index + 65));
		} else {
			System.out.println("?");
		}

	}

}
