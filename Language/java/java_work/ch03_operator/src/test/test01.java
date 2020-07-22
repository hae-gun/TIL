package test;

import java.util.Arrays;

public class test01 {

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5};
		int[] arr2 = {1,2,3,4,5};
		int sumVal = Arrays.stream(arr).sum();
		int max = Arrays.stream(arr).max().getAsInt();
		
		System.out.println("sumVal: "+sumVal);
		System.out.println("max: "+max);
		
		System.out.println(arr.equals(arr2));
		arr2 = arr;
		System.out.println(arr.equals(arr2));
		
		System.out.println(Arrays.equals(arr, arr2));
	}	

}
