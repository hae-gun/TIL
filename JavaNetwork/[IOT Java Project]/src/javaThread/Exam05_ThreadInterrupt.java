package javaThread;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Exam05_ThreadInterrupt extends Application {

	private TextArea ta;
	private Button startBtn, stopBtn;
	private Thread countTread;

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

		stopBtn = new Button("Thread 중지");
		stopBtn.setPrefSize(250, 50);
		stopBtn.setOnAction(e -> {
			// 과거에는 stop() method를 이용해서 Thread를 중지시킴. 문제가 많다.
			// stop method 는 duplicate 됨.
			printMSG("죵료");
			countTread.interrupt();
			// Thread 에 interrupt 가 수행되었따는 "표시" 를 한다.
			// 

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
			System.exit(0); // 내부에 있는 모든 Thread 를 강제종료시켜서 전체 프로그램을 종료
		});

		primaryStage.show(); // 화면에 창 띄우기.

	}

	// program 의 entry point
	public static void main(String[] args) {
		launch();

	}

}
