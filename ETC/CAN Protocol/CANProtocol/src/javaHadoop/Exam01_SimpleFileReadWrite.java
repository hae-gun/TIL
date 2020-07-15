package javaHadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class Exam01_SimpleFileReadWrite {

	public static void main(String[] args) {

		// 1. Hadoop의 실행환경을 알아와야 한다.
		Configuration conf = new Configuration();
		try {
			//Configuration 으로부터 FileSystem을 얻어온다.
			FileSystem hdfs = FileSystem.get(conf); 
			String fileName = "/test.txt";
			String contents = "소리없는 아우성!";
			//경로객체를 설정.
			Path path = new Path(fileName);
			
			// Hadoop file이 있는지 확인 (root 디렉토리에)
			if(hdfs.exists(path)) {
				// 똑같은 경로 및 파일이 존재하면 삭제.
				hdfs.delete(path,true); // true: 물어보지 않고 바로 삭제
			}
			// 파일을 생성하고 OutputStream을 리턴받는다.
			FSDataOutputStream out = hdfs.create(path);
			out.writeUTF(contents);
			out.close();
			
			// 만들어진 파일에서 데이터를 읽어보기.
			FSDataInputStream in = hdfs.open(path);
			String data = in.readUTF();
			in.close();
			
			System.out.println("읽은 내용: " + data);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
