
public class Op06 {
	public static void main(String[] args) {
		//비트 연산자
		// &, |, ^, !
		
		int n1 = 10;
		int n2 = 5;
		int result = n1 & n2;
		System.out.println(result);
		
//		10 : 0000 1010
//		 5 : 0000 0101
//	    ---------------
//	   &연산: 0000 0000
		
		result = n1 | n2;
		System.out.println(result);
		
//		10 : 0000 1010
//		 5 : 0000 0101
//	    ---------------
//	   |연산: 0000 1111
		
		result = n1 ^ n2;
		System.out.println(result);
		
//		10 : 0000 1010
//		 5 : 0000 0101
//	    ---------------
//	   ^연산: 0000 1111
		
	}
}
