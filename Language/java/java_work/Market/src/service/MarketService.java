package service;

import java.io.Serializable;
import java.util.Map;
import java.util.Scanner;

import dto.Customer;
import dto.Person;
import dto.Product;
import dto.Seller;

public class MarketService implements Serializable {

	Market market;
	Map<Integer, Product> ProductList;
	int i=0;
	public MarketService(Market market) {
		this.market = market;
		this.ProductList = market.getProductList();
		i = market.getProductList().size();
	}

	public boolean connectSeller(Seller loginSeller) {
		if (loginSeller.equals(market.getMaster())) {
			return true;
		}
		return false;
	}

	public void connectCustomer(Customer buyer) {
		if (!market.getConnectingUser().contains(buyer))
			market.getConnectingUser().add(buyer);
	}

	public void disconnectCustomer(Customer buyer) {
		if (market.getConnectingUser().contains(buyer))
			market.getConnectingUser().remove(buyer);
	}

	public void conn(Person person) {
		if (person instanceof Seller) {

			market.setMasterLoginState(connectSeller((Seller) person));

		} else if (person instanceof Customer) {
			connectCustomer((Customer) person);
		}
	}

	public void inputProduct() {
		int nsn;
		int count;
		String type;
		String name;
		int price;
		Scanner scan = new Scanner(System.in);
		try {
			System.out.println("nsn>>>");
			nsn = Integer.parseInt(scan.nextLine());
			if (nsn < 0)
				throw new NegativeNumber();

			System.out.println("type>>>");
			type = scan.nextLine();

			System.out.println("name>>>");
			name = scan.nextLine();

			System.out.println("price>>>");
			price = Integer.parseInt(scan.nextLine());
			if (price < 0)
				throw new NegativeNumber();

			System.out.println("갯수>>>");
			count = Integer.parseInt(scan.nextLine());
			if (count < 0)
				throw new NegativeNumber();

		} catch (NumberFormatException e) {
			System.out.println("숫자를 입력해야 합니다. -등록실패-");
			return;
		} catch (NegativeNumber e) {
			System.out.println("음수입력 오류. -등록실패-");
			return;
		}
		Product p = new Product(nsn, type, name, price);
		p.setCount(count);
		addProduct(i++, p);
	}

	public void addProduct(int num,Product product) {
		if (!market.isMasterLoginState()) {
			System.out.println("판매자로 로그인 하세요");
			return;
		}
		ProductList.put(num, product);
		System.out.println("등록완료");
		market.getProductList();

	}

	public void getProductList() {
		if (!ProductList.isEmpty()) {
			System.out.println("물건 리스트");
			for (Product m : ProductList.values()) {
				System.out.printf("%d. %s, 갯수: %d\n",ProductList.get(m), m.getName(), m.getCount());
			}
		} else {
			System.out.println("물건이 없음.");
		}
	}
	
	public void buyProduct(Customer whoAmI) {
		Product product = null;
		int count = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("구매할 제품 이름입력.");
		String name = scan.nextLine();
		System.out.println(ProductList.keySet());
//		if (ProductList.containsKey(name)) {
//			for (Product m : ProductList.keySet()) {
//				if (name.equals(m.getName())) {
//					product = m;
//					count = ProductList.get(m);
//				}
//			}
//			if (ProductList.get(product) > 0) {
//				System.out.println(product + "제고량: " + count);
//			} else {
//				System.out.println("제고가 부족합니다.");
//			}
//		} else {
//			System.out.println("없는 제품입니다.");
//		}

	}

}

class NegativeNumber extends Exception {
	public NegativeNumber() {
		super("음수입력");
	}

	public NegativeNumber(String msg) {
		super(msg);
	}
}
