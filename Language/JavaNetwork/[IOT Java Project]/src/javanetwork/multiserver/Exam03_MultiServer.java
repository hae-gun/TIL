package javanetwork.multiserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exam03_MultiServer {

	private static ExecutorService executeService;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Main Server
		// 역할 : 서버소켓을 열어서 들어오는 클라이언트의 소켓을 받아 Thread 실행.
		// 계속 대기.
		
		executeService = Executors.newCachedThreadPool();
		
		try {
			ServerSocket server = new ServerSocket(7878);
			System.out.println("서버시작");
			
			while (true) {
				Socket s = server.accept();
				System.out.println(s.getPort()+"접속");
				executeService.execute(new ChatRunnable(s));
				if(executeService.isTerminated()) {
					break;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}


