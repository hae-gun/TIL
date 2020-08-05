package IO_04_Object;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ProductInput {
	public static void main(String[] args) {

		List<Product> productInfo = new ArrayList<>();
		
		try {
			//FileInputStream fis = new FileInputStream("book.dat");
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("book.dat"));
			while(true) {
				try {
				Product pi = (Product) ois.readObject();
//				if(pi instanceof BookInfo) {
//					BookInfo bi = (BookInfo) pi;
//				}
//				System.out.println(pi);
				productInfo.add(pi);
				}catch(EOFException e) {
					System.out.println("읽기 완료");
					break;
				}
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Product p : productInfo) {
			System.out.println(p);
		}
	}
}
