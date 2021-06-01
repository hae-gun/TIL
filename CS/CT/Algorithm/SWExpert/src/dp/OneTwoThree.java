package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OneTwoThree {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = Integer.valueOf(br.readLine());
		
		int[] nums = new int[count];
		
		for(int i=0; i<count; i++) {
			nums[i]= Integer.valueOf(br.readLine());
		}
		
		int[] dp = new int[11];
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;

		for(int i=4; i<dp.length; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3]; 
		}
		
		for(int num : nums) {
			System.out.println(dp[num]);
		}
		
	}

}
