package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Fibo1 {
	public static void main(String[] args) throws IOException {
		
		int N = extracted();
		
		BigInteger[] fibo = new BigInteger[N+1];
		
			fibo[0] = BigInteger.ZERO;
		if(N!=0) {
			fibo[1] = BigInteger.ONE;
		}
		
		for(int i=2; i<=N; i++) {
			fibo[i] = fibo[i-1].add(fibo[i-2]);
		}
		
		System.out.println(fibo[N]);
		
		
		B
	}

	private static int extracted() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.valueOf(br.readLine());
		return num;
	}
}
