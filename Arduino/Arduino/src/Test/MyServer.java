package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

public class MyServer {
	public static void main(String[] args) {

		String msg = "";
		try {
			CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier("COM8");// 2. 포트가 사용되고 있는지 확인해야 한다.
			if (portIdentifier.isCurrentlyOwned()) {
				System.out.println("포트가 사용중입니다...");
			} else {
				// 인자 2개 : (identifier) 문자열, int
				// Port 객체를 얻어온다.

				CommPort commPort = portIdentifier.open("PORT_OPEN", 2000);
				System.out.println("Port 열림");
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

					serialPort.addEventListener(new SerialListener(in, msg));
					serialPort.notifyOnDataAvailable(true);

					Thread t = new Thread(new getDataRunnable(out));
					t.start();
					// Event처리를 통해서 대이터 읽기

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

class getDataRunnable implements Runnable {
	private ServerSocket server;
	private Socket s;
	private BufferedReader br;
	private PrintWriter pr;
	private String msg="";
	private OutputStream out;
	private byte data;

	getDataRunnable(OutputStream out) {
		this.out = out;
		try {
			server = new ServerSocket(7534);
			while(true) {
			s = server.accept();
				Thread t = new Thread(() -> {
				try {
					br = new BufferedReader(new InputStreamReader(s.getInputStream()));
					pr = new PrintWriter(s.getOutputStream());
					
					msg = br.readLine();
					System.out.println(msg);
					data = (byte)msg.charAt(0);
					try {
						out.write(data);
						out.flush();
						System.out.println(data);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				} catch (Exception e) {
					// TODO: handle exception
				}

				});
			
				
				t.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		
	}
}



class SerialListener implements SerialPortEventListener {

	private InputStream in;
	private OutputStream out;
	private String msg;

//	private Thread t = new Thread(new getDataRunnable());
	SerialListener(InputStream in, String msg) {
		this.in = in;
		this.msg = msg;

	}

	@Override
	public void serialEvent(SerialPortEvent arg0) {
//		t.start();
		// 이벤트가 발생하면 호출되는 method
		if (arg0.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
			try {
				// 전달되는 데이터의 크기가 리턴되어 k에 저장됨.
				int k = in.available();
				byte[] data = new byte[k];
				// 읽어서 byte 배열에 저장
				in.read(data, 0, k);

				System.out.print("받은 메세지: " + new String(data));

			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

}
//
//class setRunnable implements Runnable {
//	InputStream in;
//	SerialPort serialPort;
//
//	setRunnable(InputStream in, SerialPort serialPort) {
//		this.in = in;
//		this.serialPort = serialPort;
//	}
//
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		Thread t1 = new Thread(new getDataRunnable());
//		try {
//			serialPort.addEventListener(new SerialListener(in, ""));
//		} catch (TooManyListenersException e) {
//			e.printStackTrace();
//		}
//		serialPort.notifyOnDataAvailable(true);
//		t1.start();
//	}
//}
