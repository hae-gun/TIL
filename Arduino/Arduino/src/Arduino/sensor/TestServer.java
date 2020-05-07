package Arduino.sensor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class TestServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("[서버시작]");
			ServerSocket server = new ServerSocket(7575);
			while (true) {
				Socket s;
				s = server.accept();
				BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				BufferedReader consolebr = new BufferedReader(new InputStreamReader(System.in));

				PrintWriter pr = new PrintWriter(s.getOutputStream());
				System.out.println("[아두이노 접속]");
				Thread t = new Thread(new Runnable() {
					@Override
					public void run() {

						Thread getThread = new Thread(new Runnable() {
							@Override
							public void run() {
								try {
									while (true) {
										String msg = br.readLine();
										String[] machine = msg.split(",");
										System.out.println(msg);
									}
								} catch (Exception e) {
									System.out.println();
								}

							}
						});
						getThread.start();

						Thread giveThread = new Thread(new Runnable() {
							@Override
							public void run() {
								try {
									while (true) {

										String chat = consolebr.readLine();

										pr.println(chat);
										pr.flush();

									}
								} catch (IOException e) {
								}

							}
						});
						giveThread.start();

					}
				});
				t.start();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
