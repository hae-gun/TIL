package try_catch;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Except02 {
	public static void main(String[] args) {
//		Scanner sc;
		Scanner sc = new Scanner(System.in);

		while (true) {
			int[] num = new int[2];

			// Type mismatch: cannot convert from String to int - compile error
			// num[0]=tmp;

			// java.lang.NumberFormatException: For input string: "a"
			try {
				System.out.println("정수입력>>>");
				String tmp = sc.nextLine();
				num[0] = Integer.parseInt(tmp);

				System.out.println("정수입력>>>");
				tmp = sc.nextLine();
				num[1] = Integer.parseInt(tmp);

				System.out.println("정수입력>>>");
				tmp = sc.nextLine();
				num[2] = Integer.parseInt(tmp);

			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력하세여");
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("배열범위 넘어감");
			} finally {
//				sc.close();
			}

		}

	}
}
