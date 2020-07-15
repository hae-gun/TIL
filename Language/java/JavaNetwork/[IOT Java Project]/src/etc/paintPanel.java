package etc;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.*;

import java.awt.event.*;
import java.io.BufferedReader;
import java.io.PrintWriter;

public class paintPanel extends JPanel{
	JPanel whiteboard;
	ArrayList<info> List;
	private Point start, end;
	drawing c;
	int b_info;
	int thickness = 1;
	BufferedReader reader;
	PrintWriter writer;
	info receive;
	Color color_name=Color.black;
	ButtonGroup bg, bg_color;
	boolean flag = true;
	
	void setFlag(boolean tf){
		flag = tf;
	}
	boolean getFlag(){
		return flag;
	}
	
	class info{
		public Point start;
		public int width;
		public int height;
		public int binfo;
		public Color c_name;
		public int thick;
		public info(){
			start = new Point();
		}
	}
	
	public static final int windowWidth = 800;
	public static final int windowHeight = 600;
	public static final int BORDER_TOP = 0;
	public static final int BORDER_BOTTOM = 1;
	public static final int BORDER_LEFT = 2;
	public static final int BORDER_RIGHT = 3;
	public static final int BORDER_CENTER = 4;
	
	public paintPanel(String title, BufferedReader reader, PrintWriter writer) {
		this.reader = reader;
		this.writer = writer;
		whiteboard = new JPanel();
		List = new ArrayList<info>();
		bg_color = new ButtonGroup();
		whiteboard.setLayout(new BorderLayout());
		whiteboard.setSize(windowWidth, windowHeight);	
		this.addComponent();
	}
	
