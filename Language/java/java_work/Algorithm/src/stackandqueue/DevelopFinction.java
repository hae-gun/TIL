package stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

public class DevelopFinction {
	public static void main(String[] args) {

		int[] progresses = { 93, 30, 40, 55 };
		int[] speeds = { 1, 30, 30, 5 };

		int answer[] = solution(progresses, speeds);
		for(int i:answer) {
			System.out.println(i);
		}
	}

	public static int[] solution(int[] progresses, int[] speeds) {
		int[] answer = {};
		int length = progresses.length;
		int[] days = new int[length];

		days = calcProgressDay(progresses, speeds, days);
		// 연산 날짜 계산하기.

		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i : days) {
			queue.add(i);
		}
//		System.out.println(queue);

		LinkedList<Integer> list = makeAnswerList(queue);
//		System.out.println(list);
		answer = listToArray(list);
		return answer;
	}

	private static LinkedList<Integer> makeAnswerList(Queue<Integer> queue) {
		LinkedList<Integer> list = new LinkedList<Integer>();

		int count = 1;
		int max = queue.poll();

		while (!queue.isEmpty()) {
			int cur = queue.poll();

			if (max > cur) {
				count++;
			} else {
				list.add(count);
				count = 1;
			}
			if (queue.isEmpty()) {
				list.add(count);
			}

			max = max > cur ? max : cur;
		}
		return list;
	}

	private static int[] calcProgressDay(int[] progresses, int[] speeds, int[] days) {

		for (int i = 0; i < progresses.length; i++) {
			int res = 100 - progresses[i];
			int num = speeds[i];
			days[i] = res % num == 0 ? res / num : res / num + 1;
		}
		return days;
	}

	private static int[] listToArray(LinkedList<Integer> list) {

		int length = list.size();
		int[] result = new int[length];

		for (int i = 0; i < length; i++) {
			result[i] = list.removeFirst();
		}
		return result;
	}

}
