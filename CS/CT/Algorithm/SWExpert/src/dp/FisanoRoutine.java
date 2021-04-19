package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class FisanoRoutine {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		int count = extractedNumber();
		
		int[] fibo = new int[10000000];
		
		fibo[1] = 1;
		fibo[2] = 1;
		
		int result = -1;
		Map<Integer,Integer> map = new HashMap<>(); 
		
		
		while(count--!=0) {
			String[] nums = br.readLine().split(" ");
			int N = Integer.valueOf(nums[1]);
			
			for(int i=3; i<fibo.length; i++) {
				fibo[i] = (fibo[i-1] + fibo[i-2]) % N;
				if(fibo[i-1] == 1 && fibo[i]==0) {
					result = i;
					break;
				}
			}
			
			map.put(Integer.valueOf(nums[0]), result);
			
		}
		
		
		
		for(int i : map.keySet()) {
			System.out.println(i + " " + map.get(i));
		}
		
		
		
		
	}
	
	private static int extractedNumber() throws IOException {
		int num = Integer.valueOf(br.readLine());
		return num;
	}
}
