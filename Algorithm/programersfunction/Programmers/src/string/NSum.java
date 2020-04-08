package string;

import java.util.Scanner;

public class NSum {

	// 백준 11702번 문제
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int sum = 0;
		
		int count = scan.nextInt();
		String allNum = scan.next();
		
		char[] iNum = allNum.toCharArray();
		
		for(char a : iNum) {
			sum += (int)(a-'0');
		}
		System.out.println(sum);
	}

}
