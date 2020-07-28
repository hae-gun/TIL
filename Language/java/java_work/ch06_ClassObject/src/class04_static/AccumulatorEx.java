package class04_static;

public class AccumulatorEx {
	public static void main(String[] args) {
		
		System.out.println(Accumulator.grandTotal);
		
		Accumulator acc = new Accumulator();
		System.out.println(acc.grandTotal);
		System.out.println(acc.total);
		
		System.out.println("--------------");
		Accumulator acc2 = new Accumulator();
		System.out.println(acc2.grandTotal);
		System.out.println(acc2.total);
		System.out.println("--------------");

		
		acc.accumulator(5);
		System.out.println(acc.grandTotal);
		System.out.println(acc.total);

		
		
		System.out.println("--------------");
		acc2.accumulator(15);
		System.out.println(acc2.grandTotal);
		System.out.println(acc2.total);
		
	}
}
