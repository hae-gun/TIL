package class03_method;

public class CalculatorEx {
	public static void main(String[] args) {
		Calculator cal = new Calculator();

		cal.powerOn();
		cal.devide(9, 3);
		cal.powerOff();

		int result = cal.minus(9, 3);

		System.out.println(result);
		
		Calculator cal2 = new Calculator();
		
//		if(cal==cal2) {
//			System.out.println("Y");
//		}else {
//			System.out.println("N");
//		}
		
		cal2.plus(123,243);
		cal2.multi(3, 4);
		
		System.out.println(cal);
		System.out.println(cal2);
	}
}
