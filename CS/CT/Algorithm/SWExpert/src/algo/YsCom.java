package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class YsCom {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NK = br.readLine().split(" ");
		int n = Integer.valueOf(NK[0]);
		int k = Integer.valueOf(NK[1]);
		
		boolean[] visit = new boolean[n+1];
		visit[0] = true;
		
		
		Queue<Integer> numbers = new LinkedList<>();
		for(int i=1; i<n+1; i++) {
			numbers.add(i);
		}
		
		
		List<Integer> result = new ArrayList<>();
		
		while(!numbers.isEmpty()) {
			for (int i=0; i<k-1; i++) {
				numbers.add(numbers.poll());
			}
			result.add(numbers.poll());
		}
		System.out.println(result.toString().replace("[", "<").replace("]", ">"));
		
		
	}
}
