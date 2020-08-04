package try_catch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Except05 {
	public static void main(String[] args) {
//		FileInputStream fis = null;
		
		
		// try~with~resource : close 를 사용하지 않아도 입출력 객체 자동으로 닫아줌.
		try (FileInputStream fis = new FileInputStream("a.txt")){
//			fis = new FileInputStream("a.txt");
			System.out.println(fis.read());
//			throw new HappyException();
			
		} catch (FileNotFoundException e) {

			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		} 
//		finally {
//			try {
//				fis.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		
	}
}
