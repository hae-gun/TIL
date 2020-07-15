package javanetwork.multiecho.lec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Exam03_MultiEchoClient extends Application {

	private TextArea ta;
	private Button connectBtn; // 서버연결버튼
	private TextField tf; // 채팅글 입력상자

	private Socket s;
	private BufferedReader br;
	private PrintWriter pr;

	public void printMSG(String msg) {
		Platform.runLater(() -> {
			ta.appendText(msg + "\n");
		}

		);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);

		ta = new TextArea();
		root.setCenter(ta);

		connectBtn = new Button("서버에 접속");
		connectBtn.setPrefSize(250, 50);
		connectBtn.setOnAction(e -> {
			// 연결되면 TextArea 내용 초기화.
			ta.clear();
			try {
				s = new Socket("localhost", 9999);
				printMSG("서버 접속성공");
				br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				pr = new PrintWriter(s.getOutputStream());
				// 접속 성공후 입력상자 활성화
				tf.setDisable(false);
				connectBtn.setDisable(true);
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		});

		tf = new TextField();
		tf.setPrefSize(400, 50);
		// 입력상자를 초기에 사용할수 없게 설정.
		tf.setDisable(true);
		
		tf.setOnAction(e -> {
			String msg = tf.getText();
			pr.println(msg);
			pr.flush();
			tf.clear();
			
			if(!msg.equals("@EXIT")) {
				try {
					String revString = br.readLine();
					printMSG(revString);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}else {
				printMSG("[서버와의 연결 종료]");
				connectBtn.setDisable(false);
				tf.setDisable(true);
			}
		});


		FlowPane flowpane = new FlowPane();
		flowpane.setPrefSize(700, 50);
		flowpane.getChildren().add(connectBtn);
		flowpane.getChildren().add(tf);

		root.setBottom(flowpane);

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Echo Program");

		primaryStage.setOnCloseRequest(e -> {
			System.exit(0);
		});

		primaryStage.show();
	}

	public static void main(String[] args) {
		launch();

	}

}
