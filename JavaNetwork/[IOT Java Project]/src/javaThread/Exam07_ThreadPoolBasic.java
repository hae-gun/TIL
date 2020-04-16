package javaThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/* 
 * Pool 개념
 * Java 는 필요한 객체를 생성하고(new) -> Heap 영역에 메모리가 할당된다.
 * 메모리를 이용해서 여러가지 처리를 한다. (데이터 저장, method호출을 통해 로직처리)
 * 객체를 다 사용하고 더 이상 사용하지 않으면 Garbage collector 가 사용하지 않는 객체를 메모리에서 제거.
 * 
 * 이런 일반적인 방식은 효율면에서 좋지 않다. 
 * 사용할 객체를 일단 미리 많이 생성해서 모아놓는다. pool 이라고 불리는 공간에 모아놓는다.
 * 필요할때마다 Pool 안에서 객체를 가져다가 사용한다. 
 * 객체를 사용한 후 사용이 끝나면 다시 Pool 에 반납하는 방식으로 사용.
 * 
 * 가장 대표적인 활용 -> Database Connection Pool (DBCP)
 * 				    Object Pool
 * 				    Thread Pool
 * 
 * Thread 를 사용할 떄 Thread t = new Thread(); 여러 사람이 이용할 떄는 효율이 좋지않다.
 * 이러한 방식이 아닌 Thread Pool을 이용하여 처리해 보자.
 * ExecutorService 라는 이름의 Thread Pool을 용한다.
 *  
 * */

public class Exam07_ThreadPoolBasic extends Application {

	private TextArea ta;
	private Button initBtn, startBtn, shutdownBtn;
	// init : Thread Pool 생성
	// start : Thread Pool 안에서 Thread를 가져다가 사용하는 버튼.
	// shutdown : Thread Pool 종료
	private ExecutorService executeService;

	// textarea에 문자열을 출력하기 위한 method
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

		initBtn = new Button("Thread Pool 생성");
		initBtn.setPrefSize(700 / 3, 50);
		initBtn.setOnAction(e -> {
			// java lambda를 이용한 event 처리 코드 작성.
			// 새롭게 Thread Pool 을 만드는 과정. 숫자는 Thread의 최대 갯수.
			//executeService = Executors.newFixedThreadPool(5);
			// CachedThreadPool : 시스템이 허용하는 만큼 Thread를 만들어 낸다.
			executeService = Executors.newCachedThreadPool();
			// ThreadPoolExecutor 로 casting 을 한후 PoolSize를 알아낼 수 있다.
			// execulteService 자체가 interface이기 떄문이다.
			printMSG("Pool 안의 Thread 개수 : " + ((ThreadPoolExecutor) executeService).getPoolSize());
		});

		startBtn = new Button("Thread 생성");
		startBtn.setPrefSize(700 / 3, 50);
		startBtn.setOnAction(e -> {
			// Thread Pool 에서 Thread 를 가져다가 사용하는 코드
			// 10개의 Thread를 Thread pool 에서 가져다가 사용해 보자.
			for (int i = 0; i < 10; i++) {
				// 1. Runnable Interface 구현한 객체를 생성.
				// 2. Thread Pool 을 이용하여 Thread 생성.
				Runnable runnable = new Runnable() {
					@Override
					public void run() {
						String msg  = "Thread Pool 안의 개수: " + 
								((ThreadPoolExecutor) executeService).getPoolSize();
						msg += ", Thread Name : " + Thread.currentThread().getName();
						printMSG(msg);
						
					}
				};
				// Thread 실행방법.
				// Thread t = new Thread(runnable); 
				// t.start(); 와 같은 방식.
				executeService.execute(runnable);
				// new Thread() 로 Thread를 생성하서 만드는 방식보다
				// Thread Pool을 이용하는게 일반적인 방식이다.
			}

		});

		shutdownBtn = new Button("Thread Pool 종료");
		shutdownBtn.setPrefSize(700 / 3, 50);
		shutdownBtn.setOnAction(e -> {
			// java lambda를 이용한 event 처리 코드 작성.
			executeService.shutdownNow();
			printMSG("Thread Pool 종료");
		});

		FlowPane flowpane = new FlowPane();
		flowpane.setPrefSize(700, 50);
		flowpane.getChildren().add(initBtn);
		flowpane.getChildren().add(startBtn);
		flowpane.getChildren().add(shutdownBtn);

		root.setBottom(flowpane);

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("예제용 JavaFX");

		primaryStage.setOnCloseRequest(e -> {

		});

		primaryStage.show();
	}

	public static void main(String[] args) {
		launch();

	}

}