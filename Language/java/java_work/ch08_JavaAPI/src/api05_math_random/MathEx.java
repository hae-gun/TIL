package api05_math_random;

public class MathEx {
	public static void main(String[] args) {

		int dice = (int) (Math.random() * 6) + 1;

		double area = Math.PI * dice * dice;

		
		
		System.out.println(area);
		
		System.out.println(Math.abs(-5.2));
		System.out.println(Math.ceil(3.14));
		System.out.println(Math.ceil(-3.14));
		System.out.println(Math.floor(-3.14));
		System.out.println(Math.round(-3.54));
		System.out.println(Math.pow(2,3));
		
		

	}
}
