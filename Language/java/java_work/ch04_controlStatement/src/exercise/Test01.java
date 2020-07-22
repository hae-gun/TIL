package exercise;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		// 주민등록번호 입력받아
		// 1: 2000년 이전 남자
		// 2: 2000년 이후 남자
		// 3: 2000년 이전 여자
		// 4: 2000년 이후 여자
		// 이외의 경우 "go to see a doctor!"
		
		System.out.println("주민등록번호 입력(123456-1234567)>>>>>>");
		Scanner scan = new Scanner(System.in);
		String idNo = scan.nextLine();
		
		char gender = idNo.charAt(7);
		
		switch (gender) {
		case '1':
		case '3':
			System.out.println("당신은 남자입니다.");
			switch (gender) {
			case '1':
				System.out.println("2000년 이전 생이시군요");
				break;
			case '3':
				System.out.println("2000년 이후 생이시군요");
				break;
			default:
				break;
			}
			break;
		case '2':
		case '4':
			System.out.println("당신은 여자입니다.");
			switch (gender) {
			case '2':
				System.out.println("2000년 이전 생이시군요");
				break;
			case '4':
				System.out.println("2000년 이후 생이시군요");
				break;
			default:
				break;
			}
			break;

		default:
			System.out.println("go to see a doctor!");
			break;
		}
	}

}
