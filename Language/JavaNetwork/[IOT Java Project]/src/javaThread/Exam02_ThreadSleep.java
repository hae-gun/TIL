package javaThread;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

 

public class Exam02_ThreadSleep extends Application {

	private TextArea ta;
	private Button btn;

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

		btn = new Button("버튼클릭");
		btn.setPrefSize(250, 50);
		// Button 을 누르면 Thread 를 5개 생성.
		// 각 Thread 는 1초 sleep 하면서 숫자를 하나 출력.
		btn.setOnAction(e -> {

			// 5개의 Thread 생성 -> for 문이용
			for (int i = 0; i < 5; i++) {
				// Lambda 식 이용.
				Thread t = new Thread(() -> {
					
					try {
						for (int k = 0; k < 3; k++) {
							Thread.sleep(1000);
							printMSG(k + "-" + Thread.currentThread().getName());
						}
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					
					
				});
				t.start();
			}
		});

		FlowPane flowpane = new FlowPane();
		flowpane.setPrefSize(700, 50);
		flowpane.getChildren().add(btn);

		root.setBottom(flowpane);

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("예제용 JavaFX");

		primaryStage.setOnCloseRequest(e -> {
			System.exit(0);
		});

		primaryStage.show(); 
	}

	public static void main(String[] args) {
		
		launch(); 

	}

}
