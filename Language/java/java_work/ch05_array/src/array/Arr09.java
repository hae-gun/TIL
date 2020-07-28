package array;

import java.util.Arrays;

public class Arr09 {
	public static void main(String[] args) {
		int[] numArr = new int[10];
		for(int i=0; i<numArr.length; i++) {
			numArr[i] = i+1;
		}
		System.out.println(Arrays.toString(numArr));
		System.out.println("========================================");
		//random()으로 값을 뽑을 경우 중복 수가 발생할 수 있다
//		for(int i=0; i<numArr.length; i++) {
//			numArr[i] = (int)(Math.random()*10)+1;
//		}
//		System.out.println(Arrays.toString(numArr));
		System.out.println("========================================");
		for(int i=0; i <100; i++) {
			int num = (int)(Math.random()*10);
			int tmp = numArr[0];
			numArr[0] = numArr[num];
			numArr[num] = tmp;
		}
		System.out.println(Arrays.toString(numArr));
	}
}
