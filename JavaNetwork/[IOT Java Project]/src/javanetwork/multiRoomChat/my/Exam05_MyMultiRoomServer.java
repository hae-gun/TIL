package javanetwork.multiRoomChat.my;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Exam05_MyMultiRoomServer extends Application {

	private TextArea ta;
	private Button startBtn, stopBtn;
	private ExecutorService executorService = Executors.newCachedThreadPool();
	ServerSocket server;
	private List<Room> roomList = new ArrayList<Room>();
	private ChatSharedObj shared = new ChatSharedObj();
	private void printMSG(String msg) {
		Platform.runLater(() -> {
			ta.appendText(msg + "\n");
		});

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);
		ta = new TextArea();
		ta.setEditable(false);
		root.setCenter(ta);

		startBtn = new Button("Chat Server Start");
		startBtn.setPrefSize(150, 40);
		startBtn.setOnAction(e -> {
			printMSG("서버 시작");
			Runnable runnable = () -> {
				try {
					server = new ServerSocket(9898);
					while (true) {
						Socket s = server.accept();
						// 서버와 클라이언트 연결.
						// 룸 리스트 전송
						// 룸 리스트 들어오면 실행되는 Thread 실행
						RoomRunnable roomList = new ChatRunnable(s, shared);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			};

		});
		FlowPane flowpane = new FlowPane();
		flowpane.setPadding(new Insets(10, 10, 10, 10));
		flowpane.setPrefSize(700, 50);
		flowpane.getChildren().add(startBtn);

		root.setBottom(flowpane);
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("서버용 JavaFX");
		primaryStage.setOnCloseRequest(e -> {

		});
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}

class MyChatRunnable implements Runnable {

	private ArrayList<Room> roomList = new ArrayList<Room>();
	private Socket s;
	private ChatSharedObj shared;
	private BufferedReader br;
	private PrintWriter pr;

	public MyChatRunnable(Socket s, ChatSharedObj shared) {
		this.s = s;
		this.shared = shared;
		try {
			this.br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			this.pr = new PrintWriter(s.getOutputStream());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void addRoom(Room newRoom) {
		roomList.add(newRoom);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}

class Room {
	private String name;
	private int roomIndex;
	private ArrayList<String> userList = new ArrayList<String>();

	Room(String name, int index) {
		this.name = name;
		this.roomIndex = index;
	}

	public void addUser(String userName) {
		userList.add(userName);
	}

	public void removeUser(String userName) {
		userList.remove(userName);
	}

}

class ChatSharedObj {
	List<ChatRunnable> clients = new ArrayList<ChatRunnable>();
	Room inRoom;

	public void inRoom(Room inRoom) {
		this.inRoom = inRoom;
	}

	public void outRoom() {
		this.inRoom = null;
	}

	public void add(ChatRunnable runnable) {
		// TODO Auto-generated method stub
		clients.add(runnable);

	}

	public void remove(ChatRunnable runnable) {
		// TODO Auto-generated method stub
		clients.remove(runnable);

	}

	public void broadcast(String msg, Room thisRoom) {
		// TODO Auto-generated method stub
		if (inRoom.equals(thisRoom)) {
			for (ChatRunnable client : clients) {
				client.getPr().println(msg);
				client.getPr().flush();
			}
		}

	}

}

class ChatRunnable implements Runnable {
	private Socket s;
	private ChatSharedObj shared;
	private BufferedReader br;
	private PrintWriter pr;
	private Room inRoom;

	ChatRunnable(Socket s, ChatSharedObj shared) {
		this.s = s;
		this.shared = shared;
		try {
			this.br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			this.pr = new PrintWriter(s.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setRoom(Room inRoom) {
		this.inRoom = inRoom;
	}

	public PrintWriter getPr() {
		return this.pr;
	}

	public void run() {
		String line = "";
		try {

			while ((line = br.readLine()) != null) {
				if (line.equals("@EXIT")) {
					shared.remove(this);
					break;
				}

				// 자신과 연결된 클라이언트만 문자열 전송하는 코드
//				pr.println(line);
//				pr.flush();
				// 모든 클라이언트에게 문자열을 전달하기위해 공용객체를 활용.
				shared.broadcast(line, this.inRoom);
			}

		} catch (Exception e) {
		}

	}

}
