package test;

import java.util.ArrayList;

public class TestNo03 {

	public static void main(String[] args) {
		Solution3 sol = new Solution3();
		String road = "111011110011111011111100011111";
		System.out.println(sol.solution(road, 0));
	}

}

class Solution3 {
	public int solution(String road, int n) {
		int answer = -1;

		// 1. 0 을 n번 체우는 반복문.
		char[] set = road.toCharArray();
		int countZero = 0;
		for (char c : set) {
			if (c == '0') {
				countZero++;
			}
		}

		ArrayList<Object> indexZero = new ArrayList();

		for (int i = 0; i < set.length; i++) {
			if (set[i] == '0') {
				indexZero.add(i);
			}
		}

		// 2. 0을 n개 1로 바꾼후 연속되는 1의 최대 길이 구하기.

		String[] One = road.split("0");
		int[] oneLength = new int[One.length];
		for(int i =0 ; i < One.length ; i++) {
			oneLength[i] = One[i].length();
		}
		
		for (int i = 0; i < oneLength.length; i++) {
			answer = Math.max(answer,oneLength[i]);
		}
		
		return answer;
	}
}
