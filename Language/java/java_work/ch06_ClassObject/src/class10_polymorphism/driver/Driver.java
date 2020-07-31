package class10_polymorphism.driver;

public class Driver {
	//매개변수의 다형성
	void drive(Vehicle v) {
		v.run();
		if(v instanceof Bus) {
			((Bus)v).transit();
		}else if(v instanceof Taxi) {
			((Taxi)v).payMoney();
		}
	}
}
