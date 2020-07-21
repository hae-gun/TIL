package dataType;

import java.util.Scanner;

// 온도 변화기 : 화씨, 섭씨 온도를 입력받아 변환하여 출력
public class TempConverter {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("화씨->섭씨: 1, 섭씨 -> 화씨: 2 선택 >>>");
		String kind = scan.nextLine();
		int select = Integer.parseInt(kind);
		
		if (select == 1) {
		
			System.out.println("화씨 온도를 입력하세요. >>>");
			String tmp = scan.nextLine();
			int ft = Integer.parseInt(tmp);
			float ct = (ft - 32) * 5 / (float)9;
			System.out.printf("화씨 %d도는 섭씨 %.2f입니다.", ft, ct);
		
		} else if (select == 2) {
		
			System.out.println("섭씨 온도를 입력하세요. >>>");
			String tmp = scan.nextLine();
			int ct = Integer.parseInt(tmp);
			float ft = (float)ct*9/5 + 32;
			System.out.printf("섭씨 %d도는 화씨 %.2f입니다.", ct, ft);
		
		}else {
		
			System.out.println("정신 차려라, 1 or 2를 쓰셈 ㅋㅋㅋ");
	
		}

	}
}
