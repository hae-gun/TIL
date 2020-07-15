import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class server extends Thread{
	/*네트워크*/
	JFrame Save;
	Socket accep_soc;	//다른 유저의 연결을 기다리는 소켓
	BufferedReader reader;	//연결이 들어온 유저와 연결됨
	PrintWriter writer;		//연결이 들어온 유저와 연결됨
	int port_num;	//내 포트번호
	/*채팅정보*/
	String Split[];
	String myname;	//나의 이름 
	String count_user_name; //상대방 이름

	server(int serverport_num, String user_name){
		this.port_num = serverport_num;
		this.myname = user_name;
	}

	public void run(){
		try{
			ServerSocket serversocket = new ServerSocket(port_num);
			System.out.println("접속완료!! Server port_num :"+port_num);
			input_count_ip ici = new input_count_ip(myname,port_num);
			while(true){
				accep_soc = serversocket.accept(); //서버소켓과 클라이언트 소켓 연결
				InputStreamReader stream= new InputStreamReader(accep_soc.getInputStream());
				reader = new BufferedReader(stream);
				writer = new PrintWriter(accep_soc.getOutputStream());
				count_user_name = reader.readLine();
				chat_frame chat = new chat_frame(myname,reader,writer,1);
				ici.frame.dispose();
			}
		}catch(Exception ex){
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "이미 사용중인 포트 번호입니다.");
			info server_frame = new info();
		}
	}
}

