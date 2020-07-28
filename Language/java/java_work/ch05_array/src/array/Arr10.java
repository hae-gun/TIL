package array;

import java.util.Arrays;

public class Arr10 {
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
		
		System.out.println(Arrays.toString(lotto));
		
		int times=0;
		//selection sort
//		int tmp;
//		for(int i=0; i<lotto.length-1; i++ ) {
//			for(int j = i + 1; j<lotto.length; j++) {
//				if(lotto[i]>lotto[j]) {
//					tmp = lotto[i];
//					lotto[i] = lotto[j];
//					lotto[j] = tmp;
//				}
//			times++;	
//			}
//		}
//		System.out.println(times);
//		System.out.println(Arrays.toString(lotto));
		
		
		// bubble sort 

		int tmp; boolean change;
		for (int i = 0; i < lotto.length - 1; i++) {
			//System.out.println(Arrays.toString(lotto));
			change = false;
			for (int j = 0; j < lotto.length - 1 - i; j++) {
				if (lotto[j] > lotto[j + 1]) {
					tmp = lotto[j];
					lotto[j] = lotto[j + 1];
					lotto[j + 1] = tmp;
					change = true;
				}
				times++;
			}
			if(!change) break;
		}
		System.out.println(times);
		System.out.println(Arrays.toString(lotto));
	}
}
