package Arduino.sensor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import com.google.gson.Gson;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

// 이벤트를 처리하는 리스너 객체를 만들기위한 class를 정의.

public class Exam02_ArduinoSerialUsingEvent {

	public static void main(String[] args) {
		Socket s;
		BufferedReader serverBr = null;
		PrintWriter serverPr = null;
		String withArduino = "";

		try {
			s = new Socket("localhost", 7575);
			serverBr = new BufferedReader(new InputStreamReader(s.getInputStream()));
			serverPr = new PrintWriter(s.getOutputStream());
//			Thread t = new Thread(new serverConnect(s, serverBr, serverPr));
//			t.start();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		CommPortIdentifier portIdentifier = null;
		try {
			// 1. Serial 통신을 하기 위한 COM 포트 설정.
			// 아두이노의 포트번호를 가져옴.
			portIdentifier = CommPortIdentifier.getPortIdentifier("COM10");

			// 2. 포트가 사용되고 있는지 확인해야 한다.
			if (portIdentifier.isCurrentlyOwned()) {
				System.out.println("포트가 사용중입니다...");
			} else {
				// 인자 2개 : (identifier) 문자열, int
				// Port 객체를 얻어온다.
				CommPort commPort = portIdentifier.open("PORT_OPEN", 2000);

				// Port객체를 얻어온 후 우리가 사용하려고 하는 Port 는 SerialPort 이다.
				// Port 에는 ParallelPort도 있다.
				if (commPort instanceof SerialPort) {
					// SerialPort 로 형변환 (type casting)
					SerialPort serialPort = (SerialPort) commPort;
					// 포트 설정 (통신속도같은걸 설정)
					// 첫번째 : 보드레이트
					// 나머지는 정해져 있는것들 이용.
					serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
							SerialPort.PARITY_NONE);
					// 데이터 통신을 하기 위해서 Stream을 연다.
					InputStream in = serialPort.getInputStream();
					OutputStream out = serialPort.getOutputStream();

					BufferedReader arduinoBr = new BufferedReader(new InputStreamReader(in));
					PrintWriter arduinoPr = new PrintWriter(out);

					// 각각 동작할 Runnable 객체들
					FromArduino fromArduino = new FromArduino(arduinoBr, serverPr);
//					FromArduino fromArduino = new FromArduino(in, serverPr);
					ToArduino toArduino = new ToArduino(serverBr, arduinoPr);

					Thread FromArdu = new Thread(fromArduino);
					Thread ToArdu = new Thread(toArduino);

//					Thread t = new Thread(new Runnable() {
//						@Override
//						public void run() {
//							System.out.println("Runnable 시작");
//							String msg = "";
//							// TODO Auto-generated method stub
//							try {
//								System.out.println("Into try");
//								while (true) {
//									System.out.println("while start");
//									msg = arduinoBr.readLine();
//									System.out.println(msg);
//
//								}
//							} catch (Exception e) {
//								// TODO: handle exception
//							}
//						}
//					});
//					t.start();

//					System.out.println("Thread 시작");
					FromArdu.start();
					ToArdu.start();
//					System.out.println("Thread 시작");

				} else {
					// parallel port로 열렸을 경우
					System.out.println("Serial Port만 이용가능합니다...");
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}

// 센서값을 받아서 메인서버에 보내는 로직.
class FromArduino implements Runnable {
	// 필요한 스트림
	// 아두이노에서 라떼판다로 받을 스트림 : arduinoBr
	// 받은 정보를 메인서버로 보낼 스트림 : serverPr
	private BufferedReader arduinoBr;
	private PrintWriter serverPr;
	private Thermomete myTher;
	private Gson gson = new Gson();
//	private InputStream in;

	FromArduino(BufferedReader arduinoBr, PrintWriter serverPr) {
//		this.in = in;
//		this.arduinoBr = new BufferedReader(new InputStreamReader(in));
		this.arduinoBr = arduinoBr;
		this.serverPr = serverPr;
	}

	@Override
	public void run() {
		System.out.println("Runnable 시작");
		String msg = "";
		while (true) {

			try {
//				System.out.println("while 시작");
				msg = arduinoBr.readLine();
				
				
//				if (myTher != null) {
//
//					myTher = new Thermomete();
//				}

//				System.out.println("받아오기 완료 시작");
//				System.out.println(msg);
				serverPr.println(msg);
				serverPr.flush();
			} catch (Exception e) {
			}
		}

	}
}

// 서버에서 보낸 명령을 아두이노로 보내는 로직.
class ToArduino implements Runnable {

	// 메인서버에서 라떼판다로 받을 스트림 : serverBr
	// 받은 정보를 아두이노로 보낼 스트림 : arduinoPr
	private BufferedReader serverBr;
	private PrintWriter arduinoPr;

	ToArduino(BufferedReader serverBr, PrintWriter arduinoPr) {
		this.serverBr = serverBr;
		this.arduinoPr = arduinoPr;
	}

	@Override
	public void run() {
		String msg = "";
		while (true) {
			try {
				msg = serverBr.readLine();
				System.out.println(msg);
				arduinoPr.println(msg+'\n');
				arduinoPr.flush();
			} catch (Exception e) {
			}
		}

	}
}

class Thermomete {
	private String type;
	private float temperature;

	public Thermomete(String type, float temperature) {
		super();
		this.type = type;
		this.temperature = temperature;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

}
