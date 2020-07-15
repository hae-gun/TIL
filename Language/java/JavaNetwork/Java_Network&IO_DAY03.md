# 2020-04-10

# Thread Day03

## Thread Interrupt

* 자바에서 예전에는 `stop()` 매서드를 이용하여 Thread 를 종료시켰으나, stop() 매서드는 문제가 많아 현재는 duplicate 상태이다.
* stop() 매서드 대체로 나온 매서드가 바로 `interrupt()` 매서드 이다.

### 동작원리

* `interrupt()` 매서드가 수행이 되면 이 매서드는 해당 Thread 에 `interrupt`  표시를 남기게 된다.
* 이러한 표시가 남은 상태에세 해당 Thread 가 sleep() 상태로 되면 sleep() 매서드가 포함된 try~catch 문에서 Exception 이 발생한다.
* 그러므로 catch 문에 로직을 입력하여 Thread 를 종료하는 방식으로 프로그램을 작성할 수 있다.

> 종료하고 싶은 Thread 의 interrupt() 매서드를 이용하여 Thread를 종료하고 싶을 때 Exception의 catch 문에서 종료하는 로직을 작성하지 않으면 해당 Thread 는 종료되지 않는다.

```java
// 생략 .. 
startBtn.setOnAction(e -> {
			// 버튼클릭으로 Thread 를 생성해서 동작시키는 코드
			countTread = new Thread(() -> {
				// run() 의 작성
				// 1~100 숫자 1초마다 출력
				for (int i = 0; i < 100; i++) {
					// sleep 은 반드시 예외처리가 필요하다.
					try {
						Thread.sleep(1000);
						// sleep() 이 수행되었을 떄 만약 해당 Thread가 interrupt 가 표시되어있으면
						// Exception 이 발생한다.
						printMSG(i + " 출력");
					} catch (InterruptedException e1) {
						break;
					}
				}
			});
			countTread.start();
		});
// 생략 .. 
stopBtn.setOnAction(e -> {
			// 과거에는 stop() method를 이용해서 Thread를 중지시킴. 문제가 많다.
			// stop method 는 duplicate 됨.
			countTread.interrupt();
			// Thread 에 interrupt 가 수행되었따는 "표시" 를 한다.
			// 

		});
// 생략 .. 
```

## Thread Daemon

* Thread 중지와 관련된 개념.

* `Thread` 객체에 `setDaemone(boolean)` 매서드를 사용하면 해당 Thread를 Daemon Thread로 만들수 있다.

