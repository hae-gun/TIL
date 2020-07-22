import java.util.Scanner;

// 주민번호를 입력받아 해당 숫자 뽑아서 3항식을 이용해 성별 구분하여 출력
// 8번째 자리 문자를 뽑아서 홀수면 남자, 짝수면 여자 출력

public class Op09 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String str = "";
		int gender = 0;
		
		System.out.println("주민번호 입력(123456-1234567)>>>");
		String idNo = scan.nextLine();
		
		gender = idNo.charAt(7)-'0';
		
		str = gender%2 == 0 ? "여자" : "남자"; 
		
		System.out.printf("당신은 %s입니다.",str);
		
		
	}
}
