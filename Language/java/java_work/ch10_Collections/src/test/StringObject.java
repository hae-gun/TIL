package test;

public class StringObject {
	public static void main(String[] args) {
		String s1 = "abcd";
		String s2 = "abcd";
		
		System.out.println(s1==s2);
		
		String so1 = new String("abcd");
		String so2 = new String("abcd");
		
		System.out.println(so1 == so2);
	}
}
