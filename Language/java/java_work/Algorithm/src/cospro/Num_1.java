package cospro;

import java.util.Scanner;

public class Num_1 {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		long num = Long.parseLong(sc.nextLine());
		
		num += 1;
		
		String number = String.valueOf(num);
		
		number = number.replaceAll("0", "1");
		System.out.println(number);
		
	}
}
