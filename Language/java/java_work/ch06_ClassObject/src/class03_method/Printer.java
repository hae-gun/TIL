package class03_method;

public class Printer {
	
	private void println(int i) {
		System.out.println(i);
	}
	private void println(String i) {
		System.out.println(i);
	}
	private void println(boolean i) {
		System.out.println(i);
	}
	private void println(double i) {
		System.out.println(i);
	}

	public static void main(String[] args) {
		Printer pt = new Printer();
		pt.println(10);
		pt.println("tom");
		pt.println(true);
		pt.println(3.14);
	}

}
