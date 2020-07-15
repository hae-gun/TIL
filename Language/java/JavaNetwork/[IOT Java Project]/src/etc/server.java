package etc;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class server extends Thread{
	/*��Ʈ��ũ*/
	JFrame Save;
	Socket accep_soc;	//�ٸ� ������ ������ ��ٸ��� ����
	BufferedReader reader;	//������ ���� ������ �����
	PrintWriter writer;		//������ ���� ������ �����
	int port_num;	//�� ��Ʈ��ȣ
	/*ä������*/
	String Split[];
	String myname;	//���� �̸� 
	String count_user_name; //���� �̸�

	server(int serverport_num, String user_name){
		this.port_num = serverport_num;
		this.myname = user_name;
	}

	public void run(){
		try{
			ServerSocket serversocket = new ServerSocket(port_num);
			System.out.println("���ӿϷ�!! Server port_num :"+port_num);
			input_count_ip ici = new input_count_ip(myname,port_num);
			while(true){
				accep_soc = serversocket.accept(); //�������ϰ� Ŭ���̾�Ʈ ���� ����
				InputStreamReader stream= new InputStreamReader(accep_soc.getInputStream());
				reader = new BufferedReader(stream);
				writer = new PrintWriter(accep_soc.getOutputStream());
				count_user_name = reader.readLine();
				chat_frame chat = new chat_frame(myname,reader,writer,1);
				ici.frame.dispose();
			}
		}catch(Exception ex){
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "�̹� ������� ��Ʈ ��ȣ�Դϴ�.");
			info server_frame = new info();
		}
	}
}

