package coupang;

import java.util.HashSet;
import java.util.Set;

public class No1 {
	public static void main(String[] args) {
		
		int[] kSet = new int[11];
		int N = 10;
//		System.out.println("makeToN >>> "+makeToN(10,6));
//		System.out.println("powPositions >>> "+powPositions(makeToN(10,6)));
	
		for(int i=2;i<10;i++) {
			kSet[i] = powPositions(makeToN(N,i));
		}
		int max = -1;
		for(int i=2; i<kSet.length; i++) {
			max = Math.max(max, kSet[i]);
		}
		System.out.println(max);
		Set<Object> s = new HashSet<>();
	}
	
	static String makeToN(int Number, int k) {
		int temp = Number;
		String result = "";
		while(true) {
			if(temp==1||temp==0) {
				break;
			}
//			System.out.println(temp);
			result += temp%k;
			temp /= k;
			
		}
		result+=temp;
		StringBuilder sb = new StringBuilder(result);
		result = sb.reverse().toString();
		return result;
	}
	
	static int powPositions(String number) {
		int result=1;
		
		for(char a:number.toCharArray()) {
			int num = a-'0';
			if(num!=0) {
				result *= num;
			}
		}
		
		return result;
	}
	
}
