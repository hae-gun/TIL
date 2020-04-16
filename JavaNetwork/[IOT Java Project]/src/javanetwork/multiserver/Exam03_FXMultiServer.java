package javanetwork.multiserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Exam03_FXMultiServer extends Application {

	private TextArea ta;
	private Button startBtn,stopBtn;
	private Thread t;
	
	public void printMSG(String msg) {
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

		startBtn = new Button("서버시작");
		startBtn.setPrefSize(250, 50);
		startBtn.setOnAction(v -> {
			printMSG("서버구동.");
			t = new Thread(new startServer());
			t.start();
			
		});
		
		stopBtn = new Button("서버중지");
		stopBtn.setPrefSize(250,50);
		stopBtn.setOnAction(e ->{
			printMSG("서버종료");
		});
		
		FlowPane flowpane = new FlowPane();
		flowpane.setPrefSize(700, 50);
		flowpane.getChildren().add(startBtn);
		flowpane.getChildren().add(stopBtn);
		

		root.setBottom(flowpane);

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("서버용 JavaFX");

		primaryStage.setOnCloseRequest(e -> {
			System.exit(0);
		});

		primaryStage.show();
	}

	public static void main(String[] args) {
		launch();

	}

}

class startServer implements Runnable {
	private ExecutorService executeService = Executors.newCachedThreadPool();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			ServerSocket server = new ServerSocket(7878);
			while (true) {
				Socket s = server.accept();
				executeService.execute(new ChatRunnable(s));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}