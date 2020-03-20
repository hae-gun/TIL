package com.test;

class MyThread extends Thread{
	// 독립적인 실행 흐름이 있어야 한다.
	// method로 독립적인 실행흐름을 표현한다.
	@Override
	public void run() {
		super.run();
		System.out.println("MyThread 입니다.");
	}
}
class MyRunnable implements Runnable{
	@Override
	public void run() {
		System.out.println("MyThread2 입니다.");
	}
}

public class ThreadTest {

	// 프로그램의 entry point
	// 프로그램은 해당 프로그램에서 사용되는 모든 Thread가 종료되는 시점에 프로그램이 종료된다.
	// Java에서 Thread는 어떻게 표현되나요? ==> instance(객체)
    // Thread를 만들기 위한 Class가 존재한다. => Thread class
	// Thread 클래슬르 이용해서 thread객체를 생성하는데 크게 2가지 방식으로 생성한다.
	// 1. 상속
	// 2. interface를 구현
	
	public static void main(String[] args) {
		
	    Thread t = new MyThread();	// t: thread instance
	    MyRunnable runnable = new MyRunnable();
	    Thread t1 = new Thread(runnable); // 인자로 넣어서 Thread생성.
	    // thread를 실행시키려면 start() method를 사용.
	    t.start(); // non blocking method
	    t1.start();
	    System.out.println("Thread에 대해서 알아보아요.");
	}

}
