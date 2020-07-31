package api02_String;

public class String04_IndexOf {
	 public static void main(String[] args) {
		 // indexOf() : 특정 문자나 문자열의 첫 번째 위치값을 반환.
		String str = "서울, 21 부산, 29, 인천, 33";
		int index1 = str.indexOf(",");
		System.out.println("indexOf(,) : "+index1);
	
		int index2 = str.indexOf("부산");
		System.out.println("indexOf(,) : "+index2);
		
		// restIndexOf : 특정 문자나 문자열의 마지막 위치값을 반환
		int index3 = str.lastIndexOf(",");
		System.out.println("indexOf(,) : "+index3);
		
	 }
}
