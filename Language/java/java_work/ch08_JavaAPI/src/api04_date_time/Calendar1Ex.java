package api04_date_time;

import java.util.Calendar;
import java.util.Scanner;

public class Calendar1Ex {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// 데이터 입력부분
		System.out.println("희망 년도와 월을 입력 (ex년도: 2009,월 : 3)");
		System.out.println("년도: ");
		int year = scan.nextInt();
		System.out.println("월: ");
		int month = scan.nextInt();
		
		System.out.printf("[%d 년 %d 월]",year,month);
		System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=");
		System.out.println("    일   월   화   수   목   금   토");
		Calendar cal = Calendar.getInstance();
		
		int lastOfDate = cal.getActualMaximum(Calendar.DATE);
		int week = cal.get(Calendar.DAY_OF_WEEK);
		
		for(int i=1; i<week; i++) 
			System.out.printf(" ");
		
		for(int i=1; i<=lastOfDate; i++) {
			System.out.print((i<10) ? "  "+i:" "+i);
			if(i%7==0) {
				System.out.println();
				week++;
			}
		}
		
		System.out.println("\n-=-=-=-=-=-=-=-=-=-=-=-=-=");
	}
}
