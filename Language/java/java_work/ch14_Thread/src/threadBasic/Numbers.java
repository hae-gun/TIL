package threadBasic;

public class Numbers {
	
	void list(int start, int end) {
		for (int i = start; i <= end; i++) {
			System.out.println("(" + i + ")");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
