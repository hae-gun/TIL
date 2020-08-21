package newMarket;

import java.util.Scanner;

import newMarket.service.MarketService;
import newMarket.vo.User;

public class MarketMain {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		MarketService service = new MarketService(scan);
		User user = null;
		boolean exitFlag = true;
		while (exitFlag) {

			boolean loginFlag = true;
			while (loginFlag) {
				int menu = showLoginMenu(scan);
				switch (menu) {
				case 1:
					user = service.login();
//					System.out.println(user);
					if (user != null)
						loginFlag = !loginFlag;
					break;
				case 2:
					service.registerUser();
					break;
				case 3:
					exitFlag = false;
					loginFlag = !loginFlag;
					break;
				default:
					System.out.println("잘못입력");
				}
			}
			if (user != null) {
				System.out.printf("%s님 환영합니다.\n", user.getId());
				if ("customer".equals(user.getRoll())) {
					System.out.println("당신은 손님입니다.");
				} else if ("seller".equals(user.getRoll())) {
					System.out.println("당신은 점주입니다.");
				}
			}

		}
		System.out.println("종료");

	}

	private static int showLoginMenu(Scanner scan) {
		System.out.println("1.login\t2.register\t3.exit");
		int menu = Integer.parseInt(scan.nextLine());
		return menu;
	}

}
