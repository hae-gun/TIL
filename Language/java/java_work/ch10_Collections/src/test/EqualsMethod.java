package test;

public class EqualsMethod {
	public static void main(String[] args) {
		
		byte b1 = 1;
		byte b2 = 1;
		System.out.println(b1==b2);

		short s1 = 128;
		short s2 = 128;
		System.out.println(s1==s2);
		
		int i1 = 327678;
		int i2 = 327678;
		System.out.println(i1==i2);
		
		long l1 = 2147483648L;
		long l2 = 2147483648L;
		System.out.println(l1==l2);
		
		float f1 = 1234.1234f;
		float f2 = 1234.1234f;
		System.out.println(f1==f2);
		
		double d1 =  0x2.fffffeP+127;
		double d2 =  0x2.fffffeP+127;
		System.out.println(d1==d2);
		
		char c1 = 'a';
		char c2 = 'a';
		System.out.println(c1==c2);
		
		boolean bo1 = false;
		boolean bo2 = false;
		System.out.println(bo1==bo2);
		
		
	}
}
