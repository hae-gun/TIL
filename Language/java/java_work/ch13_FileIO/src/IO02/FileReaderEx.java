package IO02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx {
	public static void main(String[] args) {
		String path = "today.txt";
//		
//		File file = new File(path);
//		FileReader fr = new FileReader(file);
		FileReader fr = null;
		try {
			// 경로를 직접 쓰는것 : HardCoding
			fr = new FileReader(new File(path));
//			BufferedReader br = new BufferedReader(fr);
//			System.out.println(fr.read());
//			while() {
//				
//			}
			// 읽어온 글자 수 저장.
			int readCharNo;
			// 읽어온 글자를 넣을 변수.
			String data = null;
			// 일어온 글자가 들어갈 문자 배열 변수.
			char[] buffer = new char[100];

			while ((readCharNo = fr.read(buffer)) != -1) {
				System.out.println(readCharNo);

				data = new String(buffer);

				System.out.println(data);
			}
			

		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		} finally {
			if (fr != null)
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
				}
		}

	}
}
