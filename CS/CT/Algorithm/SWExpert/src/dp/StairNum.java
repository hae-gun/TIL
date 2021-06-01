package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class StairNum {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		
		long dps[][]= new long[101][11];
		
//		dp[1][0] = 0;
//		dp[1][10] = 0;
		
		for(int i=1; i<dps[0].length-1; i++) {
			dps[1][i] = 1;
		}
		
		for(int i=2; i<dps.length-1; i++) {
			dps[i][0] = dps[i-1][1]; // 2자리 수부터 0으로 끝나는 수가 생김. 해당 수는 
			for(int j=1; j<10; j++) {
					dps[i][j] = (dps[i-1][j-1] + dps[i-1][j+1])% 1000000000;
			}
		}
		int sum = 0;
		
		for(long dp:dps[n]) {
			sum += dp;
			sum %= 1000000000;
		}
		System.out.println(sum );
	}
}
