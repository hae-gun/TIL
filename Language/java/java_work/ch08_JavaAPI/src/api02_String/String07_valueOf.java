package api02_String;

public class String07_valueOf {
	public static void main(String[] args) {
		
		int a = 10;
		double b = 10.5;
		double c = a + b;
		
		String str1 = String.valueOf(a);
		String str2 = String.valueOf(b);
		String str3 = String.valueOf(c);
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);

		System.out.println("--------------");
		System.out.println(str1 + str2);
		System.out.println(Integer.parseInt(str1)+Double.parseDouble(str2));
		
	}
}
