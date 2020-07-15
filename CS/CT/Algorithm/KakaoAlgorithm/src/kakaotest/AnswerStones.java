package kakaotest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AnswerStones {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] stringStones = br.readLine().split(",");
		int[] stones = new int[stringStones.length];

		for (int i = 0; i < stringStones.length; i++) {
			stones[i] = Integer.valueOf(stringStones[i]);
		}
		int k = Integer.valueOf(br.readLine());

		int result = solution(stones, k);
		System.out.println(result);
	}

	public static int solution(int[] stones, int k) {
        int answer = 0;
        int N = stones.length;
        int max = 0;
        int min = 200000000;
        for(int i=0; i<N; i++) {
        	max = Math.max(max, stones[i]);
        	min = Math.min(min, stones[i]);
        }
        int mid;
        while(max>=min) {
        	mid = (max+min)/2;
        	if(isPossible(mid, N, k, stones)) {
        		answer = Math.max(answer, mid);
        		min = mid+1;
        	}else {
        		max = mid-1;
        	}
        }
        
        return answer;
        }

	public static boolean isPossible(int mid, int N, int k, int[] stones) {
		for (int i = 0; i < N; i++) {
			stones[i] -= mid;
		}
		int check = 0;
		for (int i = 0; i < N; i++) {
			if (stones[i] < 0) {
				check++;
				if (check >= k) {
					return false;
				}
			}

		}

		return true;
	}
}
