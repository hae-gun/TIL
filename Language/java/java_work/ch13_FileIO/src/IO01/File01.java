package IO01;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;


public class File01 {
	public static void main(String[] args) {
		// File 객체: 파일이나 디렉터리의 경로를 담고 있는 개체.
		File file = new File("/Users/choehyegeun/Downloads/myFd");
		System.out.println(file);
		
		System.out.println(file.exists());
		File file2 = new File("/Users/choehyegeun/Downloads/myFd/b.txt");
		if(!file.exists()) {
			file.mkdir();
		}
		if(!file2.exists()) {
			//file2.mkdir();
			try {
				file2.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		// URL : 인터넷 주소 ( Uniform Resource Locator)
		// URI : 인터넷에 있는 자원을 나타내는 유일한 주소 ( Uniform Resource Identifier)
		
		String loc = "/Users/choehyegeun/Downloads/myFd/b.txt";
		String loc2 = "http://www.naver. com";
		System.out.println(loc2);
		loc2 = loc2.replaceAll(" ", "%20"); // %20 : 빈칸
		System.out.println(loc2);
		try {
			URI uri = new URI(loc2);
			System.out.println(uri.getHost());
			System.out.println("=======");
			System.out.println(uri.getScheme());
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("====================================================");
		File[] contents = file.listFiles();
		System.out.println(Arrays.toString(contents));
		System.out.println("====================================================");
		
//		Date today = new Date();
//		System.out.println(today);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
//		System.out.println(sdf.format(today));
		
		for(File f : contents) {
			System.out.print(sdf.format(f.lastModified())); // 최종 수정날짜 출력
			if(f.isDirectory()) {
				System.out.println("\t<DIR>\t"+f.getName());
			}else {
				System.out.println("\t"+f.length()+"\t"+f.getName());
			}
		}
		System.out.println("====================================================");
		File file1 = new File("/Users/choehyegeun/Downloads");
		
		if(file1.exists() && file1.isDirectory()) {
			File[] arr = file1.listFiles();
			System.out.println("====================================================");
			System.out.println("               Files from "+file1);
			System.out.println("====================================================");
			recursivePrint(arr,0,0);
		}
		
		
	}

	private static void recursivePrint(File[] arr, int index, int level) {
		
		if(arr.length==index) {
			return;
		}
		
		for(int i=0; i<level; i++) {
			System.out.print("\t");
		}
		
		if(arr[index].isFile()) {
			System.out.println(arr[index].getName());
		}else if(arr[index].isDirectory()) {
			System.out.println("[DIR]"+arr[index].getName());
			recursivePrint(arr[index].listFiles(), 0, level+1);
		}
		recursivePrint(arr, ++index, level);
		
	}
}
