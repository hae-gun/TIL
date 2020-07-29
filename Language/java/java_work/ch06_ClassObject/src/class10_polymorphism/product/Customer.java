package class10_polymorphism.product;

class Customer {

	int money = 1000;
	int bonuspoint;

	Product[] pdList = new Product[10];

	// 매개변수의 다형성 - Product를 상속받은 모든 자식 클래스의 객체들을 매개변수로 받을 수 있다
	void buy(Product p) {
		if (money < p.price) {
			System.out.println("돈이 없쇼, 시간은 많은데...");
			return;
		}
		money -= p.price;
		bonuspoint += p.bonuspoint;

		for (int i = 0; i < pdList.length; i++) {
			if (pdList[i] == null) {
				pdList[i] = p;
				break;
			}
		}

		System.out.println(p + "를 샀습니다.");
		System.out.println(money + " : " + bonuspoint);
		System.out.println("-------구매기록 종료-------");
	}

	void purchaseList() {
		if (pdList.length == 0) {
			System.out.println("구입하신 제품이 없습니다.");
		} else {

			System.out.println("-----------구매 목록-----------");
			for (Product p : pdList) {
				if (p == null) {
					continue;
				} else {
					System.out.printf("구입목록: %s, 구입액: %d\n", p, p.price);
				}
			}
			System.out.println("----------------------------");
		}
	}
}






