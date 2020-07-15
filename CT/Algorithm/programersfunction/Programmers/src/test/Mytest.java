package test;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Mytest {

	public static void main(String[] args) throws IOException {
		
		int[] set = {3,1,6,2,7,30,1};
		Solution s = new Solution();
		System.out.println(s.solution(set));
		
	}

}

class Solution {
	public int solution(int[] weight) {
		int answer = 0;
		Arrays.sort(weight);
		
		LinkedList<Integer> ss = new LinkedList<Integer>();
//		ArrayList<LinkedList<Integer>> wants = new ArrayList<>();
		dfs(weight, 0, new LinkedList<Integer>(), weight.length,ss);
		
		ss.sort(null);
		
				
		
		
		HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
		
		while(!ss.isEmpty()) {
			int first = ss.removeFirst();
			map.put(first, first);
			
		}
		
		int i=0;
		for(Integer getNum : map.keySet()) {
			
			if(!map.containsKey(i++)) {
				answer = --i;
				break;
			}
			
			
		}
		return answer;
	}

	public void dfs(int[] sets,int index, LinkedList<Integer> s,int length,LinkedList<Integer> resultSet) {
		
		
		if(index==length) {
			Integer sum=0;
			for(Integer a : s) {
				sum += a;
			}
			
			resultSet.push(sum);
			
			return;
		}
		s.push(sets[index]);
		dfs(sets,index+1,s,sets.length,resultSet);
		s.pop();
		dfs(sets,index+1,s,sets.length,resultSet);
		
		
	}
}
