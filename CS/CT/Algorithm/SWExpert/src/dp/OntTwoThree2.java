package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OntTwoThree2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		
		
		int[] nums = new int[n];
		
		long[] dp = new long[1000001];
		int max = -987654321;
		for(int i=0; i<n; i++) {
			nums[i] = Integer.valueOf(br.readLine());
			max = Math.max(max, nums[i]);
		}
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		
		for(int i=4; i<=max; i++) {
			dp[i] = dp[i-1]  + dp[i-2] + dp[i-3];
			dp[i] %=  1000000009;
		}
		
		for(int num : nums) {
			System.out.println(dp[num]);
		}
	}

}
