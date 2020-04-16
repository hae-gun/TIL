import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class chat_frame extends JPanel {
	/* 채팅창 구성요소 */
	JFrame chat;
	JTextArea text;
	JScrollPane scroller;
	JTextField t_field;
	StringTokenizer st;
	boolean bb_sound = false;
	String m_path;
	Counting cp;

	/* 채팅 정보 */
	String user_name;
	int count_state = 0;
	int my_state = 0;

	/* 네트워크 요소들 */
	String count_ip;
	int count_port;
	BufferedReader reader;
	PrintWriter writer;
	int error_num;
	Color send_Color;

	/* 그래픽 */
	paintPanel gpanel;
	info count_g = new info();

	IO sol;

	class info {
		public Point start;
		public int width;
		public int height;
		public int binfo;
		public int thick;
		public String c_name;

		public info() {
			start = new Point();
		}
	}

	chat_frame(String u_n, BufferedReader r, PrintWriter w, int error) {
		user_name = u_n;
		reader = r;
		writer = w;
		error_num = error;
		creat_chatframe();

	}

	void creat_chatframe() {
		sol = new IO();
		// System.out.println(sol.getString());
		chat = new JFrame("Catch Mind");
		chat.setLocation(200, 100);
		final String s1 = sol.getString();
		String s2 = s1;
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		String s = sol.getString();
		cp = new Counting(reader, writer, s);
		text = new JTextArea(4, 40);
		t_field = new JTextField(20);
		scroller = new JScrollPane(text);
		text.setLineWrap(true);
		text.setEditable(false);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		gpanel = new paintPanel(user_name, reader, writer);
		panel2.setLayout(new FlowLayout());
		addButton(panel2, "메시지전송", Color.gray, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text.append(user_name + " : " + t_field.getText() + "\n");
				writer.println(user_name + " : " + t_field.getText());
				writer.flush();
				t_field.setText("");
				scroller.getVerticalScrollBar().setValue(scroller.getVerticalScrollBar().getMaximum());
			}
		});
		addButton(panel2, "대화명 변경하기", Color.orange, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Alias = JOptionPane.showInputDialog("Name");
				user_name = Alias;
				chat.setName(Alias);
			}
		});
		addButton(panel2, "대화 내용 저장", Color.orange, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String FileName;
				try {
					FileDialog fd = new FileDialog(chat, "파일 저장", FileDialog.SAVE);
					fd.setVisible(true);
					String directory = fd.getDirectory();
					String filename = fd.getFile();
					File file = new File(directory + filename); // 파일 생성
					FileOutputStream fos = new FileOutputStream(file);
					OutputStreamWriter out = new OutputStreamWriter(fos);
					out.write(text.getText()); // 파일에 텍스트 내용 쓰기
					out.close();
					JOptionPane.showMessageDialog(null, directory + "에 저장되었습니다!");
				} catch (FileNotFoundException fnfe) {
					fnfe.printStackTrace();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}

			}
		});
		addButton(panel2, "종료", null, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text.append("--- 연결이 종료되었습니다. 곧 창이 닫힙니다. ---\n");
				writer.println("5757879");
				writer.flush();
				chat.dispose();
				System.exit(0);
			}
		});
		panel1.setLayout(new BorderLayout());
		panel1.add(BorderLayout.NORTH, scroller); // 대화창
		panel1.add(BorderLayout.CENTER, t_field); // 입력창
		panel1.add(BorderLayout.SOUTH, panel2); // 전송버튼
		chat.add(BorderLayout.NORTH, cp);
		chat.add(BorderLayout.CENTER, gpanel.whiteboard);
		chat.add(BorderLayout.SOUTH, panel1);
		chat.setSize(800, 600);
		chat.setVisible(true);

		if (error_num == 5757880) {
			text.append("연결이 되지 않습니다..");
			t_field.disable();
		}
		t_field.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// System.out.println(t_field.getText());
				// System.out.println(sol.getString());
				if (s1.compareTo(t_field.getText()) == 0) {
					writer.println("50192122");
					writer.flush();
				} else {
					System.out.println("글쓰기");
					text.append(user_name + " : " + t_field.getText() + "\n");
					writer.println(user_name + " :" + t_field.getText());
					writer.flush();
					t_field.setText("");
					scroller.getVerticalScrollBar().setValue(scroller.getVerticalScrollBar().getMaximum());
				}
			}
		});
		read_msg read = new read_msg();// 읽기 스레드 생성
		read.start();
	}

	public void addButton(Container c, String title, Color cl, ActionListener a) {
		JButton b = new JButton(title);
		b.setBackground(cl);
		c.add(b);
		b.addActionListener(a);
	}

	public class read_msg extends Thread {
		public void run() {
			String msg;
			String msg2;
			String str = new String();
			int[] g_info = new int[6];
			try {
				while ((msg = reader.readLine()) != null) {
					int i = 0;
					System.out.println("read : " + msg);
					msg2 = msg;
					String[] str_tmp = msg.split(":");
					if (gpanel.getFlag() && str_tmp.length > 1) {
						System.out.println(str_tmp[1] + "," + sol.getString());
						if (str_tmp[1].compareTo(sol.getString()) == 0) {
							cp.reset_timer();
							writer.println("50192122");
							JOptionPane.showMessageDialog(chat_frame.this, "정답입니다", "정답", 1);
							writer.flush();
							sol = new IO();
						}
					}
					if (msg.compareTo("5757879") == 0) {
						text.append("--- 연결이 종료되었습니다. 곧 창이 닫힙니다. ---\n");
						sleep(2000);
						writer.println("5757879");
						writer.flush();
						chat.dispose();
						System.exit(0);
						break;
					} else if (msg.compareTo("59595922") == 0) {
						gpanel.List.clear();
					} else if (msg.compareTo("52131415") == 0) {
						cp.startTimer(1000);
						text.append("잠시후 게임을 시작합니다.\n");
						gpanel.setFlag(false);
					} else if (msg.compareTo("52131433") == 0) {
						cp.down_timer();
					} else if (msg.compareTo("52131444") == 0) {
						cp.up_timer();
					} else if (msg.compareTo("52131555") == 0) {
						gpanel.setFlag(true);
					} else if (msg.compareTo("50192122") == 0) {
						System.out.println("나와");
						cp.reset_timer();
						JOptionPane.showMessageDialog(chat_frame.this, "정답입니다", "정답", 1);
						sol = new IO();
					} else {
						st = new StringTokenizer(msg2, "*");
						String temp = st.nextToken();
						if (temp.compareTo("59595959") == 0) { // 그래픽 정보
							while (st.hasMoreTokens()) {
								if (i == 6) {
									str = st.nextToken();
									System.out.println("색깔정보:" + str);
									break;
								}
								g_info[i] = Integer.parseInt(st.nextToken());
								System.out.println("g_info[" + i + "]" + g_info[i++]);
							}
							count_g.start.x = g_info[0];
							count_g.start.y = g_info[1];
							count_g.width = g_info[2];
							count_g.height = g_info[3];
							count_g.binfo = g_info[4];
							count_g.thick = g_info[5];
							count_g.c_name = str;
							if (str.compareTo("java.awt.Color[r=0,g=0,b=0]") == 0) {
								send_Color = Color.black;
								System.out.println("검정");
							} else if (str.compareTo("java.awt.Color[r=0,g=0,b=255]") == 0) { // java.awt.Color[r=0,
																								// g=0, b=255]
								send_Color = Color.blue;
								System.out.println("파랑");
							} else if (str.compareTo("java.awt.Color[r=0,g=255,b=0]") == 0) {
								send_Color = Color.green;
								System.out.println("초록");
							} else if (str.compareTo("java.awt.Color[r=255,g=200,b=0]") == 0) {
								send_Color = Color.orange;
								System.out.println("주황");
							} else if (str.compareTo("java.awt.Color[r=255,g=255,b=0]") == 0) {
								send_Color = Color.yellow;
								System.out.println("노랑");
							}
							gpanel.set_point(count_g.start.x, count_g.start.y, count_g.width, count_g.height,
									count_g.binfo, count_g.thick, send_Color);
						} else {
							text.append(msg + "\n");
						}
					}
					scroller.getVerticalScrollBar().setValue(scroller.getVerticalScrollBar().getMaximum());
				} // while
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}