* Daemon Thread 는 해당 Thread 를 파생시킨 Thread (상위 Thread) 가 종료되면 함께 종료된다.

  ```java
  package javaThread;
  
  import javafx.application.Application;
  import javafx.application.Platform;
  import javafx.scene.Scene;
  import javafx.scene.control.Button;
  import javafx.scene.control.TextArea;
  import javafx.scene.layout.BorderPane;
  import javafx.scene.layout.FlowPane;
  import javafx.stage.Stage;
  
  public class Exam06_ThreadDaemon extends Application {
  
  	private TextArea ta;
  	private Button startBtn, stopBtn;
  	private Thread countThread;
  
  	// TextArea 에 문자열을 출력하기 위한 method 를 하나 만들기.
  	private void printMSG(String msg) {
  		Platform.runLater(() -> {
  			ta.appendText(msg + "\n");
  		});
  
  	}
  
  	@SuppressWarnings("unchecked")
  	@Override
  	public void start(Stage primaryStage) throws Exception {
  		BorderPane root = new BorderPane();
  		root.setPrefSize(700, 500);
  
  		ta = new TextArea();
  		root.setCenter(ta);
  
  		startBtn = new Button("Thread 시작");
  		startBtn.setPrefSize(250, 50);
  		startBtn.setOnAction(e -> {
  			// 버튼클릭으로 Thread 를 생성해서 동작시키는 코드
  			countThread = new Thread(() -> {
  				// run() 의 작성
  				// 1~100 숫자 1초마다 출력
  				for (int i = 0; i < 100; i++) {
  					// sleep 은 반드시 예외처리가 필요하다.
  					try {
  						Thread.sleep(1000);
  						// sleep() 이 수행되었을 떄 만약 해당 Thread가 interrupt 가 표시되어있으면
  						// Exception 이 발생한다.
  						printMSG(i + " 출력");
  					} catch (InterruptedException e1) {
  						break;
  					}
  				}
  			});
  			countThread.setDaemon(true); // 해당 Thread 를 Daemon Thread 로 셋팅.
  			// Daemon Thread 는 해당 Thread를 파생시킨 Thread(상위 Thread)가 종료가 되면 함께 종료된다.
  			// 자신을 생성한 Thread 가 종료되면 자신도 같이 종료.
  			countThread.start();
  		});
  
  		stopBtn = new Button("Thread 중지");
  		stopBtn.setPrefSize(250, 50);
  		stopBtn.setOnAction(e -> {
  			// 과거에는 stop() method를 이용해서 Thread를 중지시킴. 문제가 많다.
  			// stop method 는 duplicate 됨.
  			printMSG("죵료");
  			countThread.interrupt();
  			// Thread 에 interrupt 가 수행되었따는 "표시" 를 한다.
  
  		});
  
  		FlowPane flowpane = new FlowPane();
  		flowpane.setPrefSize(700, 50);
  		flowpane.getChildren().add(startBtn);
  		flowpane.getChildren().add(stopBtn);
  
  		root.setBottom(flowpane);
  
  		Scene scene = new Scene(root);
  		primaryStage.setScene(scene);
  		primaryStage.setTitle("Thread Interrupt 예재");
  
  		primaryStage.setOnCloseRequest(e -> {
  			// 이창의 x버튼을 눌렀을 때 해야하는 일을 작성.
  			//System.exit(0); // 내부에 있는 모든 Thread 를 강제종료시켜서 전체 프로그램을 종료
  			
  		});
  
  		primaryStage.show(); // 화면에 창 띄우기.
  
  	}
  
  	// program 의 entry point
  	public static void main(String[] args) {
  		launch();
  
  	}
  
  }
  
  ```

  > 위의 예제에서는 countThread 는 버튼클릭 이벤트에 속해있음. 정확이 말하면 main문에서 JavaFX Thread에 포함되어진 상태. 따라서 해당 UI 창에서 x 버튼을 눌러 종료하게되면 counThread 도 함께 종료된다. 
  >
  > 사실상 javaFX setOnCloseRequest 매서드의 이벤트처리에서 `System.exit(0)` 로도 프로그램 종료가 가능하지만 이러한 방법은 프로그램을 강제적으로 종료시키는 방법이라 매우 좋지 않은 방법이다.

  



---

# Thread 이용한 예제

## 생산자, 소비자 (Producer & Consumer problem)

* 생상자
  * 1개의 Thread
  * 무언가를 지속적으로 생성하는 역할을 하는 Thread
  * 숫자를 0부터 1씩 증가해서 계속 만들어내는 역할.
  * 만들어진 숫자를 공용객체에 저장. => `ArrayList` 계열을 이용. (`LinkedList 사용`)
* 소비자
  * 3개의 Thread
  * 공용객체에 접근하여 3개의 Thread가 숫자를 하나씩 꺼내 사용. ( 사용후 제거 )



