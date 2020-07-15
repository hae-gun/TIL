package javaThread;

import java.util.LinkedList;

public class ProducerAndConsumerMycase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object monitor = new Object();

		LinkedList<Integer> factory = new LinkedList<>();

		Consumer consumer1 = new Consumer(factory, monitor);
		Consumer consumer2 = new Consumer(factory, monitor);
		Consumer consumer3 = new Consumer(factory, monitor);
		Producer producer = new Producer(factory);

		Thread tc1 = new Thread(consumer1);
		Thread tc2 = new Thread(consumer2);
		Thread tc3 = new Thread(consumer3);

		Thread tp = new Thread(producer);
		tc1.start();
		tc2.start();
		tc3.start();
		tp.start();
	}

}

class Producer implements Runnable {

	private LinkedList<Integer> factory;

	Producer() {

	}

	Producer(LinkedList factory) {
		this.factory = factory;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			if (factory.isEmpty()) {
				System.out.println("공장 가동중");
				for (int i = 0; i < 10; i++) {
					factory.add(i);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
					System.out.println(10 - i);
					if (i == 9) {
						try {
							notifyAll();
						} catch (Exception e) {
						}
					}
				}
				System.out.println("완성");
			}

		}
	}
}

class Consumer implements Runnable {

	private LinkedList<Integer> factory;
	private Object monitor;

	Consumer() {

	}

	Consumer(LinkedList factory, Object monitor) {
		this.factory = factory;
		this.monitor = monitor;
	}

	@Override
	public void run() {
		try {
			
			Thread.sleep(5000);
			
		} catch (InterruptedException e) {
		}
		if (factory.isEmpty()) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}

		} else {
			synchronized (monitor) {
				System.out.println(Thread.currentThread().getName() + "가 " + factory.pop() + "");
			}
		}

	}
}
