package try_catch;

import java.util.Scanner;

public class Except01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		boolean flag = true;
		while (flag) {

			System.out.println("정수 입력");
			int num1 = sc.nextInt();

			System.out.println("정수 하나더 입력");
			int num2 = sc.nextInt();

			boolean div = divice(num1, num2);

			if (div) {
				System.out.println("성공");
			} else {
				System.out.println("실패");
			}
		}
	}

	private static boolean divice(int num1, int num2) {
		// java.lang.ArithmeticException: / by zero - runtime exception.
		// 개발자가 직접 처리해야함. try~catch~[finally]
		try {
			int result = num1 / num2;
			System.out.println("결과: " + result);
			return true;
		} catch (ArithmeticException e) {
//			e.printStackTrace();
//			System.out.println(e.getMessage());
			System.out.println("0으로 나눌수 없음");
			return false;
		}finally { // Exception 발생 여부 상관없이 출력. 주로 입출력 객체 닫아줄때 사용함.
			System.out.println("=======================");
		}
	}
}
