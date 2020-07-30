package api02_String;

import java.io.IOException;

public class String01 {
	public static void main(String[] args) throws IOException {
		String tom = "tom";
		String tom2 = new String("tom");
		
		byte[] bytes = {72,101,108,108,111,32,74,97,118,97};
		String str = new String(bytes);
		System.out.println(str);
		
		String str2 = new String(bytes,6,4);
		System.out.println(str2);
		
		byte[] bytes2 = new byte[100];
		System.out.println("값 입력>>>");
		int readByteNo = System.in.read(bytes2); // 읽은 byte길이를 int로 읽어줌.
		System.out.println(readByteNo);
		
//		String str3 = new String(bytes2,0,readByteNo); // 엔터 입력값 \r\n두개 포함됨
		String str3 = new String(bytes2,0,readByteNo-2); // -2 : \r \n 포함 안됨
		System.out.println(str3);
		
		char[] greet = {'h','e','l','l','o'};
		String hi = new String(greet);
		System.out.println(hi);
	}
}
