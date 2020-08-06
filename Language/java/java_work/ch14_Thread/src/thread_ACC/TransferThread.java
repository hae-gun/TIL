package thread_ACC;

// Thread 생성방법
// 1. Thread 상속 run() override
// 2. Runnable interface 구현 run() override.
// 3. Thread 객체를 생성하면서 매개변수로 쓰레드로 만들 클래스를 전달.
// Thread 출발 - start() 로 실행.
public class TransferThread extends Thread {
	Bank sb;

	public TransferThread(Bank sb) {
		this.sb = sb;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			sb.transfer(1000);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
