package javaThread;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

// JavaFX 를 이용한 화면 UI 생성
// JavaFX library 가 있어야 한다. => 추가하기. Project -> properties -> Java Build Path
// FX 창 띄우기.
// 1. Application 이라는 class 를 상속받아 우리 class 를 define 한다.
// 2. Application이 갖고있는 start() abstract method를 overriding.
//  

public class Exam00_JAVAFXUITemplate extends Application {

	private TextArea ta;
	private Button btn;

	@SuppressWarnings("unchecked") // 원래는 Generic을 설정해야 하나 이 어노테이션으로 무시.
	@Override
	public void start(Stage primaryStage) throws Exception {
		// 화면을 구성하고 event 처리를 담당.
		// 기본 layout 을 생성.= BorderPane(동서남북중앙으로 구성)으로 생성.
		BorderPane root = new BorderPane();
		// BorderPane의 size를 설정.
		root.setPrefSize(700, 500); // pixel 단위. (가로길이,세로길이)

		ta = new TextArea(); // 글상자 생성.

		root.setCenter(ta); // BorderPane 가운데에 TextArea 부착.

		// 버튼생성
		btn = new Button("버튼클릭");
		btn.setPrefSize(250, 50);
		// Button 을 클릭했을 때 이벤트 처리! Android 와 동일한 방식. 익명클래스 사용.
		// 이벤트 처리시 일반적으로 Java8에서 제공하는 Java Lambda 식을 이용해서 작성한다.
		btn.setOnAction(e -> {
			// System.out.println("버튼이 클릭되었다.");
			// 동기화가 일어나지 않아서 잘못된 결과를 나타낼 수 있다.
			// 직접 UI component 를 제어하는 방법은 좋지 않다.
			// ta.appendText("버튼이 클릭되었다.\n");

			// Thread 를 이용해서 메시지 출력하는 방식으로 이용해야 한다.
			// Platform 객체를 이용.
			Platform.runLater( () -> {
				ta.appendText("버튼이 클릭됨\n");
			}

			);
		});

		// 일반 Panel 하나 생성한다. => LinearLayout처럼 동작하는 Panel.
		FlowPane flowpane = new FlowPane();
		flowpane.setPrefSize(700, 50);
		flowpane.getChildren().add(btn); // FlowPane에 Button 을 부착.

		root.setBottom(flowpane); // 전체 화면의 아래부분에 FlowPane 부착

		// 화면에 보여지기 위해서는 Scene(장면) 이 필요하다.
		Scene scene = new Scene(root); // BorderPane 을 포함하는 장면을 생성.
		primaryStage.setScene(scene); // Window 의 화면을 Scene 으로 설정.
		primaryStage.setTitle("예제용 JavaFX");

		primaryStage.setOnCloseRequest(e -> {
			System.exit(0);
		});

		primaryStage.show(); // 화면에 창 띄우기.

	}

	public static void main(String[] args) {
		// 화면에 창을 띄운다.
		// 원래는 객체를 생성한 후 start() 호출. x
		launch(); // start() method가 호출된다.

	}

}
