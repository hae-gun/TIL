package api02_String;

public class String10_split {
	//split: 특정 구분기호(delimit)로 문자열을 분리하여 String 배열로 반환
	public static void main(String[] args) {
		String str = "tom, sam, jane";
		String[] students = str.split(",");
		for(String s: students) {
			
			System.out.println(s.trim());
		}
		
		String txt = "계백장군&세종대왕,아인슈타인,소크라테스-플라톤";
		String[] celeb = txt.split("&|,|-"); // | 파이프라인으로 여러개 처리 가능.
		for(String s:celeb) {
			System.out.println(s.trim());
		}
		
				
	}
}
