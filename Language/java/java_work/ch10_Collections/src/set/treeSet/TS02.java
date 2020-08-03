package set.treeSet;

import java.util.Arrays;
import java.util.TreeSet;

public class TS02 {
	public static void main(String[] args) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		
		int[] score = {82,67,89,91,24,58,73,96,100,82};
		System.out.println(Arrays.toString(score));
		Arrays.sort(score);
		System.out.println(Arrays.toString(score));
		
		for(int i : score) {
			set.add(i);
		}
		
		System.out.println(set);
		
		
		// 숫자미만까지 출력
		System.out.println(set.headSet(73));
		// true주면 이하 출력
		System.out.println(set.headSet(73,true));
		
		// 숫자 이상 출력.
		System.out.println(set.tailSet(91));
		// false 넣으면 포함안함
		System.out.println(set.tailSet(91,false));
		
		
	}
}
