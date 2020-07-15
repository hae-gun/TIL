package sort;

import java.util.Scanner;

public class SelectSort {

	public static void main(String[] args) {
		// 가장작은 수를 맨 앞으로 가져오는 알고리즘.

		Scanner scan = new Scanner(System.in);
		int[] array = { 10, 5, 6, 4, 8, 2, 1, 3, 7, 9 };
		int temp;
		int min;

		for (int i = 0; i < array.length ; i++) {
			min = i;
			for (int j = i ; j < array.length; j++) {

				if (array[min] > array[j]) {
					min = j;

				}
			}

			temp = array[min];
			array[min] = array[i];
			array[i] = temp;

		}
		for (int i : array) {
			System.out.printf("%2d ", i);
		}

	}

}
