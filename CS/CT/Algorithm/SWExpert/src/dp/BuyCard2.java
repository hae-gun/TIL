package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BuyCard2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		
		String[] cardsTmp = br.readLine().split(" ");
		
		int dpPrice[] = new int[n+1];
		Arrays.fill(dpPrice, 987654321);
		dpPrice[0] = 0;
		
		// 이번 Dp는 최솟값 구하기.
		int[] cards = new int[n+1];
		for(int idx=1; idx<=cardsTmp.length; idx++) {
			cards[idx] = Integer.valueOf(cardsTmp[idx-1]);
		}
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=i; j++) {
				dpPrice[i] = Math.min(dpPrice[i], dpPrice[i-j] + cards[j]);
			}
		}
		System.out.println(dpPrice[n]);
		
	}

}
