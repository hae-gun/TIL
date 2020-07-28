package lotto;

import java.util.Arrays;

//1.금주의 당첨번호 뽑아서 정렬
//2.내 로또번호 랜덤으로 뽑아서 정렬(또는 내가 입력하기)
//3. 2개의 로또번호 비교해서 맞은 개수 확인하고 등수 출력이번주 과제입니다

public class Lotto {
	public static void main(String[] args) {

		int[] lotto = new int[6];
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = (int) ((Math.random() * 45) + 1);
			if (i != 0) {
				boolean check = false;

				for (int j = 0; j < i; j++) {
					if (lotto[j] == lotto[i]) {
						check = true;
						break;
					}
				}
				if (check) {
					i--;
					continue;
				}
			}
		}
		
		
		
		
		Arrays.sort(lotto);
	}
}
