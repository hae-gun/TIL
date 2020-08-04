package stream;

import java.util.Arrays;

public class IntArrayTest {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		
		int sumVal = Arrays.stream(arr).sum();
		System.out.println(sumVal);
		
		int count = (int) Arrays.stream(arr).count();
		System.out.println(count);
		
//		int stream = (int) Arrays.stream(arr).;
//		
		
		// reduce : 0 : Integer Identity
		System.out.println(Arrays.stream(arr).reduce(0, (a,b)->a+b));
		
		
		
	}
}
