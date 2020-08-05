package IO_03_stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedInOutEx {
	public static void main(String[] args) throws IOException {

		FileInputStream fis = null;
		FileOutputStream fos = null;

		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;

		int data;
		fis = new FileInputStream("0.jpeg");
		fos = new FileOutputStream("apple.jpeg");
		
		long start = System.currentTimeMillis();
		
		while ((data = fis.read()) != -1) {
			fos.write(data);
		}
		
		fos.flush();
		fos.close();
		fis.close();

		long end = System.currentTimeMillis();

		System.out.println("No Buffer: " + (end - start));

		fis = new FileInputStream("0.jpeg");
		fos = new FileOutputStream("apple.jpeg");
		bis = new BufferedInputStream(fis);
		bos = new BufferedOutputStream(fos);

		start = System.currentTimeMillis();
		
		while ((data = bis.read()) != -1) {
			bos.write(data);
		}
		
		bos.flush();
		bos.close();
		bis.close();
		
		end = System.currentTimeMillis();

		System.out.println("Use Buffer: " + (end - start));
	}
}