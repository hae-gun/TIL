package javanetwork.multiecho.lec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Exam04_CharClient extends Application {

	private TextArea ta;
	private Button connectBtn, logoutBtn; // 서버연결버튼
	private TextField tf, id; // 채팅글 입력상자

	private Socket s;
	private BufferedReader br;
	private PrintWriter pr;

	private ExecutorService executorService = Executors.newCachedThreadPool();

	// Inner class 형태로 작성.(밖에서 해도 되나 코드 처리가 필요함.)
	class ReceiveRunnable implements Runnable {

		private BufferedReader br;

		ReceiveRunnable(BufferedReader br) {
			this.br = br;
		}

		@Override
		public void run() {
			String msg = "";
			try {

				while ((msg = br.readLine()) != null) {
					printMSG(msg);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

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

				String user = id.getText() + " 님이 접속하였습니다.";
				pr.println(user);
				pr.flush();
				onComponent();
				// 입력을 받기위한 Thread를 생성하고 실행.
				ReceiveRunnable r = new ReceiveRunnable(br);
				executorService.execute(r);

				connectBtn.setDisable(true);
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		});
		logoutBtn = new Button("log\nout");
		logoutBtn.setPrefSize(50, 50);
		logoutBtn.setOnAction(e -> {
			
			tf.clear();
			pr.println(id.getText() + " 님이 로그아웃 하였습니다.");
			pr.flush();
			pr.close();
			try {
				br.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			offComponent();
		});
		id = new TextField("아이디입력");
		id.setPrefSize(100, 50);
		
		tf = new TextField();
		tf.setPrefSize(300, 50);
		// 입력상자를 초기에 사용할수 없게 설정.
		tf.setOnAction(e -> {
			String msg = tf.getText();
			String user = id.getText() + ": ";
			pr.print(user);
			if (!msg.equals("@EXIT")) {
				pr.println(msg);
			} else { 
				pr.println("로그아웃 하셨습니다.");
			}
			pr.flush();
			tf.clear();

			if (msg.equals("@EXIT")) {
				offComponent();
				pr.close();
				try {
					br.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

		});
		offComponent();
		FlowPane flowpane = new FlowPane();
		flowpane.setPrefSize(700, 50);
		flowpane.getChildren().add(connectBtn);
		flowpane.getChildren().add(id);
		flowpane.getChildren().add(tf);
		flowpane.getChildren().add(logoutBtn);

		root.setBottom(flowpane);

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Echo Program");

		primaryStage.setOnCloseRequest(e -> {
			System.exit(0);
		});

		primaryStage.show();
	}

	public void onComponent() {
		tf.setDisable(false);
		logoutBtn.setDisable(false);
		id.setDisable(true);
		connectBtn.setDisable(true);
	}

	public void offComponent() {
		tf.setDisable(true);
		logoutBtn.setDisable(true);
		id.setDisable(false);
		connectBtn.setDisable(false);

	}

	public static void main(String[] args) {
		launch();

	}

}
