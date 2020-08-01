package api05_math_random;

import java.util.Arrays;
import java.util.Random;

public class RandomEx {
	public static void main(String[] args) {

		int[] selNum = new int[6];
		// random 함수에 seed를 주면 랜덤한 값이 일정하게 나옴.
		// 같은 seed는 같은 랜덤한
		// 시드를 주어도 한 객체에서 매서드를 다시 사용하면 다시 랜덤한 값 나
		Random random = new Random(2);

		System.out.println("선택 번호: ");
		for (int i = 0; i < selNum.length; i++) {
			selNum[i] = random.nextInt(45) + 1;
		}

		Arrays.sort(selNum);
		for (int i : selNum) {
			System.out.printf("%d, ", i);
		}
		for (int i = 0; i < selNum.length; i++) {
			selNum[i] = random.nextInt(45) + 1;
		}
		
		Arrays.sort(selNum);
		for (int i : selNum) {
			System.out.printf("%d, ", i);
		}

		Random rd1 = new Random(2);
		int[] winNum = new int[6];

		System.out.println();
		for (int i = 0; i < winNum.length; i++) {
			winNum[i] = rd1.nextInt(45) + 1;
		}

		Arrays.sort(winNum);
		for (int i : winNum) {
			System.out.printf("%d, ", i);
		}

		System.out.println();
		boolean result = Arrays.equals(winNum, selNum);
		if (result) {
			System.out.println("wow, 당첨");
		}else {
			System.out.println("bye");
		}
	}
	
	
}
