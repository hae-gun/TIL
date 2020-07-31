package api02_String;

public class String06_Substring {
	public static void main(String[] args) {
		String str = "서울, 21, 부산, 29, 인천, 33";

		System.out.println(str.substring(8));
		
		System.out.println(str.substring(str.indexOf("부산"),str.indexOf("부산")+6));
//		System.out.println(str.substring(beginIndex));
		
	}
}
