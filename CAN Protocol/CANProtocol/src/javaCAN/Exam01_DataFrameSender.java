package javaCAN;

import java.io.InputStream;
import java.io.OutputStream;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

// JavaFX를 이용하여 구현
public class Exam01_DataFrameSender extends Application {

	private TextArea textarea;
	private Button connBtn, sendBtn, readBtn,settingBtn;

	// Serial 통신을 위한 Field 변수
	private CommPortIdentifier portIdentifier;
	private CommPort commPort;
	private SerialPort serialPort;

	private OutputStream out;
	private InputStream in;

	private void printMsg(String msg) {
		Platform.runLater(() -> {
			textarea.appendText(msg + "\n");
		});
	}

	// comm port 연결하고 출력stream 생성하는 메서드
	private void connectPort(String portName) {
		try {
			portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
			// port 사용중 체크
			if (portIdentifier.isCurrentlyOwned()) {
				System.out.println("다른 프로그램에 의해서 포트가 사용중.");
			} else {
				commPort = portIdentifier.open("PortOpen", 4000);
				if (commPort instanceof SerialPort) {
					serialPort = (SerialPort) commPort;
					serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
							SerialPort.PARITY_NONE);
					// outputStream 생성
					out = serialPort.getOutputStream();
					in = serialPort.getInputStream();
					printMsg("Port 연결 성공");
//					CANListener listener = new CANListener();
					serialPort.addEventListener(new CANListener());
					serialPort.notifyOnDataAvailable(true);
				}

			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// 실제 DataFrame을 전송하는 method
	private void sendDataFrame(String msg) {
		// 데이터 프레임 전송.
		// 프로토콜을 알아야 그 형식대로 message를 만들어서 전송.
		// 전달된 문자열은 Can Protocol 에 맞춰서 만든 문자열이다.
		// CRC를 계산하기 위해서 약간의 처리를 해야한다.
		// "W28000000061100002200000033"
		msg = msg.toUpperCase();
		char c[] = msg.toCharArray();
		int checksumData = 0;

		for (char cc : c) {
			checksumData += cc;
		}
		checksumData = (checksumData & 0xFF);
		// checksumData 의 결과는 정수이다. 이 수를 HexaString으로 변환하여 붙인다.
		// 최종 데이터 프레임
		String sendMsg = ":" + msg + Integer.toHexString(checksumData).toUpperCase() + "\r"; // 0x0d = \r
		printMsg("보내려는 데이터: " + sendMsg);
		byte[] send = sendMsg.getBytes();
		try {
			out.write(send); // 실제 데이터 전송
			printMsg("전송완료");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);

		textarea = new TextArea();
		root.setCenter(textarea);

		connBtn = new Button("COM포트 접속");
		connBtn.setPrefSize(200, 50);
		connBtn.setPadding(new Insets(10));

		connBtn.setOnAction(e -> {
			String PortNum = "COM13";
			connectPort(PortNum);
		});

		sendBtn = new Button("전송");
		sendBtn.setPrefSize(200, 50);
		sendBtn.setPadding(new Insets(10));
		sendBtn.setOnAction(e -> {
			// DataFrame 전송
//			String msg = ":" // canProtocol
//					+ "W" // 보낼데이터라는 의미
//					+ "28" // CAN2.0B, 전송데이터길이 8
//					+ "00000006" // 받을 ID
//					+ "1100002200000033" // 보내는 데이터
//					+ "(계산된값)" //Check Sum(CRC) (Manual 에 계산방법이 있다.) 
//					+ "0x0d" ; //끝문자
			String msg = "W28000000061100002200000033";
			sendDataFrame(msg);

		});

		settingBtn = new Button("Setting");
		settingBtn.setPrefSize(200, 50);
		settingBtn.setPadding(new Insets(10));
		settingBtn.setOnAction(e -> {
			
			String msg = "Z1C" // 수신설정
					+ "0F34" // BPS 250K manual 3페이지
					+ "00000012" // CAN 수신 ID
					+ "00000012"; // CAN수신 MASK
			sendDataFrame(msg);

		});
		readBtn = new Button("Data 수신");
		readBtn.setPrefSize(200, 50);
		readBtn.setPadding(new Insets(10));
		readBtn.setOnAction(e -> {
			
			String msg = "G11";
			sendDataFrame(msg);
			
		});
		

		FlowPane flowpane = new FlowPane();
		flowpane.setPrefSize(700, 50);
		flowpane.setHgap(10);
		flowpane.getChildren().add(connBtn);
		flowpane.getChildren().add(sendBtn);
		flowpane.getChildren().add(settingBtn);
		flowpane.getChildren().add(readBtn);

		root.setBottom(flowpane);

		Scene scene = new Scene(root);

		primaryStage.setScene(scene);
		primaryStage.setTitle("CAN 통신");
		primaryStage.setOnCloseRequest(e -> {
			System.exit(0);
		});

		primaryStage.show();

	}

	public static void main(String[] args) {
		launch();
	}

	class CANListener implements SerialPortEventListener {
		
		@Override
		public void serialEvent(SerialPortEvent arg0) {
			if (arg0.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
				try {

					System.out.println("getdata!!");
					byte[] readBuffer = new byte[128];
					while(in.available()>0) {
						in.read(readBuffer);
					}
					String result = new String(readBuffer);
					printMsg("받은 메세지: "+result);
					if(result.charAt(1)=='Z') {
						printMsg("수신설정완료");
					}
					
				} catch (Exception e) {
					System.out.println(e);
				}
				

			}

		}
	}

}
