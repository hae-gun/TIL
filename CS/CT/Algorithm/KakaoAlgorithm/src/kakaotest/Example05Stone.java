package kakaotest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Example05Stone {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] stringStones = br.readLine().split(",");
		int[] stones = new int[stringStones.length];
		
		for(int i=0 ; i<stringStones.length; i++) {
			stones[i] = Integer.valueOf(stringStones[i]);
		}
		int k = Integer.valueOf(br.readLine());
		
		int result = solution(stones,k);
		System.out.println(result);
	}
	
	 public static int solution(int[] stones, int k) {
	        int answer = 0;
	        boolean flag = true;
	        
	        while(flag) {
	        	
	        	int canJump = k;
	        	for(int i=0; i<stones.length; i++) {
	        		if(stones[i]!=0) {
	        			stones[i]--;
	        			canJump = k;
	        		}else {
	        			canJump--;
	        			if(canJump==0) {
	        				flag=false;
	        				break;
	        			}
	        		}
	        	}	
	        	if(flag) {
	        		answer++;
	        	}
	        }
	        
	        
	        
	        return answer;
	    }

}
