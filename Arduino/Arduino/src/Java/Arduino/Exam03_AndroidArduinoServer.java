package Java.Arduino;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Exam03_AndroidArduinoServer extends Application {

	private TextArea ta;
	private Button btn;
	private ServerSocket server;
	private BufferedReader br;
	private PrintWriter pr;
	private BufferedWriter bw; // 아두이노에게 출력하기위한 스트림.
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

		btn = new Button("서버기동");
		btn.setPrefSize(250, 50);
		btn.setOnAction(e -> {
			// ServerSocket을 생성하고 Android로부터 데이터를 받는다.
			// Thread로 만들어 줘야 한다.
			Runnable r = new Runnable() {

				@Override
				public void run() {
					try {
						server = new ServerSocket(1234);
						printMSG("[서버소켓 기동]");
						Socket s = server.accept();
						printMSG("[클라이언트 접속]");
						br = new BufferedReader(new InputStreamReader(s.getInputStream()));
						pr = new PrintWriter(s.getOutputStream());
						String msg = "";
						while (true) {
							if ((msg = br.readLine()) != null) {
								if (msg.equals("LED_ON")) {
									printMSG("Turn On");
									// 아두이노와의 스트림을 통해 데이터를 보내줌.
									// 보낼때 Size를 잡아줘야 한다.(0번째(처음) 부터 길이(msg.length)만큼)
									bw.write(msg, 0, msg.length());
									bw.flush();
								}
								if (msg.equals("LED_OFF")) {
									printMSG("Turn Off");
									bw.write(msg, 0, msg.length());
									bw.flush();

								}
							} else {
								break;
							}
						}

					} catch (Exception e2) {
						System.out.println(e2);
					}
				}
			};

			Thread t = new Thread(r);
			t.start();

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

		// 아두이노와 SerialPort 연결하는 코드를 작성.

		CommPortIdentifier portIdentifier = null;
		try {
			portIdentifier = CommPortIdentifier.getPortIdentifier("COM8");

			if (portIdentifier.isCurrentlyOwned()) {
				System.out.println("포트가 사용중입니다...");
			} else {
				CommPort commPort = portIdentifier.open("PORT_OPEN", 2000);

				if (commPort instanceof SerialPort) {
					SerialPort serialPort = (SerialPort) commPort;
					serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
							SerialPort.PARITY_NONE);
					InputStream in = serialPort.getInputStream();
					OutputStream out = serialPort.getOutputStream();

					// 데이터 보내려고 한다.
					// BufferedWriter 스트림을 이용!
					bw = new BufferedWriter(new OutputStreamWriter(out));
					
//					Thread t2 = new Thread(new Runnable() {
//						@Override
//						public void run() {
//							byte[] buffer = new byte[1024];
//							// 받은 바이트 길이를 저장하기 위한 변수.
//							int len = -1;
//							try {
//								while ((len = in.read(buffer)) != -1) {
//									// 아두이노에서 보낸 데이터를 읽을때 바이트 단위로 들어와서 얼마나 들어오는지 알 수 없다.
//									if(len>1)
//									printMSG(new String(buffer, 0, len));
//								}
//							} catch (Exception e) {
//								System.out.println(e);
//							}
//
//						}
//
//					});
//					t2.start();
					serialPort.addEventListener(new SerialListener2(in));
					serialPort.notifyOnDataAvailable(true);

				} else {
					System.out.println("Serial Port만 이용가능합니다...");
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		launch();

	}

	class SerialListener2 implements SerialPortEventListener {
		
		private InputStream in;
		private BufferedReader br;
		
		SerialListener2(InputStream in) {
			this.in = in;
		}
		
		@Override
		public void serialEvent(SerialPortEvent arg0) {
			// 이벤트가 발생하면 호출되는 method
			if (arg0.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
				try {
					// 전달되는 데이터의 크기가 리턴되어 k에 저장됨.
					int k = in.available();
//					String s = br.readLine();
					byte[] data = new byte[k];
					// 읽어서 byte 배열에 저장
					String s="";
					in.read(data, 0, k);
					if(!(new String(data)).equals("\n")) {
						s = new String(data);
					}
					System.out.println("받은메세지 : " + s);
					
					pr.println(s);
					pr.flush();
					
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
		
	}
}
