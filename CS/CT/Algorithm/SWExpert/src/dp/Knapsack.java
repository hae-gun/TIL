package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Knapsack {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> nk = Arrays.asList(br.readLine().split(" ")).stream().map(Integer::parseInt).collect(Collectors.toList());
								
		int n = nk.get(0);
		int k = nk.get(1);
		int dp[][] = new int[n+1][k+1];
		
		
		// dp[i][j] = 배낭에 넣은 물품의 무게 합이 j일 때 얻을 수 있는 최대 가치.
		// 각 물품의 번호 i에 따라서 최대 가치 테이블 dp[i][j]를 갱하여 문제를 해결 할 수 있다.
		
		for(int i=0; i<=n; i++) {
			List<Integer> wv = Arrays.asList(br.readLine().split(" ")).stream().map(Integer::parseInt).collect(Collectors.toList());
			int weight = wv.get(0), value = wv.get(1);
			
			for(int j=1; j<=k; j++) {
				if(j<weight) {
					dp[i][j] = dp[i-1][j];
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight]+value);
				}
				
			}
		}
		
		
	}

}
