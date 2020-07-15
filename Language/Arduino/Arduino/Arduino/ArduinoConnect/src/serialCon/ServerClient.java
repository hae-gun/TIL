package serialCon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerClient {
	public static void main(String[] args) {

		try {
			while (true) {
				ServerSocket server = new ServerSocket(7575);
				Socket s = server.accept();
				System.out.println("접속");
				Thread t = new Thread(new Runnable() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
						BufferedReader br;
						try {
							br = new BufferedReader(new InputStreamReader(s.getInputStream()));
							PrintWriter pr = new PrintWriter(s.getOutputStream());
							String msg = "";
							while ((msg = br.readLine()) != null) {
								System.out.println(msg);
								pr.println(msg);
								pr.flush();
							}
						} catch (IOException e) {
						}

					}

				});
				t.start();
			}
		} catch (IOException e) {
		}

	}
}
