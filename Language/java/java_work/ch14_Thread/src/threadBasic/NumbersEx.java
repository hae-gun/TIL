package threadBasic;

public class NumbersEx extends Numbers implements Runnable {
	
	public static void main(String[] args) {
		Numbers nb = new Numbers();
		nb.list(1, 10);
		
		Thread t = new Thread(new NumbersEx());
		t.start();
		
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				Numbers nb = new Numbers();
				nb.list(10, 20);
			}
			
		});
		t2.start();
		
		
	}

	
	@Override
	public void run() {
		list(0, 10);
	}

}

