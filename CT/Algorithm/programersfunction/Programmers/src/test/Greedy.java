package test;

import java.util.Arrays;
import java.util.HashMap;

public class Greedy {
	public static void main(String[] args) {
		
		int[] set = {3, 1, 6, 2, 7, 30, 1};
		Arrays.sort(set);
		HashMap<Integer,Integer> map = new HashMap<Integer, Integer>(); 
		for(int i = 0; i<set.length; i++) {
			int sum = 0;
			for(int j=i; j<set.length;j++) {
				for(int k=j; k<set.length; k++) {
					sum += set[k];
					map.put(sum, sum);
				}
			}
		}
		System.out.println(map.keySet());
	}
}
