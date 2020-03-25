package com.algorithm.number_rect;

import java.util.Scanner;

public class NumberRect_01 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		int arr[][] = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n ; j++) {
				arr[i][j] = (i*n)+j+1;
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n ; j++) {
				System.out.printf("%2d ",arr[i][j]);
			}
			System.out.println();
		}
		
		
	}
}
