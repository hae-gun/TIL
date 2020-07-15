package javaThread;

// 1초마다 자신의 이름을 도스창에 출력하는 Thread를 만들어서 실행해 보자.
// 10번씩 출력
// 한버씩 번갈아 가면서 출력! => 순서를 제어하려고 한다.
// 일반적인 방식으로는 할 수 없다. Thread Scheduler 에 의해서 Thread가 제어되기 때문이다.
// 특수한 method 를 이용해서 Thread 실행 순서를 제어해 보자.
// wait(), notify(), notifyAll() method 를 이용해서 제어한다.
// => 이 method 는 반드시 Critical Section 에서만 사용이 가능하다.
// => Critical Section (임계영역) => 동기화 코드가 적용된 부분. (ex - synchronized block 안) 
class PrintRunnable implements Runnable {

	private Shared obj;

	PrintRunnable() {
	}

	PrintRunnable(Shared obj) {
		this.obj = obj;
	}

	@Override
	public void run() {

		obj.printNum();

//			try {
//				Thread.sleep(1000);
//
//				synchronized (monitor) {
//					String name = Thread.currentThread().getName();
//					System.out.println(name);
//
//				}
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//

	}
}

// 공용객체를 만들기 위한 class
class Shared {
	// Thread 가 공용으로 사용하는 데이터와
	// Thread 가 공용으로 사용하는 method 가 존재 => 로직처리.
	// synchronized keyword 를 이용하면 monitor 를 가져오게 된다.
	public synchronized void printNum() {
		// Thread 의 이름과 숫자를 찍어주는 로직 처리.
		for (int i = 0; i < 10; i++) {
			System.out.println(i + " : " + Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
				notify(); // wait으로 Block 되어 있는 Thread 를 깨우는 method
				wait();// 갖고있는 강제로 monitor를 반납한 후 자기 자신을 wait block 시키는 method
			} catch (InterruptedException e) {
			}
		}
	}

}

public class Exam04_ThreadWaitNotify {
	public static void main(String[] args) {

		// 공용객체
		Shared obj = new Shared();

		PrintRunnable r1 = new PrintRunnable(obj);
		PrintRunnable r2 = new PrintRunnable(obj);

		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);

		// 객체가 가지는 method를 호출할 떄 일반적으로
		// blocking method 를 사용한다.

		t1.start();
		// start() blocking 방식으로 동작하면??
		// 만약 blocking 방식의 method 라면 순차처리가 된다.
		// start() method 는 non-blocking method이다
		t2.start();
		

	}
}
