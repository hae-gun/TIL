package dataType;

public class Dt01 {

	// 변수: 기본형(primitive type), 참조형(reference type)

	// number type 기본형 변수
	//

	public static void main(String[] args) {
		byte var1 = -128; // byte 타입의 변수 var1을 선언하고 -128 초기화 함.
		byte var2 = -30;
		byte var3 = 127;
//		byte var4 = 128; // Type mismatch: cannot convert from int to byte 형 변환이 안된다.

		byte var5 = 125; // 1byte 에 저장된 125
		int var6 = 125; // 4byte 에 저장된 125

		for (int i = 0; i < 5; i++) {
			var5++; // var5 = var5+1
			var6++;
			System.out.println("var5: " + var5 + " / var6: " + var6);
		}
		// int(32bit)의 범위: -2^31 ~ 2^31-1
		int num1 = 2111111111;
		// long(64bit)
		long num2 = 999999999999999999L; // long 타입 변수는 l or L을 표시해 준다.
		
		num1 *=2;
		System.out.println(num1);
		
		float var7 = 3.14f;
		float var8 = 3e6f; // 3000000.0f
		double var9 = 3e6; // 3000000.0
		
		double var10 = 2e-3; // 0.002
		
		System.out.println(var7);
		System.out.println(var8);
		System.out.println(var9);
		System.out.println(var10);
		
	}

}
