package Algo;

import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TestString {
	public static void main(String[] args) {

//		StringTokenizer st = new StringTokenizer("12 3\n45\n67\n8\t90");
////		Iterator it = st.asIterator();
//		
//		
//		while(st.hasMoreTokens()) {
//			System.out.println(st.nextToken());
//		}
//		boolean regex = Pattern.matches("[1-9][a-z][A-Z]","1234");
//		System.out.println(regex);
//		System.out.println(1+""+2);

//		StringBuilder sb = new StringBuilder();
//
//		Pattern pattern = Pattern.compile("<[^<>]*>");
//
//		Matcher matcher = pattern.matcher("배를 먹습니다. <br /aa>사과를 먹습니다.");
//
//		boolean found = false;
//
//		while (matcher.find()) {
//
//			sb.append("텍스트 \"")
//
//					.append(matcher.group()) // 찾은 문자열 그룹 입니다.
//
//					.append("\"를 찾았습니다.\n")
//
//					.append("인덱스 ")
//
//					.append(matcher.start()) // 찾은 문자열의 시작 위치 입니다.
//
//					.append("에서 시작하고, ")
//
//					.append(matcher.end()) // 찾은 문자열의 끝 위치 입니다.
//
//					.append("에서 끝납니다.\n");
//
//			found = true;
//
//		}
//
//		if (!found) {
//
//			sb.append("찾지 못했습니다.");
//
//		}
//
//		System.out.println(sb.toString());
		mySingletone ms = mySingletone.getInstance();
		mySingletone ms2 = mySingletone.getInstance();
		
		
		System.out.println(ms.getNumber());
		
		System.out.println(ms2.getNumber());
		
		System.out.println(ms.getNumber());
	}

}

class mySingletone{
	private static mySingletone instance;
	public int number;
	
	private mySingletone() {
		number = 0;
	}
	
	public static mySingletone getInstance() {
		if(instance ==null) instance = new mySingletone();
		return instance;
	}
	
	public int getNumber() {
		return number++;
	}
}
