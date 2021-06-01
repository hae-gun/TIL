package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tile01 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		
		long dp[] = new long[N+1];
		dp[1] = 1;
		if(dp.length>2)
			dp[2] = 2;
		
		for(int i=3; i<=N; i++) {
			dp[i] = (dp[i-1] + dp[i-2])%15746;
		}
		
		System.out.println(dp[N]);
	}

}
