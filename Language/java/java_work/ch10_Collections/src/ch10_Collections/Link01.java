package ch10_Collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Link01 {
	public static void main(String[] args) {
		
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new LinkedList<String>();
		
		long start, end;
		
		start = System.nanoTime();
		for(int i=0; i<10000; i++) {
			list1.add(0,String.valueOf(i));
		}
		list1.remove(0);
		end = System.nanoTime();
		
		System.out.printf("Arraylist:  %d\n",end-start);
		
		start = System.nanoTime();
		for(int i=0; i<10000; i++) {
			list2.add(0,String.valueOf(i));
		}
		list2.remove(0);
		end = System.nanoTime();
		
		System.out.printf("Linkedlist: %d\n",end-start);
		
		
	}
}
