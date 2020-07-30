package api02_String;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class String02 {
	public static void main(String[] args) {
		//String -> byte[]  -> String (data 전달 과정)
		String str = "안녕하세요";
		byte[] b1 = str.getBytes();
		System.out.println(Arrays.toString(b1));
		System.out.println("b1.length: "+ b1.length); // 한글은 3byte로 처리되고 있다.
		String str2 = new String(b1);
		System.out.println("byte -> String: " + str2);
		
		byte[] b2,b3;
		try {
			b2 = str.getBytes("euckr");
			System.out.println("b2.length: "+ b2.length); // 한글은 3byte로 처리되고 있다.
			String str3 = new String(b2);
			System.out.println("byte -> String: " + str3);
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}
	
}
