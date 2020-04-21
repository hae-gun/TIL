package javanetwork.multiecho.lec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


class EchoRunnable implements Runnable {
	private Socket s;
	private BufferedReader br;
	private PrintWriter pr;

	// constructor injection 이라고 불리는 객체전달(주입)방식
	EchoRunnable(Socket s) {
		this.s = s;
		try {
			this.br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			this.pr = new PrintWriter(s.getOutputStream());
//			SharedObj.getObj().put(this.pr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		// Thread가 클라이언트와 어떻게 동작하는지 이곳에 명시.
		String line = "";
		try {
			
			while ((line = br.readLine()) != null) { // null : 접속이 끊긴 경우.
				if (line.equals("@EXIT")) {
					break;
				}
				
				pr.println(line);
				pr.flush();
			}
			
		} catch (Exception e) {
		}

	}

}

//Server쪽 프로그램.
//javaFX로 구현.
public class Exam03_MultiEchoServer extends Application {

	// 필요한 field 선언
	private TextArea ta;
	private Button startBtn, stopBtn;
	// Thread Pool을 생성(제한된 숫자의 Thread를 가지고 있는 pool이 아니라
	// 필요한 객수만큼 Thread를 가지고 있는 Thread pool을 생성.)
	private ExecutorService excutorService = Executors.newCachedThreadPool();

	// 서버쪽 네트워크 프로그램이니까 ServerSocket이 존재해야 한다.
	ServerSocket server;

	// TextArea에 특정 문자열을 편하게 출력하기 위해서 하나의 method를 만들어서 사용한다.
	private void printMSG(String msg) {
//		 TextArea에 출력하기 위해서 Thread를 이용해야 한다.
//		Platform.runLater(new Runnable(){
//			@Override
//			public void run() {
//				ta.appendText(msg + "\n");
//			}
//		});
//		-> lambda 식으로 변환
		Platform.runLater(() -> {
			ta.appendText(msg + "\n");
		});

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// 처음 창이 화면에 뜰때 화면구성하는 용도로 사용.
		// 화면을 동서남북중앙으로 구성하는 BorderPane을 이용.
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);

		// TextArea를 생성해서 BorderPane의 중앙에 부착.
		ta = new TextArea();
		root.setCenter(ta);

		// 두개의 버튼을 각각 생성해서 화면에 부착.
		startBtn = new Button("Echo Server 시작");
		startBtn.setPrefSize(150, 40);
		startBtn.setOnAction(e -> {
			// Event 처리코드
			printMSG("[서버시작]");
			// 별도의 Thread를 만들어서 서버역할을 수행해야 한다.
			// Runnable interface를 구현한 객체를 만들어서
			// ExecutorService(Thread Pool)을 이용하여 Thread를 실행.
			Runnable runnable = () -> {
				try {
					server = new ServerSocket(9999);
					while (true) {
						Socket s = server.accept();
						// 클라이언트와 연결된 소켓 s를 가지고 별도의 Thread가 실행.
						// Thread를 실행시키는 코드가 나오면 된다.
						
//						SharedObj obj = SharedObj.getObj();
						EchoRunnable r = new EchoRunnable(s);
						
//						obj.put(r);
						
						excutorService.execute(r);

						printMSG("[새로운 클라이언트 접속]");
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			};

			excutorService.execute(runnable); // Thread 실행.
			startBtn.setDisable(true);
		});

		stopBtn = new Button("Echo Server 중지");
		stopBtn.setPrefSize(150, 40);
		stopBtn.setOnAction(e -> {
			// Event 처리코드
			startBtn.setDisable(false);
			System.exit(0);
		});

		// Android 의 LinearLayout과 유사한 component
		FlowPane flowpane = new FlowPane();
		flowpane.setPrefSize(700, 40);
		// 위아래좌우 Insets 객체를 이용하여Padding 설정
		flowpane.setPadding(new Insets(10, 10, 10, 10));
		// 간격설정
		flowpane.setHgap(10);
		// 버튼 부착
		flowpane.getChildren().add(startBtn);
		flowpane.getChildren().add(stopBtn);
		// 판 부착
		root.setBottom(flowpane);

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("서버용 JavaFX");

		primaryStage.setOnCloseRequest(e -> {

		});

		primaryStage.show();

	}

	public static void main(String[] args) {
		launch();
	}
}
