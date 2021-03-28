package normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Retirement {
	
	
	static int[] ti;
	static int[] pi;
 	
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int N = Integer.valueOf(br.readLine());
		
		ti = new int[N];
		pi = new int[N];
		dp = new int[16];
		for(int i=0; i<N; i++){
			String[] line = br.readLine().split(" ");
			ti[i] = Integer.valueOf(line[0]);
			pi[i] = Integer.valueOf(line[1]);
			
		}
//		for(int i=0; i<N ; i++) {
//			if(i+ ti[i] <= N + 1) {
//				dp[i+ti[i]] = Math.max(dp[i+ti[i]], dp[i] + pi[i]);
//			}else {
//				dp[i+1] = Math.max(dp[i+1],dp[i]);
//			}	
//			
//			
//		}
		for(int i=N-1; i>=0; i--) {
			if(i + ti[i] > N) dp[i] = dp[i+1];
			else dp[i] = Math.max(dp[i+1], dp[i+ti[i]] + pi[i]);
			
			
		}
		
		System.out.println(Arrays.stream(dp).max().getAsInt());
		
		
	}
}
