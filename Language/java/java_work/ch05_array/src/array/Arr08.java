package array;

import java.util.Arrays;

public class Arr08 {
	public static void main(String[] args) {
		int[] num = new int[5];



		
		System.out.println(Arrays.toString(num));
		System.out.println("num.length: " + num.length);
		
		int[] tmp = new int[num.length*2];
		for(int i=0; i<num.length; i++) {
			tmp[i]=num[i];
		}
		
		for(int i : tmp) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println(num + " / " + tmp);
		
		num = tmp;
		for(int i : num) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println(num + " / " + tmp);
	}
}
