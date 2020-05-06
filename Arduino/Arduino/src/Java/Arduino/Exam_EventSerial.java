package Java.Arduino;

import java.io.InputStream;
import java.io.OutputStream;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

// 이벤트를 처리하는 리스너 객체를 만들기위한 class를 정의.


public class Exam_EventSerial {
	
	public static void main(String[] args) {
		CommPortIdentifier portIdentifier = null;
		try {
			// 1. Serial 통신을 하기 위한 COM 포트 설정.
			// 아두이노의 포트번호를 가져옴.
			portIdentifier = 
					CommPortIdentifier.getPortIdentifier("COM8");

			// 2. 포트가 사용되고 있는지 확인해야 한다.
			if (portIdentifier.isCurrentlyOwned()) {
				System.out.println("포트가 사용중입니다...");
			} else {
				// 인자 2개 : (identifier) 문자열, int
				// Port 객체를 얻어온다.
				CommPort commPort = 
						portIdentifier.open("PORT_OPEN", 2000);

				// Port객체를 얻어온 후 우리가 사용하려고 하는 Port 는 SerialPort 이다.
				// Port 에는 ParallelPort도 있다.
				if (commPort instanceof SerialPort) {
					// SerialPort 로 형변환 (type casting)
					SerialPort serialPort = (SerialPort)commPort;
					// 포트 설정 (통신속도같은걸 설정)
					// 첫번째 : 보드레이트
					// 나머지는 정해져 있는것들 이용.
					serialPort.setSerialPortParams(
							9600, 
							SerialPort.DATABITS_8, 
							SerialPort.STOPBITS_1, 
							SerialPort.PARITY_NONE);
					// 데이터 통신을 하기 위해서 Stream을 연다.
					InputStream in = serialPort.getInputStream();
					OutputStream out = serialPort.getOutputStream();
					
					// Event처리를 통해서 대이터 읽기
					serialPort.addEventListener(new SerialListener(in));
					serialPort.notifyOnDataAvailable(true);
					
				}else {
					// parallel port로 열렸을 경우
					System.out.println("Serial Port만 이용가능합니다...");
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}



