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
   2. 공용객체 : `SharedObject`
      * 각 Thread가 공유하는 자료구조
      * 이 자료구조를 사용하기 위한 method
      * `Singleton pattern`으로 객체를 작성.
   3. 















