package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class StairNum2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		
		long dps[][]= new long[1001][11];
		
//		dp[1][0] = 0;
//		dp[1][10] = 0;
		
		for(int i=0; i<dps[0].length-1; i++) {
			dps[0][i] = 1;
			dps[1][i] = 1;
		}
		
		for(int i=2; i<=n; i++) {
			dps[i][0] = 1;
			for(int j=1; j<10; j++) {
					dps[i][j] = (dps[i][j-1] + dps[i-1][j])% 10007;
			}
		}
		long result = Arrays.stream(dps[n]).sum();
//		for(long[] dp:dps)
//			System.out.println(Arrays.toString(dp));
		System.out.println(result);
	}
}
