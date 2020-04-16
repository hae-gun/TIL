package javanetwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Exam01_DateClient extends Application {

	private TextArea ta,ta2;
	private Button btn;
	private final double textHeight = 25; 
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
		ta2 = new TextArea();
		ta2.setPrefSize(450, textHeight);
		root.setCenter(ta);
		

		btn = new Button("전  송");
		btn.setPrefSize(250, textHeight);
		btn.setOnAction(e -> {
			// 1. 클라이언트는 능동적으로 서버에 접속한다.
			// ServerSocket에 접속
			try {
				
				Socket s = new Socket("localhost", 5556);
				String data = ta2.getText();
				ta2.setText("");
				
				PrintWriter pw = new PrintWriter(s.getOutputStream());
				
				pw.println(data);
				pw.flush();
				
				BufferedReader br = 
						new BufferedReader(
								new InputStreamReader(
										s.getInputStream()));
				
				String msg = br.readLine();
				printMSG(msg);
				
				// 처리가 끝나면 Stream을 닫고 Socket을 닫는다.
				pw.close();
				br.close();
				s.close();
				
				if(msg.equals("@EXIT")) {
					System.exit(0);
				}
				
				
			} catch (UnknownHostException e1) {
			} catch (IOException e1) {
			}
		});

		FlowPane flowpane = new FlowPane();
		flowpane.setPrefSize(700, 50);
		flowpane.getChildren().add(ta2);
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
