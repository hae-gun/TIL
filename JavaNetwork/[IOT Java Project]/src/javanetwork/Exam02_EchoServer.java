package javanetwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// 서버쪽 프로그램
// 클라이언트가 접속하면 현재 시간을 알아내어 클라이언트에게 전송하는 서버 프로그램
public class Exam02_EchoServer {

	// 프로그램의 entry point
	public static void main(String[] args) {
		// 1. 서버프로그램이니 클라이언트의 접속을 기다려야 한다.
		// 클라이언트의 Socket 접속을 기다리는 ServerSocket을 만들어야 한다.
		// 포트번호를 임의적으로 지정해서 선언해야함.
		try {
			ServerSocket server = new ServerSocket(7777);
			System.out.println("서버 생성");

			Socket s = server.accept();
			// Thread 를 만들어서 실행
			// Thread 에게 socket을 넘겨줘서 클라이언트와 동작하게끔 수행.

			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter pr = new PrintWriter(s.getOutputStream());
			String msg = "";
			while (true) { // 받으면 보내는 로직
				msg = br.readLine();
				if ((msg == null) || (msg.equals("@EXIT"))) {
					break;
				}

				pr.println(msg);
				pr.flush();
			}
			if (br != null)
				br.close();
			if (pr != null)
				pr.close();
			if (s != null)
				s.close();
			if (server != null)
				server.close();
			System.out.println("프로그램 종료");

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("오류");
		}
	}

}
