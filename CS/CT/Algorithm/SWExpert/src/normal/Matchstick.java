package normal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Matchstick {
	
	static String[] dp = new String[101];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = Integer.valueOf(br.readLine());
		List<Integer> list = new ArrayList<Integer>();
		int max = -987654321;

		for(int i=0; i<count; i++) {
			int n = Integer.parseInt(br.readLine());
			list.add(n);
			max = Math.max(max,n);
		}
		
		makeDp(max);
		
		for(int i : list) {
			System.out.println(minMatchCount(i) + " "+ maxMatchCount(i));
		}
		
	}

	private static String maxMatchCount(int matchCount) {
		// TODO Auto-generated method 
		StringBuilder sb = new StringBuilder();
		int length = matchCount/2;
		if(matchCount %2 ==0) {
			for(int i=0; i<length; i++) {
				sb.append(1);
			}
		}else {
			sb.append(7);
			if(matchCount>3) {
				for(int i=0; i<length; i++) {
					sb.append(1);
				}
			}
		}
		
		
		return sb.toString();
	}

	private static String minMatchCount(int matchCount) {
		return String.valueOf(dp[matchCount]);
	}
	
	private static void makeDp(int max) {
		dp[2] = "1";
		dp[3] = "7";
		dp[4] = "4";
		dp[5] = "5";
		dp[6] = "6";
		dp[7] = "8";
		for(int i=8; i<=max; i++) {
			dp[i] = String.valueOf(Long.MAX_VALUE);
		}
		
		
		
		for(int i=8; i<=max; i++) {
			for(int j=2; j<i-1; j++) {
				String head = dp[j];
				String tail = (i-j) % 6 == 0  ? getZero((i-j)/6) : dp[i-j];
				
				
				
//				long k = i-j % 6 ==0 ? Math.min(Long.parseLong(dp[i]), Long.parseLong(head+"0")):
				long k = Math.min(Long.parseLong(dp[i]), Long.parseLong(head+tail));
				
				
				dp[i] = String.valueOf(k);
			}
		}
		
		
	}

	private static String getZero(int length) {
		String result = "";
		for(int i=0; i < length; i ++) {
			result += "0";
		}
		return result;
	}

}
