package java_logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Sort_Comparator {
	public static void main(String[] args) {
		ArrayList<myObject2> list = new ArrayList<myObject2>();

		list.add(new myObject2("A", 2, 2));
		list.add(new myObject2("A", 1, 1));
		list.add(new myObject2("A", 2, 1));
		list.add(new myObject2("A", 1, 2));

		System.out.println("before sorting:" + list);
		Collections.sort(list, new Comparator<myObject2>() {

			@Override
			public int compare(myObject2 o1, myObject2 o2) {
				if (o1.number1 < o2.number1) {
					return -1;
				} else if (o1.number1 == o2.number1 && o1.number2 < o2.number1) {
					return -1;
				} else if (o1.number1 > o2.number1) {
					return 1;
				}

				return 0;
			}

		});

		System.out.println("after sorting:" + list);
	}
}

class myComparator implements Comparator<myObject2>{

	@Override
	public int compare(myObject2 o1, myObject2 o2) {

		if (o1.number1 < o2.number1) {
			return -1;
		} else if (o1.number1 == o2.number1 && o1.number2 < o2.number1) {
			return -1;
		} else if (o1.number1 > o2.number1) {
			return 1;
		}

		return 0;
	}

	
}


class myObject2 {
	String name;
	int number1;
	int number2;

	public myObject2(String name, int number1, int number2) {
		this.name = name;
		this.number1 = number1;
		this.number2 = number2;
	}

	@Override
	public String toString() {
		return "[" + this.name + "," + this.number1 + "," + this.number2 + "]";
	}

}