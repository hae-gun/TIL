package cs03_for;

import java.util.Scanner;

public class For03 {
	public static void main(String[] args) {
		
		// 시작값과 끝값을 입력받아 합계를 구하기
		int start, end;
		int sum=0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("시작값 입력>>>");
		start = sc.nextInt();
		System.out.println("끝값 입력");
		end = sc.nextInt();
		
		for(int i=start; i<=end;i++) {
			sum += i;
		}
		System.out.printf("%d부터 %d 까지의 합: %d",start,end,sum);
		
		sc.close();
		
	}
}
