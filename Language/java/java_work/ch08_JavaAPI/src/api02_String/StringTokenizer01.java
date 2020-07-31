package api02_String;

import java.util.StringTokenizer;

public class StringTokenizer01 {
	public static void main(String[] args) {
		String txt = "에디슨/안창호/유관순";

		StringTokenizer st = new StringTokenizer(txt, "/");
		int countTokens = st.countTokens();
		System.out.println(countTokens);
		
		for (int i = 0; i < countTokens; i++) {
			System.out.println(st.nextToken());

		}
		System.out.println("----------------------------");
		// Tokenizer는 한번사용하면 사라져 버린다.
		// 새로 만들어야 한다.
		st = new StringTokenizer(txt,"/");
		
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
		System.out.println("----------------------------");
		String str = "사과=500|초콜릿=200|샴페인=300";
		// 구분자 까지지 들어가게된다.
		StringTokenizer stk = new StringTokenizer(str,"=|",true);
		while(stk.hasMoreTokens()) {
			String tok = stk.nextToken();
			if(tok.equals("=")) {
				System.out.print("\t");
			}else if(tok.equals("|")) {
				System.out.println();
			}else {
				System.out.println(tok);
			}
		}
	}
}
