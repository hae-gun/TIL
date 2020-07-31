package api02_String;

public class String08_concat_trim {
	public static void main(String[] args) {
		String str1 = "        Let it be~      ";
		String str2 = str1.trim();
		System.out.println(str1);
		System.out.println(str2);
		
		String str3 = "Speaking words of wisdom, ";
		
		// 문자열 합치기 +연산과 같다.
		String str4 = str3.concat(str2);
		
		System.out.println(str4);
		System.out.println(str3 + str2);
		
		
	}
}
