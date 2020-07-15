package etc;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ServerPort_frame {
	public static void main(String[] args) {
		info get = new info();
	}
}
class info extends JFrame{
	JFrame frame;
	int ser_portnum;
	JTextField SPortNum_f;
	JTextField user_f;
	String user_name;
	info(){
		frame = new JFrame();
		frame.setLocation(450,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel portlabel = new JLabel("port��ȣ�� �Է����ּ���");
		JLabel user_l = new JLabel("�̸��� �Է����ּ���");
		SPortNum_f = new JTextField(10);
		user_f = new JTextField(10);
		JButton button = new JButton("OK");
		frame.setLayout(new GridLayout(5,1));
		frame.setBackground(Color.pink);
		frame.add(portlabel);
		frame.add(SPortNum_f);
		frame.add(user_l);
		frame.add(user_f);
		frame.add(button);
		frame.setSize(200,200);
		frame.setVisible(true);
		
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ser_portnum = Integer.parseInt(SPortNum_f.getText());
				user_name = user_f.getText();
				server s = new server(ser_portnum,user_name);
				s.start();
				frame.dispose();
			}
		});
	}
}
