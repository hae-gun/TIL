package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;




public class MyQueue {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count = Integer.valueOf(br.readLine());
		
		LinkedList<Integer> queue = new LinkedList<>();
		
		for(int i=0; i<count; i++) {
			String[] msg = br.readLine().split(" ");
			doAction(queue,msg);
		}
		
	}
	//push X: 정수 X를 큐에 넣는 연산이다.
	//pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	//size: 큐에 들어있는 정수의 개수를 출력한다.
	//empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
	//front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	//back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	private static void doAction(LinkedList<Integer> queue, String[] msg) {
		String mode = msg[0];
		int num=0;
		if(msg.length>1) {
			num = Integer.valueOf(msg[1]);
		}
		
		switch (mode) {
		case "push":
			queue.add(num);
			break;
		case "pop":
			if(queue.isEmpty()) System.out.println(-1);
			else System.out.println(queue.poll());
			break;
		case "size":
			System.out.println(queue.size());
			break;
		case "empty":
			if(queue.isEmpty()) System.out.println(1);
			else System.out.println(0);
			break;
		case "front":
			if(queue.isEmpty()) System.out.println(-1);
			else System.out.println(queue.get(0));
			break;
		case "back":
			if(queue.isEmpty()) System.out.println(-1);
			else System.out.println(queue.get(queue.size()-1));
			break;

		}
		
	}
}