	public void addComponent() {
		JPanel c_panel = new JPanel();
		JPanel sh_panel = new JPanel();
		c_panel.setLayout(new BoxLayout(c_panel,BoxLayout.Y_AXIS));
		addRadioButton(bg_color, c_panel, "����", new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				color_name = Color.black;
			}
		});
		addRadioButton(bg_color, c_panel, "�Ķ�", new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				color_name = Color.blue;
			}
		});
		addRadioButton(bg_color, c_panel, "�ʷ�", new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				color_name = Color.green;
			}
		});
		addRadioButton(bg_color, c_panel, "��Ȳ", new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				color_name = Color.orange;
			}
		});
		addRadioButton(bg_color, c_panel, "���", new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				color_name = Color.yellow;
			}
		});
		addButton(c_panel, "��", null,new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(thickness < 9)
					thickness++;
			}
		});
		addButton(c_panel, "��", null,new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(thickness > 1)
					thickness--;
			}
		});	
		addButton(sh_panel, "��", null, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b_info=1;
			}
		});
		addButton(sh_panel,"��", null, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b_info=0;
			}
		});
		addButton(sh_panel,"��", null, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b_info=6;
			}
		});
		addButton(sh_panel,"/", null, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b_info=8;
			}
		});
		addButton(sh_panel,"��", Color.yellow, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b_info=4;
			}
		});
		addButton(sh_panel,"��", Color.yellow,new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b_info=3;

			}
		});
		JPanel panel = new JPanel();
		JPanel panel2 = new JPanel();
		c = new drawing();
		sh_panel.add(BorderLayout.NORTH, panel);
		sh_panel.add(BorderLayout.SOUTH, panel2);
		addButton(sh_panel, "Ŭ����", Color.gray,new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List.clear();
				writer.println("59595922");
				c.repaint();
			}
		});
		whiteboard.add(BorderLayout.SOUTH, sh_panel);
		whiteboard.add(BorderLayout.CENTER, c);
		whiteboard.add(BorderLayout.EAST, c_panel);
		c.setBackground(Color.white);
		whiteboard.setVisible(true);
	}
	
	public void addButton(Container c, String title, Color cl,ActionListener a) {
		JButton b = new JButton(title);
		b.setBackground(cl);
		c.add(b);
		b.addActionListener(a);
	}
	public void addRadioButton(ButtonGroup bg, Container c, String title, ActionListener a) {
		JRadioButton b = new JRadioButton(title);
		c.add(b);
		bg.add(b);
		b.addActionListener(a);
	}
	
	public void set_point(int x, int y, int w, int h, int b_state, int th, Color c_name){
		receive = new info();
		receive.start.x = x;
		receive.start.y = y;
		receive.width = w;
		receive.height = h;
		receive.binfo = b_state;
		receive.c_name = c_name;
		receive.thick = th;
		this.color_name = c_name;
		List.add(receive);
		System.out.println(color_name);
		c.repaint();
	}
	public class drawing extends JPanel{
		Graphics2D g2d;
		drawing(){
			WhiteboardMouseListener mouseListener = new WhiteboardMouseListener();
			addMouseMotionListener(mouseListener);
			addMouseListener(mouseListener);
			start = new Point(0, 0);
			end = new Point(0, 0);
		}
		public info GetcircleInfo(){
			info info = new info();
			info.start.x = (end.x < start.x) ? end.x : start.x;
			info.start.y = (start.y < end.y) ? start.y : end.y;
			info.width = Math.abs(end.x-start.x);
			info.height = Math.abs(end.y-start.y);
			info.binfo = b_info;
			info.thick = thickness;
			info.c_name = color_name;
			return info;
		}
		public void paintComponent(Graphics g){
			System.out.println("����Ʈ ������Ʈ ����ȴ�.");
			super.paintComponent(g);
			info p = GetcircleInfo();
			g2d = (Graphics2D)g;
			g2d.setStroke(new BasicStroke(thickness));
			g.setColor(color_name);
			if(p.binfo==0)
				g.drawOval(p.start.x, p.start.y,p.width, p.height);
			else if(p.binfo==1)
				g.drawRect(p.start.x, p.start.y,p.width, p.height);
			else if(p.binfo==3)
				g.fillOval(p.start.x, p.start.y,p.width, p.height);
			else if(p.binfo==4)
				g.fillRect(p.start.x, p.start.y,p.width, p.height);
			else if(p.binfo==6){
				g.drawLine(start.x, start.y, end.x, end.y);
				start.x = end.x;
				start.y = end.y;
			}
			else if(p.binfo==8)
				g.drawLine(start.x, start.y, end.x, end.y);
			
			Iterator<info> begin = List.iterator();
			while(begin.hasNext()){
				info current = begin.next();
				g.setColor(current.c_name);
				g2d.setStroke(new BasicStroke(current.thick));
				if(current.binfo==0)
					g.drawOval(current.start.x, current.start.y, current.width, current.height);
				else if(current.binfo==1)
					g.drawRect(current.start.x, current.start.y, current.width, current.height);
				else if(current.binfo==3)
					g.fillOval(current.start.x, current.start.y, current.width, current.height);
				else if(current.binfo==4)
					g.fillRect(current.start.x, current.start.y, current.width, current.height);
				else if(current.binfo==6)
					g.drawLine(current.start.x, current.start.y, current.width, current.height);
				else if(current.binfo==8)
					g.drawLine(current.start.x, current.start.y, current.width, current.height);
			}
		}
		class WhiteboardMouseListener implements MouseListener, MouseMotionListener {
			public void mouseClicked(MouseEvent arg0) {	
			}
			public void mouseEntered(MouseEvent arg0) {
			}
			public void mouseExited(MouseEvent arg0) {	
			}
			public void mousePressed(MouseEvent arg0) {
				start = arg0.getPoint();
			}
			public void mouseReleased(MouseEvent arg0) {
				if(flag){
					info temp = new info();
					end = arg0.getPoint();
					if(b_info==8){ //���� 
						temp.c_name = color_name;
						temp.start.x = start.x;
						temp.start.y = start.y;
						temp.width = end.x;
						temp.height = end.y;
						temp.binfo = b_info;
						temp.thick = thickness;
						List.add(temp);
						writer.println("59595959*"+temp.start.x+"*"+temp.start.y+"*"+temp.width+"*"+temp.height+"*"+temp.binfo+"*"+ temp.thick +"*"+temp.c_name);
						writer.flush();
					}
					else if(b_info!=6){ //���� ������..
						temp = GetcircleInfo();
						List.add(temp);
						writer.println("59595959*"+temp.start.x+"*"+temp.start.y+"*"+temp.width+"*"+temp.height+"*"+temp.binfo+"*"+ temp.thick +"*"+temp.c_name);
						writer.flush();
					}
				}
				c.repaint();
			}
			public void mouseDragged(MouseEvent e) {
				info temp = new info();
				end = e.getPoint();
				if(flag){
					if(b_info==6){ //��
						temp.c_name = color_name;
						temp.start.x = start.x;
						temp.start.y = start.y;
						temp.width = end.x;
						temp.height = end.y;
						temp.binfo = b_info;
						temp.thick = thickness;
						List.add(temp);
						writer.println("59595959*"+temp.start.x+"*"+temp.start.y+"*"+temp.width+"*"+temp.height+"*"+temp.binfo+"*"+ temp.thick +"*"+temp.c_name);
						writer.flush();
					}
					else if(b_info==7){ //�귯��
						temp.c_name = color_name;
						temp.start.x = end.x;
						temp.start.y = end.y;
						temp.binfo = b_info;
						temp.thick = thickness;
						List.add(temp);
						writer.println("59595959*"+temp.start.x+"*"+temp.start.y+"*"+temp.width+"*"+temp.height+"*"+temp.binfo+"*"+ temp.thick +"*"+temp.c_name);
						writer.flush();
					}
				}
				c.repaint();
			}
			public void mouseMoved(MouseEvent e) {
			}
		}
	}
}

