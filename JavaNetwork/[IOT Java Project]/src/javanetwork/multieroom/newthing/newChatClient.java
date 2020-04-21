package javanetwork.multieroom.newthing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class newChatClient extends Application {

	private TextArea ta;
	private TextArea connUser;
	private String userID;

	private String inRoom = "";
	private Button connectBtn, logoutBtn; // 서버연결버튼
	private Button disconnBtgn;
	private Button createRoomBtn;
	private Button connRoomBtn;
	private Button listReset;
	private ListView<String> roomListView;
	private ListView<String> participants;
	private TextField tf, id; // 채팅글 입력상자

	private Socket s;
	private BufferedReader br;
	private PrintWriter pr;
	private String RoomList;
	private ExecutorService executorService = Executors.newCachedThreadPool();
	HashMap<String, ArrayList<String>> roomList = new HashMap<String, ArrayList<String>>();

	// Inner class 형태로 작성.(밖에서 해도 되나 코드 처리가 필요함.)
	class ReceiveRunnable implements Runnable {

		private BufferedReader br;

		ReceiveRunnable(BufferedReader br) {
			this.br = br;
		}

		@Override
		public void run() {
			String msg = "";

			try {

				while ((msg = br.readLine()) != null) {
					String room = "";
					if (msg.contains("@chat")) {
//						if(inRoom.equals(msg.split("@", 3)[2]))
						if (msg.split("@").length == 3) {
							room = msg.split("@")[2];
						}
						System.out.println("room: " + room);
						System.out.println("inRoom: " + inRoom);
						if (room != null && inRoom.equals(room)) {
							printMSG(msg.split("@")[0]);
						}
					} else if (msg.contains("@roomList")) {
						RoomList = msg.split("@")[0];
						
						
						if (RoomList.equals("[]")) {
							printMSG("방이 없어요");
						} else {

							StringBuffer sb = new StringBuffer(RoomList);
							sb.deleteCharAt(sb.length() - 1);
							sb.deleteCharAt(0);
							RoomList = sb.toString();

							String[] list = RoomList.split(",");
							printMSG("방목록을 가져옵니다.");
							for (String roomName : list) {
								if (!roomListView.getItems().contains(roomName.trim())) {
									addRoomName(roomName);
								}
							}
						}
					} else if (msg.contains("@connRoom")) {
						String user = msg.split(",")[1].split("@")[0];
						String rName = msg.split(",")[0].split("@")[0];

						

//						System.out.println(rName);
//						System.out.println(user + "@this");
//						System.out.println(roomList.get(rName).size());

					} else if (msg.contains("@create")) {
						String rName = msg.split("@")[0];
						printMSG(rName + " 방 생성");
						roomList.put(rName, new ArrayList<String>());
					} else if(msg.contains("@userList")) {
						printMSG(msg);
						
					}

				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public void addRoomName(String rName) {
		roomListView.getItems().add(rName.trim());
	}

	public void printMSG(String msg) {
		Platform.runLater(() -> {
			ta.appendText(msg + "\n");
		}

		);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);

		roomListView = new ListView<String>();
		participants = new ListView<String>();
		FlowPane flowpane = new FlowPane();

		listReset = new Button("방목록 갱신");
		listReset.setPrefSize(100, 50);
		listReset.setOnAction(e -> {

			pr.println("@roomList");
			pr.flush();

		});

		connUser = new TextArea("아이디");
		connUser.setPrefSize(130, 50);
		connUser.setEditable(false);

		ta = new TextArea();
		root.setCenter(ta);
		ta.setEditable(false);

		GridPane gridpane = new GridPane();
		gridpane.setPadding(new Insets(10, 10, 10, 10));
		gridpane.setVgap(10);

		gridpane.add(roomListView, 0, 0);
		gridpane.add(participants, 0, 1);

		root.setRight(gridpane);

		connectBtn = new Button("서버에 접속");
		connectBtn.setPrefSize(100, 50);
		connectBtn.setOnAction(e -> {
			// 연결되면 TextArea 내용 초기화.
			Dialog<String> dialog = new TextInputDialog("닉네임 입력");
			dialog.setHeaderText("닉네임설정");

			Optional<String> result = dialog.showAndWait();
			String entered = "";
			if (result.isPresent()) {
				entered = result.get();
			}

			ta.clear();
			try {
				s = new Socket("localhost", 9999);
				printMSG("서버 접속성공");
				br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				pr = new PrintWriter(s.getOutputStream());
				// 접속 성공후 입력상자 활성화

				userID = entered;
				printMSG(userID + "님 안녕하세요");
				pr.println(userID + "@connUser");
				pr.flush();

				connUser.setText("접속중인 닉네임\n" + userID);

				String room = "2";
				// 입력을 받기위한 Thread를 생성하고 실행.
				ReceiveRunnable r = new ReceiveRunnable(br);
				executorService.execute(r);

				connectBtn.setDisable(true);
			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		});

		createRoomBtn = new Button("방생성");
		createRoomBtn.setPrefSize(100, 50);
		createRoomBtn.setOnAction(e -> {
			Dialog<String> dialog = new TextInputDialog("방이름입력");
			dialog.setHeaderText("방이름 추가");
			Optional<String> result = dialog.showAndWait();

			String sendRoomName = result.get() + "@create";

			pr.println(sendRoomName);
			pr.flush();

		});

		connRoomBtn = new Button("방접속");
		connRoomBtn.setPrefSize(100, 50);
		connRoomBtn.setOnAction(e -> {
			inRoom = roomListView.getSelectionModel().getSelectedItem();
			printMSG(inRoom + " 방에 접속하였습니다.");

			String user = userID + " 님이 접속하였습니다.@chat";
			pr.println(user);
			pr.flush();
			pr.println(inRoom + "@connRoom," + userID + "@addUser");
			pr.flush();
			if (tf == null) {
				tf = new TextField();

				tf.setPrefSize(300, 50);
				// 입력상자를 초기에 사용할수 없게 설정.
				tf.setOnAction(v -> {

					String msg = userID + ": " + tf.getText() + "@chat" + "@" + inRoom;
//				String user = id.getText() + ": ";
//				pr.print(user);
					if (!msg.equals("@EXIT")) {
						pr.println(msg);
					} else {
						pr.println("로그아웃 하셨습니다.");
					}
					pr.flush();
					tf.clear();

					if (msg.equals("@EXIT")) {
						offComponent();
						pr.close();
						try {
							br.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}

				});
				flowpane.getChildren().add(tf);
			}
		});

//		logoutBtn = new Button("log\nout");
//		logoutBtn.setPrefSize(50, 50);
//		logoutBtn.setOnAction(e -> {
//			
//			tf.clear();
//			pr.println(id.getText() + " 님이 로그아웃 하였습니다.");
//			pr.flush();
//			pr.close();
//			try {
//				br.close();
//			} catch (IOException e1) {
//				e1.printStackTrace();
//			}
//			offComponent();
//		});
//		id = new TextField("아이디입력");
//		id.setPrefSize(100, 50);

//		offComponent();

		flowpane.setPadding(new Insets(10, 10, 10, 10));
		flowpane.setPrefSize(700, 50);
		flowpane.setHgap(10);
		flowpane.getChildren().add(connectBtn);
		flowpane.getChildren().add(connRoomBtn);
		flowpane.getChildren().add(createRoomBtn);
		flowpane.getChildren().add(listReset);
		flowpane.getChildren().add(connUser);
//		flowpane.getChildren().add(id);

//		flowpane.getChildren().add(logoutBtn);

		root.setBottom(flowpane);

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Echo Program");

		primaryStage.setOnCloseRequest(e -> {
			System.exit(0);
		});

		primaryStage.show();
	}

	public void onComponent() {
		tf.setDisable(false);
//		logoutBtn.setDisable(false);
//		id.setDisable(true);
		connectBtn.setDisable(true);
	}

	public void offComponent() {
		tf.setDisable(true);
//		logoutBtn.setDisable(true);
//		id.setDisable(false);
		connectBtn.setDisable(false);

	}

	public static void main(String[] args) {
		launch();

	}

}
