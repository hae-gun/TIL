package sort;

import java.util.Scanner;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arraySet = { 1, 8, 7, 6, 5, 4, 3, 9, 2, 10 };
		for (int i =  arraySet.length-1; i >=0; i--) {
			for(int j=0; j<=i-1;j++) {
				if(arraySet[j]>arraySet[j+1]) {
					int temp = arraySet[j+1];
					arraySet[j+1] = arraySet[j];
					arraySet[j] = temp;
				}
			}
		}
		for(int i : arraySet) {
			System.out.printf("%2d ",i);
		}

	}

}
