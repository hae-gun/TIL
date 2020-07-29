package class10_polymorphism.product2;

import java.util.ArrayList;
import java.util.List;

class Customer {
	int money = 1000;
	int bonuspoint;
	// 구매물품 목록 - 구매한 물건을 저장할 수 있는 공간 - 부모 타입 배열 생성 - 다형성
	// Product[] pdList = new Product[10];
	List<Product> pdList = new ArrayList<Product>();

	// 매개변수의 다형성 - Product를 상속받은 모든 자식 클래스의 객체들을 매개변수로 받을 수 있다
	// 구매
	void buy(Product p) {
		if (money < p.price) {
			System.out.println("돈이 없쇼, 시간은 많은데...");
			return;
		}
		money -= p.price;
		bonuspoint += p.bonuspoint;
		// for (int i = 0; i < pdList.length; i++) {
		//		if (pdList[i] == null) {
		//			pdList[i] = p;
		//			break;
		//		}
		//	}
		pdList.add(p);
		System.out.println(p + "를 샀습니다.");
		System.out.println(money + " : " + bonuspoint);
		System.out.println("-----구매기록 종료-------");
	}

	int sum = 0, count = 0;

	// 구매 목록
//	void purchaseList() {
//		System.out.println("===========구매 목록===========");
//		for (Product p : pdList) {
//			if (p == null) {
//				continue;
//			} else {
//				count++;
//				sum += p.price;
//				System.out.printf("구입품목: %s, 구입액: %d\n", p, p.price);
//			}
//		}
//		if (count == 0) {
//			System.out.println("구입하신 제품이 없습니다.");
//		} else {
//			System.out.println("============================");
//			System.out.printf("총 구매제품 수: %d, 총구매액: %d\n", count, sum);
//			System.out.println("============================");
//		}
//	}
	void purchaseList() {
		if(pdList.isEmpty()) {
			System.out.println("구입하신 제품이 없습니다.");
			System.out.println("--------------------");
			return;
		}else {
			System.out.println(pdList.size()+"개의 제품을 구입하셨습니다.");
		}
		for(Product p : pdList) {
			count++;
			sum += p.price;
			System.out.printf("구입품목: %s, 구입액: %d\n", p, p.price);
		}
		System.out.println("============================");
		System.out.printf("총 구매제품 수: %d, 총구매액: %d\n", count, sum);
		System.out.println("============================");
	}
	// 반품
	
}
