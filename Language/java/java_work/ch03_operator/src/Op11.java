import java.util.Scanner;

public class Op11 {

	// main start
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		char ch = ' ';
		System.out.println("문자 하나 입력>>>>>>>>>>");

		String input = sc.nextLine();
		ch = input.charAt(0);
		
		if (ch >= '0' && ch <= '9') {
			System.out.printf("입력하신 문자 %c는 숫자입니다.\n", ch);
		} else if ((ch >= 'a' && ch <= 'z')||(ch >= 'A' && ch <= 'Z')) {
			System.out.printf("입력하신 문자 %c는 영문자입니다.\n", ch);
		} 
//		else if (ch >= 'A' && ch <= 'Z') {
//			System.out.printf("입력하신 문자 %c는 영문자(대)입니다.\n", ch);
//		}
		else {
			System.out.println("특수문자 입니다.");
		}
		
	}// main end
}
