package javaIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Exam02_Notepad extends Application {

	private TextArea ta;
	private Button oepnBtn, saveBtn;

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

		oepnBtn = new Button("파일열기");
		oepnBtn.setPrefSize(250, 50);
		oepnBtn.setOnAction(e -> {
			// 파일열기 처리.
			// 1. textarea를 초기화.
			ta.clear();
			// 2. Open할 파일을 선택. => File Chooser를 이용.
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Open할 파일 선택");
			// 창을 띄움 매개변수 : primaryStage (javaFx에서 사용하는 방식.)
			// 파일 선택창에서 원하는 file을 선택한 후 open버튼을 누르면
			// File 객체가 생성.
			File file = fileChooser.showOpenDialog(primaryStage);
			// Open 할 File을 선택했으면..
			try {
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				String line = "";

				while ((line = br.readLine()) != null) {
					printMSG(line);
				}

			} catch (FileNotFoundException e1) { // file에 대한 Exception
			} catch (IOException e1) { // readLine에 대한 Exception
			}

		});

		saveBtn = new Button("파일저장");
		saveBtn.setPrefSize(250, 50);
		saveBtn.setOnAction(e -> {

		});

		FlowPane flowpane = new FlowPane();
		flowpane.setPrefSize(700, 50);
		flowpane.getChildren().add(oepnBtn);
		flowpane.getChildren().add(saveBtn);

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
