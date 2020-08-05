package IO_03_stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputEx {
	public static void main(String[] args) throws IOException {
		String original = "/Users/choehyegeun/Downloads/1234.jpg";
		String target = "/Users/choehyegeun/Downloads/4321.jpg";
		
		FileInputStream fis = new FileInputStream(original);
		FileOutputStream fos = new FileOutputStream(target);
		
		int readByteNo;
		byte[] readByte = new byte[100];
		
		while((readByteNo = fis.read(readByte))!=-1) {
			System.out.println(readByteNo);
			fos.write(readByte,0,readByteNo);
		}
		
		fos.flush();
		
		if(fos !=null) {
			fos.close();
		}
		if(fis !=null) {
			fis.close();
		}
	}
}
