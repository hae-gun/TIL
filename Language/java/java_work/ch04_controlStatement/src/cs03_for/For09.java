package cs03_for;

import java.util.Scanner;

public class For09 {
	public static void main(String[] args) {
		// 구구단
		Scanner sc = new Scanner(System.in);
		
		System.out.println("보고싶은 구구단>>>");
		
		int gugudan = sc.nextInt();
		
		System.out.println("구구단 "+gugudan+"단");
		
		for(int i=1; i<=9; i++) {
			System.out.printf("%d * %d = %2d\n",gugudan,i,gugudan*i);
		}
		
	}
}
