package javaThread.procon;

import java.util.LinkedList;

// ShareObjec.java => 공용객체를 만들기 위한 class
// 각 Thread 가 공유하는 자료구조.
// 공유객체는 여러개가 필요없다.. 1개만 존재해야함.
// 이 1개의 공유객체를 여러개의 Thread 가 공유해서 사용.
// => Singleton pattern으로 작성.

public class SharedObject {

	private static final Object MONITOR = new Object();

	private static SharedObject obj = new SharedObject();
	// 공용으로 사용하는 데이터가 존재해야한다.
	// 숫자를 저장하는 자료구조를 하나 만들어서 이 자료구조를 각 Thread 가 공유하게끔 처리.
	private LinkedList<String> list = new LinkedList<String>();

	// Singleton pattern은 기본적으로 생성자가 private으로 지정.
	// 그래야 class 외부에서 (다른 class 에서) 생성자가 반복 호출되서
	// 객체가 여러개 생성되는것을 막을 수 있다.
	private SharedObject() {

	}

	// 생성자가 private 이므로 아래 매서드를 통해 객체를 가져온다.
	public static SharedObject getInstance() {
		return obj;
	}

	// Thread 에 의해서 고용ㅇ으로 사용되는 Business method 가 필요하다.
	// 2종류의 Thread
	// 생산자(자료구조의 Data를 집어 넣는 일)
	// 소비자(자료구조에서 데이터를 빼내서 화면에 출력하는 일)

	// 생산자 Thread에 의해서 사용되는 method
	public void put(String s) {
		synchronized (MONITOR) {
			list.addLast(s);
			// wait 상태의 Thread 를 꺠운다.
			MONITOR.notify();
		}
	}
	
	// 소비자 Thread에 의해서 사용되는 method
	public String pop() {
		String result = null;

		synchronized (MONITOR) {
			// list 안에 데이터가 있어야 호출가능.
			if (list.isEmpty()) {
				try {
					// list 가 비어있을때 해당 Thread를 기다리게 만든다.
					MONITOR.wait();
					result = list.removeFirst();
				} catch (InterruptedException e) {
				}
			} else {
				result = list.removeFirst();
			}
		}
		return result;
	}
}
