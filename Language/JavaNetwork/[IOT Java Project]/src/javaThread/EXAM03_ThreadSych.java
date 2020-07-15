package javaThread;

// 공유객체를 만들기 위한 class. 일반적으로 Singleton 으로 작성.
class SharedoObject {
	// Thread가 공유해서 사용하는 공유객체는
	// Thread가 사용하는 데이터와 로직을 포함하고 있다.
	private int number;
	private Object monitor = new Object(); // monitor 용 객체. 객체만 있으면됨.
	// Thread에 의해서 공유되는 field.
	// 일반적으로 private으로 처리되기 때문에 이 field 를 이용하기 위해 Setter,Getter 가 필요함.

	public int getNumber() {
		return number;
	}

	// 1번째 해결방법은 method 호출을 순차적으로 처리하면 된다.
	// 각 Thread 가 갖고 있는 공유객체의 method호출을 순차적으로 호출하게끔 처리. synchronized keyword 이용
	// method 자체가 동기화 처리가 되서 프로그래밍 하기는 쉽다.
	// 해당 method의 실행이 만약 오래걸리게 되면 performance 에 문제가 발생한다.
	// 전체 method를 동기화 하는것이 아닌 필요한 부분만 동기화 처리를 한다.
	public void setNumber(int number) {
		System.out.println("소리없는 아우성");
		
		synchronized (monitor) { // block 의 인자 : Monitor객체
			this.number = number;
			try {
				// 현재 공유객체를 사용하는 Thread를 1초간 재워요!
				Thread.sleep(1000);
				System.out.println("현재 number : " + getNumber());
			} catch (Exception e) {}
		}
		
	}

}

class NumberRunnable implements Runnable {

	private SharedoObject obj;
	private int number;

	// 기본생성자는 항상 존재해야 한다.
	NumberRunnable() {

	}

	// 공유객체를 받아들여서 저장하는 생성자를 작성한다.
	// Constructor injection
	NumberRunnable(SharedoObject obj, int number) {
		this.obj = obj;
		this.number = number;
	}

	@Override
	public void run() {
		// 공유객체가 가지는 기능을 이용해서 숫자를 출력
		obj.setNumber(number);
	}
}

public class EXAM03_ThreadSych {

	// 프로그램 entry point
	public static void main(String[] args) {

		// Thread 에 의해 공유되는 공유객체 1개 생성
		// 일반적으로 공유객체는 class 로부터 객체가 딱 1개만 생성되는 형태로 만들어진다.
		// => Singleton Pattern
		// Thread 는 로직처리를 공유객체를 이용해서 로직처리를 하고
		// 데이터 처리 역시 공유객체를 통해서 처리한다.
		// 공유객체를 만들기 위한 class define

		// Thread 에 의해서 공유되는 객체를 하나 생성
		SharedoObject obj = new SharedoObject();

		// Thread 를 생성하기 위해서 Runnable interface 를 구현한 객체가 있어야한다.
		// 그래서 "Runnable interface" 를 구현할 객체를 만들기위한 class define.
		NumberRunnable r1 = new NumberRunnable(obj, 100);
		NumberRunnable r2 = new NumberRunnable(obj, 200);

		// Thread 2개를 생성.
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);

		// Thread 시작.
		t1.start();
		t2.start();

	}

}
