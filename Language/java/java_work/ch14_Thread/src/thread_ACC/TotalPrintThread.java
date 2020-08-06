package thread_ACC;

public class TotalPrintThread extends Thread{
	
	Bank sb;

	public TotalPrintThread(Bank sb) {
		this.sb = sb;
	}

	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println("계좌합계: "+sb.getTotal());
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
