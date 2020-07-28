package array;

import java.util.Arrays;

/*
금주의 당첨번호 뽑아서 정렬
내 로또번호 뽑아서 정렬
두 로또번호 비교해서 맞은 개수 확인하고 등수 출력
*/
public class Arr11 {
	public static void main(String[] args) {
		int[] lotto = new int[6];

		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = (int) (Math.random() * 45) + 1;

			for (int j = 0; j < i; j++) {
				if (lotto[i] == lotto[j]) {
					i--;
					break;
				}
			}

		}
		int[] myLotto = { 10, 18, 32, 41, 2, 7 };
//		Arrays.sort(lotto);
//		Arrays.sort(myLotto);
		
		boolean change;
		
		// lotto 번호 정렬
		for (int i = 0; i < lotto.length - 1; i++) {
			//System.out.println(Arrays.toString(lotto));
			change = false;
			for (int j = 0; j < lotto.length - 1 - i; j++) {
				if (lotto[j] > lotto[j + 1]) {
					int tmp = lotto[j];
					lotto[j] = lotto[j + 1];
					lotto[j + 1] = tmp;
					change = true;
				}
			}
			if(!change) break;
		}
		
		// 나의 lotto 번호 정렬
		for (int i = 0; i < myLotto.length - 1; i++) {
			//System.out.println(Arrays.toString(myLotto));
			change = false;
			for (int j = 0; j < myLotto.length - 1 - i; j++) {
				if (myLotto[j] > myLotto[j + 1]) {
					int tmp = myLotto[j];
					myLotto[j] = myLotto[j + 1];
					myLotto[j + 1] = tmp;
					change = true;
				}
			}
			if(!change) break;
		}
		
		int count = 0;
		
		// 맞는 갯수 확인
		for (int i = 0; i < lotto.length; i++) {
			for (int j = 0; j < lotto.length; j++) {
				if (lotto[i] == myLotto[j])
					count++;
			}
		}
		

		System.out.println(Arrays.toString(lotto));
		System.out.println(Arrays.toString(myLotto));
		System.out.println("맞은수: " + count);
		
		switch (count) {
		case 6:
			System.out.println("1 등");
			break;
		case 5:
			System.out.println("2 등");
			break;
		case 4:
			System.out.println("3 등");
			break;
		case 3:
			System.out.println("4 등");
			break;

		default:
			System.out.println("다음 기회에..");
			break;
		}

	}
	
	
}
