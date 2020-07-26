package backjoon;

import java.util.Scanner;

public class BEP {
	// 백준 손익분기점 문제. https://www.acmicpc.net/problem/1712
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int pixedCost;
		int cost;
		int price;

		Scanner sc = new Scanner(System.in);
		System.out.println("고정: ");
		pixedCost = sc.nextInt();
		System.out.println("생산: ");
		cost = sc.nextInt();
		System.out.println("가격: ");
		price = sc.nextInt();
		
		if (cost >= price) {
			System.out.println(-1);
		} else {
			System.out.println(pixedCost / (price-cost) +1);
		}
		
		
		
//		int totalCost = pixedCost + (cost * 0);
//		int income = price * 0;
//		int N = 0;

//		// 손익분기점이 없을때.
//		if (cost >= price) {
//			System.out.println(-1);
//
//		} else {
////		int totalCost = pixedCost + (cost * i),int income = N * price;
//			for (int i = 0; totalCost > income; i++) {
//				totalCost = pixedCost + (cost * i);
//				income = price * i;
//				N = i;
//			}
//			System.out.println(++N);
//		}

	}

}
