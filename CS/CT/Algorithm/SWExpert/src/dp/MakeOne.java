package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakeOne {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int  n = br.readLine()
		
		int[] result = new int[n+1];
		result[0] = result[1] = 0;
		
		for(int i=2; i<=n; i++) {
			result[i] = result[i-1]+1;
			if(i%2==0) {
				result[i] = Math.min(result[i], result[i/2]+1);
			}else if(i%3==0) {
				result[i] = Math.min(result[i], result[i/3]+1);
			}
						
		}
		
		System.out.println(result[n]);
		
		
	}

}
