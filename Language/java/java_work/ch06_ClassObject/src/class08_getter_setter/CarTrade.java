package class08_getter_setter;

public class CarTrade {

	public static void main(String[] args) {
		
		CarSeller tom = new CarSeller("tom",20000,10);
		CarSeller mary = new CarSeller("mary",50000,2);
		
		CarBuyer steve = new CarBuyer("steve", 100000);
		CarBuyer jane = new CarBuyer("jane", 30000);
		
		steve.buy(tom,50000);
		steve.print();
		tom.print();
		
		jane.buy(tom,30000);
		jane.print();
		tom.print();
		
		steve.buy(tom,30000);
		jane.buy(mary,10000);
		
		
	}

}
