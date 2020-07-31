package api02_String;

public class String05_replace {
	public static void main(String[] args) {
		String str = "서울, 21 부산, 29, 인천, 33";
		System.out.println(str); 
		String str1 = str.replace(",", "/"); // 새로운 문자열을 만들어서 반환.
		System.out.println(str1);
		// str 는 바뀌지 않음. 
		System.out.println(str);
		
		System.out.println(str.replace("부산", "광주"));
		System.out.println(str);
		
		
	}
}
