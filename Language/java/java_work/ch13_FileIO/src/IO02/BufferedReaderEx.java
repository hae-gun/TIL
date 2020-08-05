package IO02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BufferedReaderEx {
	public static void main(String[] args) throws IOException {
		
		String path = "today.txt";
//		FileReader fr = new FileReader(new File(path));
		// 닫을때 br만 닫으면 다 닫힘.
		BufferedReader br = new BufferedReader(new FileReader(new File(path)));
		
		String s="";
		while((s=br.readLine())!=null) {
			System.out.println(s);
		}
		
		br.close();
		
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("입력>>>");
		String contents = "";
		while((contents=br2.readLine())!=null) {
			if("exit".equals(contents.toLowerCase())) {
				break;
			}
			System.out.println("입력된 값: "+contents);
		}
		
		
		System.out.println("System Exit");
		
		
	}
}
