package lib;

import java.math.BigInteger;

public class Test {
	public static void main(String[] args) {
		
		String[] test = new String[4];
		char[] ch = new char[4];
		float[] fl = new float[4];
		int[] it = new int[4];
		boolean[] bl = new boolean[4];
		byte[] by = new byte[4];
		for(String t : test) {
			System.out.print(t + " ");
		}
		System.out.println();
		for(char c : ch) {
			System.out.print(c);
		}
		System.out.println();
		for(float f : fl) {
			System.out.print(f + " ");
		}
		System.out.println();
		for(int i : it) {
			System.out.print(i + " ");
		}
		System.out.println();
		for(boolean b : bl) {
			System.out.print(b + " ");
		}
		System.out.println();
		for(byte b : by) {
			System.out.print(b + " ");
		}
		
		System.out.println(ch[0] == '\0');
		
	}
}
