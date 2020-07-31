package api02_String;

public class Class09_Upper_lower_statrsWith {
	public static void main(String[] args) {
		String str = "ab I Love You, baby!";
		
		String upper = str.toUpperCase();
		System.out.println(upper);
		String lower = str.toLowerCase();
		System.out.println(lower);
		
		
		// startWith("문자열") : 첫시작이 문자열 인지 아닌지 판별 return boolean.
		if(str.startsWith("ab")) {
			System.out.println(str.toUpperCase());
		}else {
			System.out.println(str.toLowerCase());
		}
		
	}
}