1. 구성

   1. Main Thread : `ProConTest`

      ```java
      package javaThread.procon;
      
      public class ProConTest {
      
      	public static void main(String[] args) {
      
      		// 1. Data 에 대한 동기화 처리가 있어야 한다.
      		// 공유객체를 하나 만들어야 한다.
      		// 공유객체를 만들때 이 객체가 가지고 있어야 할 자료구조 생각
      		// 이 자료구조를 각 Thread 를 이용할때 method를 이용해야 한다.
      		// 어떤 method 가 필요한지를 생각해야 한다.
      		//
      		SharedObject obj = SharedObject.getInstance();
      
      		// 2. 4개의 Thread를 생성해야 한다.
      		// 1개의 Producer와 3개의 Consumer Thread를 생성.
      		// class를 define해야 한다.
      		Thread producer = new Thread(new Producer(obj));
      		Thread con1 = new Thread(new Consumer(obj));
      		Thread con2 = new Thread(new Consumer(obj));
      		Thread con3 = new Thread(new Consumer(obj));
      		
      		// 3. 각 Thread를 시작.
      		con1.start();
      		con2.start();
      		con3.start();
      		
      		producer.start();
      		
      		try {
      			Thread.sleep(2); // Main Thread 잠깐 쉬기.
      			producer.interrupt();
      			Thread.sleep(2); 
      			con1.interrupt();
      			con2.interrupt();
      			con3.interrupt();
      		} catch (Exception e) {
      			
      		}
      	}
      }
      ```

      

   2. 공용객체 : `SharedObject`

      * 각 Thread가 공유하는 자료구조.
      * 이 자료구조를 사용하기 위한 method.
      * 여러개의 객체가 이 객체 1개를 `Singleton pattern`으로 객체를 작성. 
      * 해당 class는 공용으로 사용할 데이터 또한 갖고 있어야 하며 이 데이터를 다룰 method 또한 필요하다.

      ```java
      package javaThread.procon;
      
      import java.util.LinkedList;
      
      // ShareObjec.java => 공용객체를 만들기 위한 class
      // 각 Thread 가 공유하는 자료구조.
      // 공유객체는 여러개가 필요없다.. 1개만 존재해야함.
      // 이 1개의 공유객체를 여러개의 Thread 가 공유해서 사용.
      // => Singleton pattern으로 작성.
      
      public class SharedObject {
      
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
      		list.addLast(s);
      	}
      
      	// 소비자 Thread에 의해서 사용되는 method
      	public String pop() {
      		String result = null;
      		result = list.removeFirst();
      		return result;
      	}
      
      }
      
      ```

      

   3. 생산자와 소비자 객체.

      * Runnable interface 를 구현한 class로 생성자 Thread를 만들기위해 정의.
      * 두 객체 모두 공용객체(`SharedObject`)를 갖고 있는 형태의 객체로 정의.

      * 생산자

      ```java
      package javaThread.procon;
      
      public class Producer implements Runnable {
      
      	private SharedObject obj;
      
      	Producer() {
      	}
      
      	Producer(SharedObject obj) {
      		this.obj = obj;
      	}
      
      	@Override
      	public void run() {
      		// 생성자 Thread 가 하는일을 여기에 명시.
      		System.out.println("생성자 Thread 시작");
      		int i = 1;
      		while (true) {
      			if (Thread.currentThread().isInterrupted()) {
      				break;
      			}
      			obj.put(new Integer(i++).toString());
      		}
      		System.out.println("Producer 종료");
      	}
      
      }
      
      ```

      * 소비자

      ```java
      package javaThread.procon;
      
      public class Consumer implements Runnable {
      
      	private SharedObject obj;
      
      	Consumer() {
      	}
      
      	Consumer(SharedObject obj) {
      		this.obj = obj;
      	}
      
      	@Override
      	public void run() {
      		System.out.println(Thread.currentThread().getName() + " Consumer 시작");
      
      		// 반복적으로 공용객체(obj)가 가지고 있는 데이터를 뽑아내서 출력
      		while (true) {
      			if (Thread.currentThread().isInterrupted()) {
      				break;
      			}
      			System.out.println(Thread.currentThread().getName() + " - " + obj.pop());
      		}
      		System.out.println(Thread.currentThread().getName() + "- 종료");
      	}
      
      }
      
      ```

      ![image-20200410143714234](Java_Network&IO_DAY03.assets/image-20200410143714234.png)

> 위와 같은 코드는 동기화를 진행하지 않아실행하면 오류가 발생한다.
>
> 시작되는 Thread 순서에 따라 결과가 다르게 나온다.
>
> 동기화가 필요한 부분은 SharedObject 내에서 진행해준다.

* 동기화가 필요한 부분.

  * 동기화를 위해 Field 에 Monitor 로 사용할 객체를 선언.
  * `SharedObject` 객체에서 `pop()` 매서드를 진행할때 list가 비어있으면 안됨.
  * 따라서 `pop()` 매서드 내에서list가 비어있을때 해당 Thread(Consumer) 를 `wait()` 을 이용해 blocked 상태로 만듬.
  * list 에 `put()` 매서드를 이용하여 데이터를 넣을때 `notify()`를 이용해 blocked 상태의 Thread를 깨워주는 식으로 진행.

  ```java
  public class SharedObject {
  
  	private static final Object MONITOR = new Object();
      // 생략....
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
  ```

  







> 이클립스로 Git repository 보내기.
>
> 1. 올리기 (push)
>    1. Eclipse 에서 해당 project -> Team -> Share Project
>    2. Create 클릭하여 local repository 를 새롭게 지정.
>    3. commit 을 진행.
>    4. Team - Remote - Push 에 생성한 git URI 를 입력하여 push를 진행.
>
> 2. 내려받기 (pull)
>    1. 빈 Eclipse 에서 Import projects -> Git ->  Project from Git
>    2. Clone URI를 선택.
>    3. 주소입력

































