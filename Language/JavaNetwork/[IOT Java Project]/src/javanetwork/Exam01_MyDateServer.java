package javanetwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

// 서버쪽 프로그램
// 클라이언트가 접속하면 현재 시간을 알아내어 클라이언트에게 전송하는 서버 프로그램
public class Exam01_MyDateServer {

	// 프로그램의 entry point
	public static void main(String[] args) {
		// 1. 서버프로그램이니 클라이언트의 접속을 기다려야 한다.
		// 클라이언트의 Socket 접속을 기다리는 ServerSocket을 만들어야 한다.
		// 포트번호를 임의적으로 지정해서 선언해야함.
		try {
			ServerSocket server = new ServerSocket(5556);
			System.out.println("서버 생성");
			// 2. 클라이언트의 접속을 기다리기 위한 method를 호출
			String data = "";
			PrintWriter out = null;
			Socket s = null;
			BufferedReader br = null;
			while (!data.equals("@EXIT")) {
				s = server.accept(); // blocking method
				// 클라이언트가 접속할때까지 대기.
				System.out.println("클라이언트 접속");
				// 3. 소켓이 생성되면 데이터 입출력을 하기 위해 Stream 을 생성한다.
				// 현재시간 구하기.

				br = new BufferedReader(new InputStreamReader(s.getInputStream()));

				data = br.readLine();

				out = new PrintWriter(s.getOutputStream());
				System.out.println("받은 데이터 : " + data);

				out.println(data);
				out.flush();
			}
			out.close();
			br.close();
			// 소켓 닫기
			s.close();
			server.close();
			System.out.println("프로그램 종료");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
