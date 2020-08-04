package test;

import java.util.ArrayList;

public class StringObject {
	public static void main(String[] args) {
		String s1 = "abcd";
		String s2 = "abcd";
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
//		
//		System.out.println(s1 == s2);
//
//		String so1 = new String("abcd");
//		String so2 = new String("abcd");
//
//		System.out.println(so1 == so2);
//		
//		ArrayList<String> s = new ArrayList<>();
	}
}

//class myObject{
//	
//	int number;
//	String name;
//	
//	public myObject(int number, String name) {
//		this.number = number;
//		this.name = name;
//	}
//
//	@Override
//	public String toString() {
//		return "myObject [number=" + number + ", name=" + name + "]";
//	}
//	
//	
//}
