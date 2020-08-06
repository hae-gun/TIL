package program;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import dto.Customer;
import dto.Person;
import dto.Seller;
import service.Market;
import service.MarketService;

public class MarketEx {

	public static void main(String[] args) {
		int loginType = 0;

		Scanner scan = new Scanner(System.in);

		Set<Person> list = new HashSet<Person>();
		Person custom = new Customer("chkchk610", "1234", "chk");
		Person seller = new Seller("seller", "pass", "james");

		Market lotteMart = null;
//		list.add(custom);
//		list.add(seller);
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/dat/user.dat"));
			while (true) {
				try {
					Person pi = (Person) ois.readObject();
//				if(pi instanceof BookInfo) {
//					BookInfo bi = (BookInfo) pi;
//				}
//				System.out.println(pi);
					list.add(pi);
				} catch (EOFException e) {
					System.out.println("유저정보 읽기 완료");
					break;
				} catch (Exception e) {
					System.out.println("객체정보 변경됨");
					list.add(custom);
					list.add(seller);
				}
			}
			ois = new ObjectInputStream(new FileInputStream("src/dat/market.dat"));
			while (true) {
				try {
					lotteMart = (Market) ois.readObject();
				} catch (EOFException e) {
					System.out.println("마켓정보 읽기 완료");
					break;
				}
			}

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		MarketService service = null;
//		System.out.println(list);
//		lotteMart = new Market((Seller)seller, "LotteMart");
		try {
			service = new MarketService(lotteMart);
		} catch (NullPointerException e) {
			lotteMart = new Market((Seller) seller, "LotteMart");
			service = new MarketService(lotteMart);
		}
		service.conn(seller);

		Person whoAmI = null;

		boolean loginState = false;

		// 로그인 체크
		while (!loginState) {
			System.out.println("id: ");
			String id = scan.nextLine();
			System.out.println("pw: ");
			String pw = scan.nextLine();
			whoAmI = new Person(id, pw, "tom");
			Iterator<Person> i = list.iterator();
			while (i.hasNext()) {
				Person p = i.next();
				if (p.equals(whoAmI)) { // 로그인 성
					whoAmI = p;
					loginState = !loginState;
					System.out.println("Login Success");
					if (whoAmI instanceof Customer) {
						loginType = 0;
						System.out.println("You're " + ((Customer) whoAmI).getTYPE());
					} else if (whoAmI instanceof Seller) {
						loginType = 1;
						System.out.println("You're " + ((Seller) whoAmI).getTYPE());
					}
					break;
				}
				if (!i.hasNext()) {
					System.out.println("Login Fail");
				}
			}
		}
		if (loginType == 1) {
			while (loginState) {
				System.out.println("========== 1. 물건추가 | 2. 물건리스트 | 3. 내정보 | 4. 종료 ==========");
				int code;
				try {
					code = Integer.parseInt(scan.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("잘못된 입력");
					continue;
				}
				switch (code) {
				case 1:

					service.inputProduct();
					break;

				case 2:

					service.getProductList();
					break;

				case 3:

					System.out.println(whoAmI);
					break;

				case 4:

					loginState = !loginState;
					break;

				default:
					System.out.println("1,2,3 중 1개 선택");

					break;
				}

			}
		} // Seller part
		else if (loginType == 0) {
			while (loginState) {
				System.out.println("========== 1. 물건구경 | 2. 물건구매 | 3. 내정보 | 4. 포인트 충전 | 5. 종료 ==========");
				int code;
				try {
					code = Integer.parseInt(scan.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("잘못된 입력");
					continue;
				}
				switch (code) {
				case 1:

					service.getProductList();
					break;

				case 2:

					service.getProductList();
					service.buyProduct((Customer) whoAmI);
					break;

				case 3:

					System.out.println(whoAmI);
					break;
				case 4:
					System.out.println("충전할 포인트 입력>>>>>");
					int money = Integer.parseInt(scan.nextLine());
					((Customer) whoAmI).fillPoint(money);
					break;
				case 5:

					loginState = !loginState;
					break;

				default:
					System.out.println("1,2,3 중 1개 선택");

					break;
				}

			}
		}
		System.out.println("종료");

		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/dat/user.dat"));
			for (Person p : list) {
				oos.writeObject(p);
			}
			oos.flush();
			oos = new ObjectOutputStream(new FileOutputStream("src/dat/market.dat"));
			oos.writeObject(lotteMart);
			oos.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
