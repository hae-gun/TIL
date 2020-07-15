package kakaotest;

import java.util.ArrayList;
import java.util.LinkedList;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> test = new LinkedList<Integer>();
		
		test.addLast(1);
		test.addLast(1);
		test.getLast();
		for(Integer temp : test) {
			System.out.println(temp);
		}
	}

}
