package string;

import java.util.Scanner;
<<<<<<< HEAD
=======

public class MaxCountAlp {
>>>>>>> 5154994502597b5f61187f668d880d13cb1c78bb

public class MaxCountAlp {
	// 백준 1157번 문제
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String S = scan.next();
<<<<<<< HEAD
		// 받은 문자열 모두 대문자로 변경.
		S = S.toUpperCase();
		int index = 0;
		int maxCount = 0;
		int count = 0;
		// 각 문자열을 확인하기 위해 char배열로 변경.
		char[] set = S.toCharArray();

		// 각 문자열에 사용된 알파벳 숫자 알기위한 배열.
		// index : 알파벳
		// value : 나온 횟수
		// 0 : A ~ 25 : Z
		int[] alpha = new int['z' - 'a' + 1];

		// 알파뱃 위치를 찾아 1씩 증가.
		for (int i = 0; i < set.length; i++) {

			alpha[set[i] - 65]++;

		}
		
		for (int a : alpha) {
			System.out.print(a + " ");
		}
		
		System.out.println();
		
		// 가장많이 나온 알파벳 찾기.
		for (int i = 0; i < alpha.length; i++) {
			maxCount = Math.max(maxCount, alpha[i]);
		}
		// Max 값을 찾아 index에 저장.
		for (int i = 0; i < alpha.length; i++) {
			index = maxCount == alpha[i] ? i : index;
			// maxCount 값이 동일한 값이 있을경우 count++
			// count 가 1이면 중복된값 없음.
			if (maxCount == alpha[i]) {
				count++;
			}
		}

		System.out.println("최고 반복 횟수 : " + maxCount);
		System.out.println("최고 위치 : " + index);
		if (count == 1) {
			System.out.println((char) (index + 65));
		} else {
			System.out.println("?");
		}

=======
>>>>>>> 5154994502597b5f61187f668d880d13cb1c78bb
	}

}
