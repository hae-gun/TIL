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
			if (user == null) {
				break;
			}
			System.out.printf("%s님(%s) 환영합니다.\n", user.getId(), user.getRoll());
			boolean marketFlag = true;
			if ("customer".equals(user.getRoll())) {
				while (marketFlag) {
					int menu = customerMenu(scan);
					switch (menu) {
					case 1:
						service.getProductList();
						break;
					case 2:
						service.buyProduct(user);
						break;
					case 3:
						service.setPoint(user);
						break;
					case 4:
						service.orderList(user);
						break;
					case 5:
						marketFlag = false;
						System.out.println("로그아웃!!");
						break;
							
					default:
						break;
					}
				}
			} else if ("seller".equals(user.getRoll())) {
				while (marketFlag) {
					int menu = sellerMenu(scan);
					switch (menu) {
					case 1:
						service.getProductList();
						break;
					case 2:
						service.addProduct();
						break;
					case 3:
						service.updateProduct();
						break;
					case 4:
						service.getuserList();
						break;
					case 5:
						marketFlag = false;
						System.out.println("로그아웃!!");
						break;
						
					default:
						break;
					}

				}
			}

		}
		System.out.println("종료");
	}

	private static int sellerMenu(Scanner scan) {
		System.out.println("1.제품목록  2.제품등록  3.제품업데이트  4.회원목록조회  5.로그아웃");
		int menu = Integer.parseInt(scan.nextLine());
		return menu;
	}

	private static int customerMenu(Scanner scan) {
		System.out.println("1.제품구경  2.제품구매  3.포인트충전  4.구매리스트  5.로그아웃");
		int menu = Integer.parseInt(scan.nextLine());
		return menu;
	}

	private static int showLoginMenu(Scanner scan) {
		System.out.println("1.login  2.register  3.exit");
		int menu = Integer.parseInt(scan.nextLine());
		return menu;
	}

}
