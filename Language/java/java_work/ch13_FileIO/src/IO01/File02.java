package IO01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class File02 {
	public static void main(String[] args) {

//		Scanner sc = new Scanner(System.in);
//		System.out.println("명언작성>>>>>");
//		String str = sc.nextLine();
//		System.out.println(str);

		File file = new File("/Users/choehyegeun/Downloads/myFd/b.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(file, "utf-8");

			// token 한개
//			System.out.println(sc.next());
			while (sc.hasNext()) {
				System.out.print(sc.next() + " ");
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}

	}
}
