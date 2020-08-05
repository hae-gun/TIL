package IO_04_Object;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ProductOutput {
	public static void main(String[] args) {

		
		BookInfo bi01 = new BookInfo("1111", 20000, "행복", "tom", 300);
		BookInfo bi02 = new BookInfo("2222", 30000, "돈 버는 자바", "jane", 150);
		BookInfo bi03 = new BookInfo("3333", 17000, "꿈 꾸는 법", "steve", 253);

		// BufferedOutputStream bos = null;

		try {
			// FileOutputStream fos = new FileOutputStream("book.dat");
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("book.dat"));
			// bos = new BufferedOutputStream(new ObjectOutputStream(new
			// FileOutputStream("book.dat")));

			oos.writeObject(bi01);
			oos.writeObject(bi02);
			oos.writeObject(bi03);
			oos.flush();
			oos.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("저장완료");
	}
}
