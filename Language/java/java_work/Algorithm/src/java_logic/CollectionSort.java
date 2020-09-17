package java_logic;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionSort {
	public static void main(String[] args) {
		ArrayList<myObject> list = new ArrayList<myObject>();
		
		list.add(new myObject("A", 2, 2));
		list.add(new myObject("A", 1, 1));
		list.add(new myObject("A", 2, 1));
		list.add(new myObject("A", 1, 2));
		
		System.out.println("before sorting:"+list);
		Collections.sort(list);
		
		System.out.println("after sorting:"+list);
		
	}
}

class myObject implements Comparable<myObject>{
	String name;
	int number1;
	int number2;

	public myObject(String name, int number1, int number2) {
		this.name = name;
		this.number1 = number1;
		this.number2 = number2;
	}

	@Override
	public int compareTo(myObject o) {
		
		if(this.number1 < o.number1) {
			return -1;
		}else if(this.number1 == o.number1 && this.number2<o.number1) {
			return -1;
		}else if(this.number1 > o.number1) {
			return 1;
		}
		
		return 0;
	}

	@Override
	public String toString() {
		return "["+this.name+","+this.number1+","+this.number2+"]";
	}
	
	
	
	
}