
public class Op13 {
	public static void main(String[] args) {
		// NaN - Infinity
		int a = 5;
		int b = 0;

		double c = 0.0;

		System.out.println(b / a);

		try {
			System.out.println(a / b);
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}
		
		System.out.println(a / c); // Infinity
		System.out.println(a % c); // NaN
		
		double d = 5* a/c;
		System.out.println(d);
		
		System.out.println(Double.isInfinite(d));
		
		if(Double.isFinite(d)) {
			System.out.println(5*a/c);
		}else {
			System.out.println("무한대가 입력되어 처리할 수 없습니다.");
		}
		
		
	}
}
