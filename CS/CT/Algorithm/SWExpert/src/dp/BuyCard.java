package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BuyCard {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		
		int[] cards = new int[n+1];
		
		String[] packs = br.readLine().split(" ");
		
		for(int i=1; i<=n; i++){
			cards[i] = Integer.valueOf(packs[i-1]);
		}
		int[] dp = new int[n+1];
		
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=i; j++) {
				dp[i] = Math.max(dp[i], dp[i-j] + cards[j]);
			}
		}
		System.out.println(Arrays.toString(dp));
		System.out.println(dp[n]);
		
		
	}
}
