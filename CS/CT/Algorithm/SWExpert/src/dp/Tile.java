package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

public class Tile {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		
		
		BigDecimal[] dp = new BigDecimal[1001];
		
		dp[1] = BigDecimal.ONE;
		System.out.println(dp[1]);
		dp[2] = dp[1].add(dp[1]);
		System.out.println(dp[2]);
		for(int i=3; i<=n; i++) {
			dp[i] = dp[i-2].add(dp[i-1]);
			dp[i] = dp[i].remainder(BigDecimal.valueOf(10007)); 
		}
		
//		long result = dp[n]%10007;
//		System.out.println(result);
		System.out.println(dp[n]);
		
	}
}
