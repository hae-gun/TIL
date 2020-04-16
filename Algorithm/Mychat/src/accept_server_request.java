import java.net.*;
import java.io.*;

import javax.swing.JOptionPane;

public class accept_server_request {
	BufferedReader reader;
	PrintWriter writer;
	String count_ip;
	int count_port;
	String myname;
	
	accept_server_request(int count_port, String count_ip, String myname){
		this.count_ip = count_ip;
		this.count_port = count_port;
		this.myname = myname;
		this.accept_server();
	}
	
	public void accept_server(){
		try{
			Socket soc = new Socket(count_ip,count_port);
			InputStreamReader is = new InputStreamReader(soc.getInputStream());
			reader = new BufferedReader(is);
			writer = new PrintWriter(soc.getOutputStream());
			writer.println(myname);
			writer.flush();
			chat_frame chat_win = new chat_frame(myname, reader, writer, 1);
		}catch(IOException ex){
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "접속중이지 않거나 혹은 대화 불가능한 상태입니다.");
		}
	}
}
