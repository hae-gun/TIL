package dataType;

import java.util.Collections;

// 형변환 - data type을 바꿈
public class Dt05 {

	public static void main(String[] args) {
		
		int num1 = 200;
		System.out.println(num1);
		
		double num2 = num1; // int type의 값을 double type 변수에 대입 - 자동형변환 (작은타입 -> 큰타입)
		System.out.println(num2);
		
//		int num3 = num2; - Type mismatch: cannot convert from double to int
		int num3 = (int)num2; // 강제 형변환 - 데이터 손실을 감소 할 수 밖에 없다.
		System.out.println(num3);
		
		double num4 = 3456.1234;
		int num5 = (int)num4;
		System.out.println(num4 + " / " + num5);
		
		int iv = 44032;
		char cv = (char)iv;
		
		System.out.println(cv);
	}
}
