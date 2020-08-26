package heap;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class HeapSort {
	public static void main(String[] args) {
		
		
		int[] scoville =  {1,3,5,6,7};
		int K=10;
		System.out.println(solution(scoville, K));
	}
	static int count=0;
	public static int solution(int[] scoville, int K) {
		int answer = 0;
		
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for(int i:scoville) {
			queue.add(i);
		}
		
		while(true) {
			answer++;
			if(queue.isEmpty()) {
				answer=-1;
				break;
			}
			else if(queue.peek()>=K) {
				break;
				
			}else if(queue.size()>=2){
				int min = queue.poll();
				int second = queue.poll();
				int mix = min+(second*2);
				queue.add(mix);
				
			}else {
				answer = -1;
				break;
			}
		}
		return answer;
	}
	
	public static int[] dfs(int[] scoville, int K) {
		
		if(scoville[0]>=K) {
			return scoville;
		}else {
			count++;
			
			LinkedList<Integer> list = new LinkedList<>();
			var list123 = new LinkedList<>();
			Arrays.sort(scoville);
			
			
			for(int i:scoville) {
				list.addLast(i);
				
			}
			
			
			if(list.isEmpty()) {
				count = -1;
			}
			int first = list.removeFirst();
			int second = list.removeFirst();
			
			list.addFirst(first + (second*2));
			
			int[] next = new int[list.size()];
			int length = list.size();
			for(int i=0; i<length; i++) {
				next[i] = list.get(i);
			}
//			System.out.println(list);
			
			scoville = dfs(next,K);
			
			
			
			return scoville;
		}
		
	}

}
