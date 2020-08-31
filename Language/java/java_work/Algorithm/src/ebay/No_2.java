package ebay;

import java.util.LinkedList;

public class No_2 {

	public static void main(String[] args) {
//		8	[1,4,6]	2
		int num = 8;
		int[] cards = { 1, 4, 6 };

		System.out.println(solution(num, cards));

	}

	static int ans = 0;

	public static int solution(int num, int[] cards) {
		int answer = 987654321;
		int count = 0;

		LinkedList<Integer> stack = new LinkedList<Integer>();

		for (int i = 0; i < cards.length; i++) {
			int temp = num;

			answer = Math.min(answer, dfs(temp - cards[i], cards, answer));

		}

		return answer;
	}

	private static int dfs(int num, int[] cards, int answer) {
		if (num == 0) {
//			System.out.println(answer);
			return answer;
		} else if (num < 0) {
			return 987654321;
		} else {
			for (int i = 0; i < cards.length; i++) {
				dfs(num - cards[i], cards, answer++);
			}

		}
		return answer;
	}

}
