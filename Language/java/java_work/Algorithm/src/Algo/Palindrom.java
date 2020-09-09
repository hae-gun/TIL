package Algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Palindrom {

	static ArrayList<String> set = new ArrayList<String>();

	public static void main(String[] args) throws IOException {
		Long start = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
//		palindrom(s);
//		System.out.println(set.size());
		
		LinkedList<String> stack = new LinkedList<String>();
		stack.addLast(s);
		while(!stack.isEmpty()) {
			s = stack.pop();
			System.out.println(s);
			
			for (int i = s.length() ; i >= 0; i--) {

				StringBuffer sb = new StringBuffer(s);
				String cutS = s.substring(0,i);
				
				if (cutS.length() > 1) {
					if (cutS.equals(reverseString(cutS))) {
						sb.delete(0, i);
//						System.out.println(sb);
//						System.out.println("sb size: " + sb.length());
						stack.add(sb.toString());
						set.add(cutS);
						break;
					}
				}else if(cutS.length()==1){
					sb.delete(0, i);
					stack.add(sb.toString());
					set.add(cutS);
					break;
				}
			}
			
			
			
			
		}
		System.out.println(set);
		Long end = System.currentTimeMillis();
		System.out.println(end-start);
		
		
	}
	
	static String reverseString(String s) {
		int size = s.length();

		char[] set = s.toCharArray();
		char[] result = new char[size];
		for (int i = 0; i < size; i++) {
			result[size - 1 - i] = set[i];
		}
		String resultS = new String(result);
		return resultS;
	}

	static void palindrom(String s) {

		char[] charSet = s.toCharArray();

		for (int i = s.length() ; i >= 0; i--) {

//			if (s.length() <= 1) {
//				set.add(s);
//				return;
//			}

			char[] sets = new char[i];
			StringBuffer sb = new StringBuffer(s);
			for (int j = 0; j < i; j++) {
				sets[j] = s.charAt(j);
			}
			String cutS = new String(sets);
//			System.out.println(cutS);
//			System.out.println("i: " + i);
			if (cutS.length() > 1) {
				if (cutS.equals(reverseString(cutS))) {
					sb.delete(0, i);
//					System.out.println(sb);
//					System.out.println("sb size: " + sb.length());
					palindrom(sb.toString());
					set.add(cutS);
					return;
				}
			}else if(cutS.length()==1){
				sb.delete(0, i);
				palindrom(sb.toString());
				set.add(cutS);
				return;
			}
		}

	}

	

}
