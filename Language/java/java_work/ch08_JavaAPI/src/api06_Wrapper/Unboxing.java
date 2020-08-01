package api06_Wrapper;

import java.util.ArrayList;
import java.util.List;

public class Unboxing {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		int num1 = 300; int num2 = 300;
		System.out.println(num1==num2);
		
		
		Integer it1 = 100;
		Integer it2 = 100;
		// -128~127(byte범위) 안에서는 자동 Unboxing 된다.
		System.out.println(it1==it2);
		
		// byte 범위를 넘어가면 자동 언박되지 않는다.
		Integer num3 = 300;
		Integer num4 = 300;
		System.out.println(num3==num4);
		
		Integer it3 = new Integer(100);
		Integer it4 = new Integer(100);
		System.out.println(it1 == it3);
		System.out.println(it4 == it3);
		// 기본 타입이 잇는 오브젝트를 연산하면 자동 언박싱.
		System.out.println(it3 + it4);
		
		List<Integer> list = new ArrayList<>();
		list.add(it1);
		list.add(it2);
		list.add(it3);
		
		// 자동 언박싱 
		int a = it3;
		
		String s = "1000";
		int b = Integer.parseInt(s);
		
		char c = '#';
		
		if(Character.isIdeographic(c)){
			System.out.println("표의문자");
		}else if(Character.isValidCodePoint(c)) {
			System.out.println("표의문자");
		}
		
	}
}
