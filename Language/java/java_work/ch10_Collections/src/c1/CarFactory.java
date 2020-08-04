package c1;

import java.util.HashMap;

public class CarFactory {
	HashMap<String, Car> map = new HashMap<String, Car>();
	
	private static CarFactory factory = new CarFactory();
	
	private CarFactory() {
		
	}
	
	public CarFactory getInstance() {
		if(factory ==null)
			factory = new CarFactory(); 
		return factory;
	}
	
	public Car createCar(String name) {
		if(map.containsKey(name)) {
			return map.get(name);
		}
		Car car = new Car();
		map.put(name, car);
		return car;
	}
	
	
}
