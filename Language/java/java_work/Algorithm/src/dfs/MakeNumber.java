package dfs;

import java.util.LinkedList;
import java.util.Queue;

public class MakeNumber {
	public static void main(String[] args) {
		int[] numbers = { 1, 1, 1, 1, 1 };
		int target = 3;

		int answer = solution(numbers, target);
		System.out.println(answer);
	}

	static int solution(int[] numbers, int target) {
		int answer = 0;
		int index = 0;

		// dfs

		Queue<Integer> queue = new LinkedList<Integer>();
		LinkedList<Integer> list = new LinkedList<Integer>();
		queue.add(numbers[0]);
		queue.add(-numbers[0]);
		for (int i = 1; i < numbers.length; i++) {

			int count = 0;
			// 배열 뽑아서 더하고 빼기
			while (!queue.isEmpty()) {
				list.add(queue.poll());
				System.out.println(++count);
			}
			System.out.println("list: " + i + "-" + list);

			while (!list.isEmpty()) {
				int curNum = list.removeFirst();
				queue.add(curNum + numbers[i]);
				queue.add(curNum - numbers[i]);
			}

			System.out.println("queue: " + i + "-" + queue);

		}
		System.out.println(queue);
		while (!queue.isEmpty()) {
			int checkNum = queue.poll();
			if (checkNum == target) {
				answer++;
			}
		}

		return answer;
	}

}
