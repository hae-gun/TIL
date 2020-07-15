package javaIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

// DOS 모드로 작성.
// HashMap에 데이터를 저장해서 이 데이터를 File에 저장.

public class Exam03_ObjectStream {

	public static void main(String[] args) {
		// 1. 로직처리를 통해서 만들어진 데이터 구조를 준비.
		// 최종 결과 데이터가 HashMap으로 만들어졌다고 가정.
		Map<String, String> map = new HashMap<String, String>();

		map.put("1", "홍길동");
		map.put("2", "신사임당");
		map.put("3", "강감찬");
		map.put("4", "유관순");

		// 이 정보를 File 에 저장하고 싶다!
		// file에 어떤 방식으로 저장할지 결정해야 한다.(문자열 형태로 저장한다고 가정)

		File file = new File("asset/StringData.txt"); // asset 해당폴더는 해당프로젝트 바로 하단에 위치함.
		// 대표적인 출력 Stream : PrintWriter
		// 대표적인 입력 Stream : BufferedReader
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			// 객체 직렬화를 통해 저장하기 원하는 객체를 Stream을 통해서 보낼 수 있다.
			// Object Serialization
			// 속도면에서 살작 떨어지나 그것을 상쇄할 만큼 편의성을 제공해 준다.
			oos.writeObject(map);
			oos.flush();

			// Stream 사용 역순으로 스트림을 닫아준다.
			oos.close();
			fos.close();
			// 문자열을 저장하는 구조. PrintWriter은 문자열을 저장하기 위한 Stream이다.
//			PrintWriter pr = new PrintWriter(file);
			// 출력시에는 꼭 Stream을 닫아주거나 flush를 통해 데이터를 내보내야 한다.
//			pr.println("소리없는 아우성");
//			pr.flush();
//			pr.close(); // close() 시에 안에 데이터가 있으면 데이터를 내보내고 닫는다.(flush없어도 출력가능.)
			// 단일문자열과 같은 형태의 간단한 형태의 에디어틀 보낼때는
			// 문제될게 없다.
			// 내가 저장할 데이터가 자료구조 형태로 되어 있다면..
			// 자료구조 형태가 복잡하면 복잡할수록 데이터를 저장하기가 쉽지 않다.
			// 객체자체를 파일에 저장할 수 있다. => 다른 프로그램에 객체를 바로 전달할 수 있다는 의미.
			// Stream 을 통해서 일반 문자열이 아닌 객체자체를 전달할 수 있다.
		} catch (FileNotFoundException e) {
		} catch (IOException e) {}

	}

}
