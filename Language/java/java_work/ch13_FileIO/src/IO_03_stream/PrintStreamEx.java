package IO_03_stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamEx {
	public static void main(String[] args) throws FileNotFoundException {
		
		
		PrintStream ps = new PrintStream(System.out);
		ps.println("wow");
		
		ps = new PrintStream("hello.txt");
		ps.println("wow");
		ps.println("wow");
		ps.println("wow");
		ps.println("wow");
		ps.println("wow");
		ps.println("wow");
		ps.println("wow");
		
		FileOutputStream fos = new FileOutputStream("hi.csv");
		PrintStream prst = new PrintStream(fos, true);
		prst.println("성명, 나이, 전화번호");
		prst.println("김, 11, 111-111-1111");
		prst.println("김, 11, 111-111-1111");
		prst.println("김, 11, 111-111-1111");
		prst.println("김, 11, 111-111-1111");
		prst.println("김, 11, 111-111-1111");

		
		ps.close();
		prst.close();
	}
}
