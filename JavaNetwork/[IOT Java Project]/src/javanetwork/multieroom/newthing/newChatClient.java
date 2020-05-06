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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class newChatClient extends Application {

	private TextArea ta;
	private TextArea connUser;
	private String userID;

	private String inRoom = "#MAIN";
	private String preRoom;
	private Button connectBtn;  // 서버연결버튼
	private Button logoutBtn;  // 서버연결버튼
	
	private Text roomsTitle;
	private Text usersTitle;
	private Text connUserTitle;
	private Text id1;
	private Text roomNameTitle;
	private Text roomName;
	
	private Button createRoomBtn;
	private Button connRoomBtn;
	private Button listReset;
	private ListView<String> roomListView;
	private ListView<String> participants;
	private TextField tf, id; // 채팅글 입력상자
	private boolean status;
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
					if(msg.contains("@overlap")) {
						printMSG("중복된 아이디.");
						connectBtn.setDisable(false);
						break;
					}
					String room = "";
					if (msg.contains("@chat")) {
//						if(inRoom.equals(msg.split("@", 3)[2]))
						if (msg.contains("@chat@")) {
							System.out.println("this");
							room = msg.split("@")[2];
						}
						System.out.println("room: " + room);
						System.out.println("inRoom: " + inRoom);
						if (room != null && inRoom.equals(room)) {
							printMSG(msg.split("@")[0]);
						}
					} else if (msg.contains("@roomList")) {
//						System.out.println("here~~");
//						System.out.println(msg);
//						if(msg.split("@")[0].split(",").length>1) {
//							msg.replace("[", " ");
//							msg.replace("]", " ");
//							for(String s : msg.split("@")[0].trim().split(",")) {
//								System.out.println(s);
//							}
//						}
						RoomList = msg.split("@")[0];
//						printMSG(RoomList.equals("[]"));
						if (RoomList.equals("[]")) {
							connRoomBtn.setDisable(true);
							printMSG("방이 없어요");
						} else {
							connRoomBtn.setDisable(false);
							StringBuffer sb = new StringBuffer(RoomList);
							sb.deleteCharAt(sb.length() - 1);
							sb.deleteCharAt(0);
							RoomList = sb.toString();

							String[] list = RoomList.split(",");
							for (String roomName : list) {
								if(!roomListView.getItems().contains(roomName.trim())) {
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
					}

					if (msg.contains("@userList")) {
						if (msg.split("@@").length >1) {
							String whereRoom = msg.split("@@")[1].split("@")[0];
							System.out.println(whereRoom+"11111");
							System.out.println("inRoom"+inRoom);
							System.out.println("whereRoom"+whereRoom);
							if (inRoom.equals(whereRoom)) {
								resetUserList();
								String list = msg.split("@")[0];
								System.out.println(list+"22222");
								for (String s : list.split(",")) {
									addUserList(s);
								}
							}
						}

					}
					if(msg.contains("@refresh")) {
						String refreshRoom = msg.split(",")[1].split("@")[0];
						String deleteUser = msg.split(",")[0].split("@")[0];
//						printMSG(msg);
						if(inRoom.equals(refreshRoom)) {
							deleteUser(deleteUser);
						}
						
						
					}
					
					if(!status&&msg.contains("@CLOSE")) {
						
						printMSG("로그아웃 되었습니다.");
						
						try {
							System.out.println(1);
							br.close();
							System.out.println(2);
							pr.close();
							System.out.println(3);
							s.close();
							System.out.println(4);
							break;
						} catch (Exception e) {
							System.out.println(e);
						}
					}
					

				}
			} catch (IOException e) {
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public void addRoomName(String rName) {
//		if(!rName.equals("#MAIN"))
			Platform.runLater(() -> {
				roomListView.getItems().add(rName.trim());
			});

	}

	public void addUserList(String user) {
		Platform.runLater(() -> {
			participants.getItems().add(user);
		});
	}

	public void resetUserList() {
		Platform.runLater(() -> {
			participants.getItems().clear();
		});
	}
	public void deleteUser(String user) {
		Platform.runLater(() -> {
			participants.getItems().remove(user);
			
		});
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

		listReset = new Button("로그아웃");
		listReset.setPrefSize(100, 50);
		listReset.setOnAction(e -> {

			status = false;
			connectBtn.setDisable(false);
			connRoomBtn.setDisable(true);
			roomListView.getItems().clear();
			participants.getItems().clear();
			ta.clear();
			pr.println(userID + "@deleteMem," + preRoom + "@thisRoom");
			pr.println(userID + ": 로그아웃" + "@CLOSE");
			pr.flush();
//			try {
//				br.close();
//				pr.close();
//				s.close();
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}

		});

		connUser = new TextArea("아이디");
		connUser.setPrefSize(130, 50);
		connUser.setEditable(false);

		ta = new TextArea();
		root.setCenter(ta);
		ta.setEditable(false);
		
		roomsTitle = new Text("방목록");
		usersTitle = new Text("접속유저");
		connUserTitle = new Text("접속중인 아이디: ");
		roomNameTitle = new Text("접속중인 방: ");
		
		
		
		id1 = new Text();
		roomName = new Text();
		
		GridPane inform = new GridPane();
		inform.setPadding(new Insets(10,10,10,10));
		inform.setVgap(5);
		inform.add(connUserTitle, 0, 0);
		inform.add(id1, 1, 0);
		
		
		GridPane informRoom = new GridPane();
		informRoom.setPadding(new Insets(10,10,10,10));
		informRoom.setVgap(10);
		
		GridPane titleInform = new GridPane();
		titleInform.setPadding(new Insets(10,0,10,10));
		titleInform.setHgap(5);
		titleInform.add(roomNameTitle, 0, 0);
		titleInform.add(roomName, 1, 0);
		

		informRoom.add(roomsTitle, 0, 0);
		informRoom.add(titleInform, 0, 1);
		
		GridPane gridpane = new GridPane();
		gridpane.setPadding(new Insets(10, 10, 10, 10));
		gridpane.setVgap(10);

		gridpane.add(informRoom, 0, 0);
		gridpane.add(roomListView, 0, 1);
		gridpane.add(usersTitle, 0, 2);
		gridpane.add(participants, 0, 3);
		
		
		

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
				
				status=true;
				
				br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				pr = new PrintWriter(s.getOutputStream());
				// 접속 성공후 입력상자 활성화

				userID = entered;
				preRoom = "#MAIN";
				printMSG(userID + "님 안녕하세요");
				pr.println(userID + "@connUser");
				pr.flush();

				connUser.setText("접속중인 닉네임\n" + userID);
				id1.setText(userID);
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
			Optional<String> result;
			while (true) {
				result = dialog.showAndWait();
				if (result.get().equals("#MAIN")) {
					Alert alert = new Alert(Alert.AlertType.WARNING);
					alert.setHeaderText("유효하지 않은 방이름 입니다.");
					alert.showAndWait();
				} else {
					break;
				}
			}
			String sendRoomName = result.get() + "@create";

			pr.println(sendRoomName);
			pr.flush();

		});

		connRoomBtn = new Button("방접속");
		connRoomBtn.setPrefSize(100, 50);
		connRoomBtn.setOnAction(e -> {
			

			participants.getItems().clear();

			preRoom = inRoom;

			inRoom = roomListView.getSelectionModel().getSelectedItem();
			roomName.setText(inRoom);
			
			printMSG(inRoom + " 방에 접속하였습니다.");
			String user = userID + " 님이 접속하였습니다.@chat"+"@"+inRoom;
			
			pr.println(user);
			
			pr.println(inRoom + "@connRoom," + userID + "@addUser");
			pr.println(userID + "@deleteMem," + preRoom + "@thisRoom");
			pr.flush();

			if (tf == null) {
				tf = new TextField();

				tf.setPrefSize(670, 50);
				// 입력상자를 초기에 사용할수 없게 설정.
				tf.setOnAction(v -> {

					String msg = userID + ": " + tf.getText() + "@chat" + "@" + inRoom;
//				String user = id.getText() + ": ";
//				pr.print(user);
					if (!msg.contains("@EXIT")) {
						pr.println(msg);
					} else {
						pr.println("로그아웃 하셨습니다.");
					}
					pr.flush();
					tf.clear();

					if (msg.contains("@EXIT")) {
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
		
		// 버튼 사용가능 여부 설정 나중에 매서드로 빼기
//		ta.setDisable(true);
//		connUser.setDisable(true);
//		createRoomBtn.setDisable(true);
//		connRoomBtn.setDisable(true);
//		listReset.setDisable(true);
		
		
		
		flowpane.setPadding(new Insets(10, 10, 10, 10));
		flowpane.setPrefSize(700, 50);
		flowpane.setHgap(10);
		flowpane.setVgap(3);
		flowpane.getChildren().add(connectBtn);
		flowpane.getChildren().add(connRoomBtn);
		flowpane.getChildren().add(createRoomBtn);
		flowpane.getChildren().add(listReset);
		flowpane.getChildren().add(inform);
		
//		flowpane.getChildren().add(id);

//		flowpane.getChildren().add(logoutBtn);

		root.setBottom(flowpane);

		
		
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Echo Program");

		primaryStage.setOnCloseRequest(e -> {
			try {
			pr.println(userID + "@deleteMem," + preRoom + "@thisRoom");
			pr.println(userID + ": 로그아웃");
			pr.println("@CLOSE");
			pr.flush();
			}catch(Exception e1){
				System.exit(0);
			}
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
	
	public void allOff() {
		
	}

	public static void main(String[] args) {
		launch();

	}

}
