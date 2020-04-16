package javanetwork.multiserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ChatRunnable implements Runnable {

	Socket s;
	
	ChatRunnable() {

	}

	ChatRunnable(Socket s) {
		this.s = s;
		
	}

	@Override
	public void run() {
		
		
		
		try {
			
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Port: "+s.getPort()+"종료");
	}
}