package api03_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherEx {
	public static void main(String[] args) {
		String txt = "https://ac.incruit.com/servic" + "https://ac.incruit.com/servic"
				+ "https://ac.incruit.com/servic";

		String ptn = "https://";
		Pattern pattern = Pattern.compile(ptn);
		// txt 문자열에 패턴을 맞춰보는 객체 matcher 생성
		Matcher matcher = pattern.matcher(txt);

		// 문자열 전체에 패턴 전체와 일치하는 것이 있는지를 boolean 반환
		System.out.println(matcher.matches());

		// 문자열이 특정 패턴으로 시작하는가를 불리언 반환
//		System.out.println(matcher.lookingAt());

		// find(): 패턴과 일치하는 다음 순서를 검색(커서이동) 다음번 나오는지 확인.
//		System.out.println(matcher.find());
//		System.out.println(matcher.group());
//		
//		System.out.println(matcher.find());
//		System.out.println(matcher.group());
//		
//		// lookingAt 에서의 커서의 이동 때문에 찾지 못함.
//		System.out.println(matcher.find());
//		System.out.println(matcher.group());
//		
		
		// https:// 위치 모두 찍어보는법 찾기.
		int count = 0;
		while (true) {
			if (matcher.find()) {
				System.out.println(++count + " : " + txt.indexOf(matcher.group()));
				
			} else {
				System.out.println("더 이상 없다.");
				break;
			}
		}
		System.out.println("총 개수: " + count);

	}
}
