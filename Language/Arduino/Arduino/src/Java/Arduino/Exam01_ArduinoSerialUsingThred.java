package Java.Arduino;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

public class Exam01_ArduinoSerialUsingThred {

	public static void main(String[] args) {
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
					BufferedReader br = new BufferedReader(new InputStreamReader(in));
					// Thread를 이용해서 Arduino로부터 들어오는 데이터를 반복적으로 받는다.
					Thread t = new Thread(new Runnable() {
						@Override
						public void run() {
//							byte[] buffer = new byte[1024];
//							// 받은 바이트 길이를 저장하기 위한 변수.
//							int len = -1;

							String s = "";
							while (true) {
								try {
									System.out.println("1");

									s = br.readLine();
									System.out.println("2");
									// 아두이노에서 보낸 데이터를 읽을때 바이트 단위로 들어와서 얼마나 들어오는지 알 수 없다.
									if (s != null)
										System.out.println(s);

								} catch (Exception e) {
									System.out.println(e + "!!!");
								}
								System.out.println("4");
							}
						}
					});
					t.start();
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
