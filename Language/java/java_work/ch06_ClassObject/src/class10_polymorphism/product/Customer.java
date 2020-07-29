package class10_polymorphism.product;

class Customer {
	int money = 1000;
	int bonuspoint;
	
	//매개변수의 다형성 - Product를 상속받은 모든 자식 클래스의 객체들을 매개변수로 받을 수 있다
	void buy(Product p) {
		if(money < p.price) {
			System.out.println("돈이 없쇼, 시간은 많은데...");
			return;
		}
		money -= p.price;
		bonuspoint += p.bonuspoint;
		System.out.println(p + "를 샀습니다.");
	}
}
