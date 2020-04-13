package javaThread;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class Exam00_JAVAFXUITemplateNone extends Application {

	private TextArea ta;
	private Button btn;

	@SuppressWarnings("unchecked") 
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500); 

		ta = new TextArea(); 
		root.setCenter(ta); 

		btn = new Button("버튼클릭");
		btn.setPrefSize(250, 50);
		btn.setOnAction(e -> {
			Platform.runLater( () -> {
				ta.appendText("버튼이 클릭됨\n");
			}

			);
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
