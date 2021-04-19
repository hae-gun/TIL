package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibo2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Long.parseLong(br.readLine());
		// 피보나치 수열을 1,000,000 으로 나눈 나머지의 피보나치 수열의 피사노주기는 1,500,000 이다.
		
		long fibo[] = new long[1500001];
		
		fibo[1] = 1;
		fibo[2] = 1;
		
		
		for(int i=3; i<fibo.length; i++) {
			fibo[i] = (fibo[i-1] + fibo[i-2]) % 1000000;
		}
		
		N %= 1500000;
		int n = Integer.valueOf(String.valueOf(N));
		System.out.println(fibo[n]);
		
		
	}
}
