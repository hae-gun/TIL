package coupang;

import java.util.ArrayList;
import java.util.HashMap;

public class No3 {
	public static void main(String[] args) {
		int k = 3;
		int[] score = { 24, 22, 20, 10, 5, 3, 2, 1 };
//		int k = 2;
//		int[] score = { 1300000000,700000000,668239490,618239490,568239490,568239486,518239486,157658638,157658634,100000000,100};

		int result = solution(k, score);
		System.out.println(result);
	}

	private static int solution(int k, int[] score) {
		int[] differ = new int[score.length];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		boolean[] remain = new boolean[score.length];
		
		for (int i = 1; i < score.length; i++) {
			differ[i] = Math.abs(score[i] - score[i - 1]);
			if(map.containsKey(differ[i])) {
				map.put(differ[i], map.get(differ[i])+1);
			}else {
				map.put(differ[i], 1);
			}
		}
		
		ArrayList<Integer> delete = new ArrayList<>();
		
		for(int i:map.keySet()) {
			if(map.get(i)>=k) {
				delete.add(i);
			}
		}
		for(int i=1; i<score.length; i++) {
			if(delete.contains(differ[i])) {
				remain[i-1] = true;
				remain[i] = true;
			}
		}
		
		System.out.println(map);
		System.out.println("delete>>"+delete);
		int result = 0;
		for(boolean r:remain) {
			if(!r) {
				result++;
			}
		}
		return result;
	}

}
