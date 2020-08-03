package ch10_Collections;

import java.util.Arrays;
import java.util.List;

public class Al03 {
	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("google","naver","daum");
		System.out.println(list);
		
		List<Integer> list2 = Arrays.asList(1,2,3,4,5);
		for(int i : list2) {
			System.out.println(i*3);
		}
		
		
	}
}	
