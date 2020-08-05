package IO02;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEx {
	public static void main(String[] args) {
		
		File file = new File("today.txt");
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);

			fw.write("오늘은 목요일...\n");
			fw.write("오늘은 목요일...\r\n");
			fw.write("오늘은 목요일...\r");
			fw.write("오늘은 목요일...\n");
			
			fw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		FileWriter fw2 = null;
		try {
			// boolean parameter : ture -> 덮어쓰기. false(default) -> 새로쓰
			fw2 = new FileWriter(file,true);
			fw2.write("이어쓰기");
			fw2.flush();
			fw2.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
