package try_catch;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Except03 {
	public static void main(String[] args) {
		FileReader fr = null;

		try {
			// FileNotFoundException
			fr = new FileReader("a.txt");
			// IOException
			System.out.println(fr.read());

			String str = null;
			// NullPointerException
//			System.out.println(str.length());
			int[] arr = new int[3];
//			arr[3] = 40;

			int a = 5 / 0;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("파일 찾을수 없음.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
//			e.printStackTrace();
			System.out.println("null or arryaIndex - " + e.getMessage());
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (fr != null)
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		// 범위가 넓은 Exception을 뒤에서 잡아야 한다.

		System.out.println("Exception 완료하고 프로그램 종료.");
	}
}
