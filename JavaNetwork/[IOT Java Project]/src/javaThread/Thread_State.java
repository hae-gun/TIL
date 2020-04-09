package javaThread;

class myRunnable implements Runnable {
	@Override
	public void run() {

		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("i : " + i);
		}

	}
}

public class Thread_State {

	public static void main(String[] args) {
		myRunnable runnable = new myRunnable();
		Thread t1 = new Thread(runnable);

		t1.start();
	}

}
