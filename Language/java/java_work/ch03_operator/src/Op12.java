
public class Op12 {
	public static void main(String[] args) {
		// String 연산 - 덧셈만 가능
		String a = "I ";
		String b = "love ";
		String c = "you";
		System.out.println(a+b+c);
		
		// 문자열 + 숫자 => 문자열
		String e = "JAVA";
		
		System.out.println(e + 8.0);
		
		// String 의 내용 비교는 equals 메소드 사용
		String str1 = "today";
		String str2 = "today";
		
		
		if(str1 == "today") {
			System.out.println("yes");
		}else {
			System.out.println("no");
		}
	
		if(str1 == str2) {
			System.out.println("yes");
		}else {
			System.out.println("no");
		}
		
		String str3 = new String("today");
		
		System.out.println("str3: " + str3);
		
		if(str1.equals(str3)) {
			System.out.println("yes");
		}else {
			System.out.println("no");
		}
		// `==`은 메모리 주소를 비교하라는 부호이다.
	}
}
