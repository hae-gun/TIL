package threadBasic;

public class TestEx {
	public static void main(String[] args) {
		Thread t = new Thread(new NumbersEx());
		t.start();
		Numbers num = new Numbers();
		num.list(0, 10);
	}
}
