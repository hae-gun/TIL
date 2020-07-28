package array;

import java.util.Arrays;

public class Arr03 {
	public static void main(String[] args) {
		// sum, avg, max, min
		// int[] score = new int[10];
		int[] score = { 98, 77, 57, 69, 37, 82, 62, 86, 99, 48 };
		int sum = 0, max, min;
		double avg;

		System.out.println(score);// 주소값
		System.out.println(Arrays.toString(score));
		System.out.println(score[0]);
		System.out.println("=============================");

		// 점수 출력: 98 / 77 / ...
		for (int i = 0; i < score.length; i++) {
			if (i == score.length - 1) {
				System.out.print(score[i]);
			} else
				System.out.print(score[i] + " / ");
		}
		System.out.println("\n============== 확장 for문 ==================");
		for (int key : score) {
			System.out.print(key + " / ");
		}
		System.out.println("\n============== sum ==================");
		for (int k : score) {
			sum += k;
		}
		System.out.println("sum = " + sum);
		System.out.println("\n============== avg ==================");
		avg = sum / (double) score.length;
		System.out.println("avg = " + avg);
		System.out.println("\n============== max, min ================");
		max = min = score[0];
		//int[] score = { 98, 77, 57, 69, 37, 82, 62, 86, 99, 48 };
		for (int i = 1; i < score.length; i++) {
//			System.out.println("max: " + max);
//			System.out.println("min: " + min);
			if (max < score[i]) {
				max = score[i];
//				System.out.println("max: " + max);
			}
			if (min > score[i]) {
				min = score[i];
//				System.out.println("min: " + min);
			}
		}
		System.out.printf("1등의 점수는 %d이고 꼴찌의 점수는 %d입니다.\n", max, min);
	}
}
