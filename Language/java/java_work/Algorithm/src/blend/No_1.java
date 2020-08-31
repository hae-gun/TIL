package blend;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No_1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int age = Integer.parseInt(br.readLine());
		
		
		int maxHeartbeat = 220-age;
		int heartbeat = Integer.parseInt(br.readLine());
		
		int[] times = new int[6];
		
		times[typeCheck(heartbeat,maxHeartbeat)]++;
		
		System.out.println(maxHeartbeat);
		while(maxHeartbeat>heartbeat) {
			heartbeat = Integer.parseInt(br.readLine());
			times[typeCheck(heartbeat,maxHeartbeat)]++;
			
			
		}
		for(int i: times) {
			System.out.print(i+" ");
		}
		
		
	}
	
	public static int typeCheck(int beat,int max) {
		double percent = (double)beat/(double)max;
		int result = 0;
		if(percent<0.6) {
			result = 5;
		}else if(percent<0.68) {
			result = 4;
		}else if(percent<0.75) {
			result = 3;
		}
		else if(percent<0.8) {
			result = 2;
		}else if(percent<0.90) {
			result = 1;
		}else if(percent<=1) {
			result = 0;
		}
		return result;
	}
	
	

}
