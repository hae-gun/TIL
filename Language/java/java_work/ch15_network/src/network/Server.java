package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		
		
		ServerSocket server =null;
		Socket socket = null;
		
		
		try {
			
			server = new ServerSocket();
			server.bind(new InetSocketAddress("localhost",8888));
			System.out.println("[연결 대기중]");
			
			socket = server.accept();
			
			System.out.println("[연결 성공]");
			
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			
			byte[] msg = new byte[100];
			is.read(msg);
			
			System.out.println(new String(msg));
			
			String str = "Hello, Client";
			os.write(str.getBytes());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
