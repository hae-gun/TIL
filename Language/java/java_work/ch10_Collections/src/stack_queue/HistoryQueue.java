package stack_queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HistoryQueue {

	static Queue<String> q = new LinkedList<>();
	static final int MAX_SIZE = 5;

	public static void main(String[] args) {
		System.out.println("도움말: help");
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("$>> ");

			String input = scan.nextLine().trim();
			if ("".equals(input)) {
				continue;
			}
			if (input.equalsIgnoreCase("exit")) {
				System.out.println("System EXIT");
				System.exit(0);
			} else if (input.equalsIgnoreCase("help")) {
				System.out.println("help - 도움말");
				System.out.println("exit - 종료");
				System.out.println("history - 최근 입력 명령어 5개 출력");
				save(input);
			} else if (input.equalsIgnoreCase("history")) {
				int i = 0;
				LinkedList<String> tmp = (LinkedList<String>) q;
				Iterator<String> iter = tmp.iterator();
				while (iter.hasNext()) {
					System.out.println(++i + " : " + iter.next());
				}
				save(input);
			} else {
				save(input);
			}

		}
	}

	private static void save(String input) {
		if (!"".equals(input)) {
			q.offer(input);
		}
		if (q.size() > MAX_SIZE) {
			// q.remove(); 은 큐가 비어있을때 Exception 을 발생시킨다.
			q.poll(); // 은 큐가 비어있을때 Exception 을 발생시킨다.
		}

	}

}
