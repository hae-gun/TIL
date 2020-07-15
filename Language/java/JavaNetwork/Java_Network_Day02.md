# 2020-04-17

# Java Network day02

## Multi Echo System.

* 다중접속.

### MultiEchoServer

* 화면구성부터 진행.

  ```java
  package javanetwork.multiecho.lec;
  
  import java.net.ServerSocket;
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
  
  //Server쪽 프로그램.
  //javaFX로 구현.
  
  public class Exam_03_MultiEchoServer extends Application  {
  
  	// 필요한 field 선언
  	private TextArea ta;
  	private Button startBtn, stopBtn;
  	// Thread Pool을 생성(제한된 숫자의 Thread를 가지고 있는 pool이 아니라
  	// 필요한 객수만큼 Thread를 가지고 있는 Thread pool을 생성.)
  	private ExecutorService excutorService = Executors.newCachedThreadPool();
  
  	// 서버쪽 네트워크 프로그램이니까 ServerSocket이 존재해야 한다.
  	ServerSocket server;
  
  	// TextArea에 특정 문자열을 편하게 출력하기 위해서 하나의 method를 만들어서 사용한다.
  	private void printMSG(String msg) {
  //		 TextArea에 출력하기 위해서 Thread를 이용해야 한다.
  //		Platform.runLater(new Runnable(){
  //			@Override
  //			public void run() {
  //				ta.appendText(msg + "\n");
  //			}
  //		});
  //		-> lambda 식으로 변환
  		Platform.runLater(() -> {
  			ta.appendText(msg + "\n");
  		});
  
  	}
  
  	@Override
  	public void start(Stage primaryStage) throws Exception  {
  		// 처음 창이 화면에 뜰때 화면구성하는 용도로 사용.
  		// 화면을 동서남북중앙으로 구성하는 BorderPane을 이용.
  		BorderPane root = new BorderPane();
  		root.setPrefSize(700, 500);
  		
  		// TextArea를 생성해서 BorderPane의 중앙에 부착.
  		ta = new TextArea();
  		root.setCenter(ta);
  		
  		// 두개의 버튼을 각각 생성해서 화면에 부착.
  		startBtn = new Button("Echo Server 시작");
  		startBtn.setPrefSize(150, 40);
  		startBtn.setOnAction(e -> {
  			// Event 처리코드
  			
  		});
  		
  		stopBtn = new Button("Echo Server 중지");
  		stopBtn.setPrefSize(150, 40);
  		stopBtn.setOnAction(e -> {
  			// Event 처리코드
  			
  		});
  		
  		// Android 의 LinearLayout과 유사한 component
  		FlowPane flowpane = new FlowPane();
  		flowpane.setPrefSize(700, 40);
  		// 위아래좌우 Insets 객체를 이용하여Padding 설정
  		flowpane.setPadding(new Insets(10,10,10,10)); 
  		// 간격설정
  		flowpane.setHgap(10);
  		// 버튼 부착
  		flowpane.getChildren().add(startBtn);
  		flowpane.getChildren().add(stopBtn);
  		//판 부착
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
  
  ```

  

* Server 시작 로직.

  ```java
  startBtn.setOnAction(e -> {
  			// Event 처리코드
  			printMSG("[서버시작]");
  			// ServerSocket이 있어야 서버역할을 할 수 있다.
  			try {
  				server = new ServerSocket(9999);
  				while (true) {
  					server.accept();
  					printMSG("[새로운 클라이언트 접속]");
  					
  				}
  			} catch (IOException e1) {
  				e1.printStackTrace();
  			}
  
  		});
  ```

* 하지만 위와 같이 코드를 작성하면 FX에서 해당 버튼을 클릭하면 While문에 계속 blocking되어 멈춰버림.

  ![image-20200417101526560](Java_Network_Day02.assets/image-20200417101526560.png)

* 이벤트 처리코드를 별도의 Thread로 작성해야한다.

  ```java
  startBtn.setOnAction(e -> {
  			// Event 처리코드
  			printMSG("[서버시작]");
  			// 별도의 Thread를 만들어서 서버역할을 수행해야 한다.
  			// Runnable interface를 구현한 객체를 만들어서
  			// ExecutorService(Thread Pool)을 이용하여 Thread를 실행.
  			Runnable runnable = () -> {
  				try {
  					server = new ServerSocket(9999);
  					while (true) {
  						Socket s = server.accept();
  						// 클라이언트와 연결된 소켓 s를 가지고 별도의 Thread가 실행.
  						// Thread를 실행시키는 코드가 나오면 된다.
  						EchoRunnable r = new EchoRunnable(s);
  						excutorService.execute(r);
  
  						printMSG("[새로운 클라이언트 접속]");
  					}
  				} catch (IOException e1) {
  					e1.printStackTrace();
  				}
  			};
  
  			excutorService.execute(runnable); // Thread 실행.
  			startBtn.setDisable(true);
  		});
  ```

* 클라이언트와 데이터를 주고받는 Runnble 객체 생성. `(EchoRunnable)`

  ```java
  class EchoRunnable implements Runnable {
  	private Socket s;
  	private BufferedReader br;
  	private PrintWriter pr;
  
  	// constructor injection 이라고 불리는 객체전달(주입)방식
  	EchoRunnable(Socket s) {
  		this.s = s;
  		try {
  			this.br = new BufferedReader(new InputStreamReader(s.getInputStream()));
  			this.pr = new PrintWriter(s.getOutputStream());
  		} catch (IOException e) {
  			e.printStackTrace();
  		}
  	}
  
  	public void run() {
  		// Thread가 클라이언트와 어떻게 동작하는지 이곳에 명시.
  		String line = "";
  		try {
  			
  			while ((line = br.readLine()) != null) { // null : 접속이 끊긴 경우.
  				if (line.equals("@EXIT")) {
  					break;
  				}
  				pr.println(line);
  				pr.flush();
  			}
  			
  		} catch (Exception e) {
  		}
  
  	}
  
  }
  ```



### MultiEchoClient

* 이전 실습에서 진행했던 코드 그대로 사용. 포트번호만 변경.

  ```java
  package javanetwork.multiecho.lec;
  
  import java.io.BufferedReader;
  import java.io.IOException;
  import java.io.InputStreamReader;
  import java.io.PrintWriter;
  import java.net.Socket;
  import java.net.UnknownHostException;
  
  import javafx.application.Application;
  import javafx.application.Platform;
  import javafx.scene.Scene;
  import javafx.scene.control.Button;
  import javafx.scene.control.TextArea;
  import javafx.scene.control.TextField;
  import javafx.scene.layout.BorderPane;
  import javafx.scene.layout.FlowPane;
  import javafx.stage.Stage;
  
  public class Exam03_MultiEchoClient extends Application {
  
  	private TextArea ta;
  	private Button connectBtn; // 서버연결버튼
  	private TextField tf; // 채팅글 입력상자
  
  	private Socket s;
  	private BufferedReader br;
  	private PrintWriter pr;
  
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
  
  		ta = new TextArea();
  		root.setCenter(ta);
  
  		connectBtn = new Button("서버에 접속");
  		connectBtn.setPrefSize(250, 50);
  		connectBtn.setOnAction(e -> {
  			// 연결되면 TextArea 내용 초기화.
  			ta.clear();
  			try {
  				s = new Socket("localhost", 9999);
  				printMSG("서버 접속성공");
  				br = new BufferedReader(new InputStreamReader(s.getInputStream()));
  				pr = new PrintWriter(s.getOutputStream());
  				// 접속 성공후 입력상자 활성화
  				tf.setDisable(false);
  				connectBtn.setDisable(true);
  			} catch (UnknownHostException e1) {
  				e1.printStackTrace();
  			} catch (IOException e1) {
  				e1.printStackTrace();
  			}
  
  		});
  
  		tf = new TextField();
  		tf.setPrefSize(400, 50);
  		// 입력상자를 초기에 사용할수 없게 설정.
  		tf.setDisable(true);
  		
  		tf.setOnAction(e -> {
  			String msg = tf.getText();
  			pr.println(msg);
  			pr.flush();
  			tf.clear();
  			
  			if(!msg.equals("@EXIT")) {
  				try {
  					String revString = br.readLine();
  					printMSG(revString);
  				} catch (IOException e1) {
  					e1.printStackTrace();
  				}
  			}else {
  				printMSG("[서버와의 연결 종료]");
  				connectBtn.setDisable(false);
  				tf.setDisable(true);
  			}
  		});
  
  
  		FlowPane flowpane = new FlowPane();
  		flowpane.setPrefSize(700, 50);
  		flowpane.getChildren().add(connectBtn);
  		flowpane.getChildren().add(tf);
  
  		root.setBottom(flowpane);
  
  		Scene scene = new Scene(root);
  		primaryStage.setScene(scene);
  		primaryStage.setTitle("Echo Program");
  
  		primaryStage.setOnCloseRequest(e -> {
  			System.exit(0);
  		});
  
  		primaryStage.show();
  	}
  
  	public static void main(String[] args) {
  		launch();
  
  	}
  
  }
  ```

* 위와 같은 코드로 작성하면 서버에 여러 클라이언트가 접속이 가능하고 각 개별로 Echo 채팅이 가능하다.

* 하지만 서로간 채팅은 아직 불가능한 상태.



## Chating System

* 각 Client 가 서로 채팅을 하기 위해서는 공유객체를 사용해야 한다.

* 공유 객체안에는 모든 Thread의 정보가 들어있어야 한다.

* 공유객체의 전달메소드를 이용하여 공유객체 안에 있는 Thread를 실행시키는 형태로 작성해야함.

* 1 : N 형태의 채팅프로그램을 작성!! (방 1개짜리 채팅)

* 공용객체

  ```java
  // Thread에 의해서 공유되는 공용객체를 만들기 위한 class를 정의
  class ChatSharedobject {
  	// Thread에 의해서 공유되어야 하는 데이터.
  	// 모든 클라이언트에 대한 Thread를 만들기위해 필요한 Runnable 객체 저장.
  	List<ChatRunnable> clients = new ArrayList<ChatRunnable>();
  
  	// 이 데이터를 제어하기 위해서 필요한 method
  	// 새로운 사용자가 접속했을때 clients안에 새로한 사용자에 대한 Runnable 객체를 저장.
  	public void add(ChatRunnable runnable) {
  		clients.add(runnable);
  	}
  
  	// 사용자가 접속을 종료했을 때 client안에 있는 사용자를 삭제.
  	public void remove(ChatRunnable runnable) {
  		clients.remove(runnable);
  	}
  
  	// 클라이언트가 데이터를 보내줬을 때 채팅메시지를 Broadcast하는 method
  	public void broadcast(String msg) {
  		for (ChatRunnable client : clients) {
  			client.getPr().println(msg);
  			client.getPr().flush();
  		}
  	}
  }
  ```

* Server 객체 변경.

  ```java
  startBtn.setOnAction(e -> {
  			// Event 처리코드
  			printMSG("[서버시작]");
  			// 별도의 Thread를 만들어서 서버역할을 수행해야 한다.
  			// Runnable interface를 구현한 객체를 만들어서
  			// ExecutorService(Thread Pool)을 이용하여 Thread를 실행.
  			Runnable runnable = () -> {
  				try {
  					server = new ServerSocket(9999);
  					Socket s = server.accept();
  					ChatRunnable chat = new ChatRunnable(s,shared);
  					// 새로운 사용자 추가.
  					shared.add(chat);
  					excutorService.execute(chat);
  
  				} catch (IOException e1) {
  					e1.printStackTrace();
  				}
  			};
  
  			excutorService.execute(runnable); // Thread 실행.
  			startBtn.setDisable(true);
  		});
  ```

* 사용되는 CharRunnable 객체도 변경

  * Runnble 객체에서 공유객체를 사용한다.
  * 기존에 했던 PrintWriter를 이용하여 println(), flush() 매서드 이용한 부분은 혼자서만 Echo가 가능하지만 공용객체의 broadcast() 를 이용하면 공용객체에 연결된 모든 ChatRunnable 에게 msg를 전송하게 된다.

  ```java
  
  class ChatRunnable implements Runnable {
  	private Socket s;
  	private ChatSharedobject shared;
  	private BufferedReader br;
  	private PrintWriter pr;
  
  	ChatRunnable(Socket s, ChatSharedobject shared) {
  		this.s = s;
  		this.shared = shared;
  		try {
  			this.br = new BufferedReader(new InputStreamReader(s.getInputStream()));
  			this.pr = new PrintWriter(s.getOutputStream());
  		} catch (IOException e) {
  			e.printStackTrace();
  		}
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
  				shared.broadcast(line);
  			}
  
  		} catch (Exception e) {
  		}
  
  	}
  
  }
  ```

* 또한 Client 변경해야한다.

  * 기존에 사용한 Client는 내가 보낸 msg를 보내고 받기를 대기한다.
  * 하지만 실제 채팅은 내가 채팅을 하지 않아도 메시지를 받아야 한다.
  * 따라서 메시지를 받는 부분을 Thread로 따로 처리한다.

* 클라이언트 이벤트 처리 코드

  ```java
  	connectBtn.setOnAction(e -> {
  			// 연결되면 TextArea 내용 초기화.
  			ta.clear();
  			try {
  				s = new Socket("localhost", 9999);
  				printMSG("서버 접속성공");
  				br = new BufferedReader(new InputStreamReader(s.getInputStream()));
  				pr = new PrintWriter(s.getOutputStream());
  				// 접속 성공후 입력상자 활성화
  				tf.setDisable(false);
  				
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
  ```

* 이벤트에서 사용되는 ReceiveRunnable 객체

  * `printMSG()` 매서드를 편하게 사용하기 위해 클라이언트 객체 내부에 `Inner class` 형태로 작성함.

  ```java
  class ReceiveRunnable implements Runnable {
  
  		private BufferedReader br;
  
  		ReceiveRunnable(BufferedReader br) {
  			this.br = br;
  		}
  
  		@Override
  		public void run() {
  			String msg = "";
  			try {
  				while (true) {
  					msg = br.readLine();
  					if (msg == null) {
  						break;
  					}
  					printMSG(msg);
  				}
  			} catch (IOException e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			}
  
  		}
  
  	}
  	
  ```







---

## 내가 추가한기능

* 유저 아이디 입력창
* 로그아웃기능.
* 접속, 로그아웃시 로그 남김

* In Client

  ```java
  package javanetwork.multiecho.lec;
  
  import java.io.BufferedReader;
  import java.io.IOException;
  import java.io.InputStreamReader;
  import java.io.PrintWriter;
  import java.net.Socket;
  import java.net.UnknownHostException;
  import java.util.concurrent.ExecutorService;
  import java.util.concurrent.Executors;
  
  import javafx.application.Application;
  import javafx.application.Platform;
  import javafx.scene.Scene;
  import javafx.scene.control.Button;
  import javafx.scene.control.TextArea;
  import javafx.scene.control.TextField;
  import javafx.scene.layout.BorderPane;
  import javafx.scene.layout.FlowPane;
  import javafx.stage.Stage;
  
  public class Exam04_CharClient extends Application {
  
  	private TextArea ta;
  	private Button connectBtn, logoutBtn; // 서버연결버튼
  	private TextField tf, id; // 채팅글 입력상자
  
  	private Socket s;
  	private BufferedReader br;
  	private PrintWriter pr;
  
  	private ExecutorService executorService = Executors.newCachedThreadPool();
  
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
  					printMSG(msg);
  				}
  			} catch (IOException e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			} catch (Exception e) {
  				e.printStackTrace();
  			}
  
  		}
  
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
  
  		ta = new TextArea();
  		root.setCenter(ta);
  
  		connectBtn = new Button("서버에 접속");
  		connectBtn.setPrefSize(250, 50);
  		connectBtn.setOnAction(e -> {
  			// 연결되면 TextArea 내용 초기화.
  			ta.clear();
  			try {
  				s = new Socket("localhost", 9999);
  				printMSG("서버 접속성공");
  				br = new BufferedReader(new InputStreamReader(s.getInputStream()));
  				pr = new PrintWriter(s.getOutputStream());
  				// 접속 성공후 입력상자 활성화
  
  				String user = id.getText() + " 님이 접속하였습니다.";
  				pr.println(user);
  				pr.flush();
  				onComponent();
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
  		logoutBtn = new Button("log\nout");
  		logoutBtn.setPrefSize(50, 50);
  		logoutBtn.setOnAction(e -> {
  			
  			tf.clear();
  			pr.println(id.getText() + " 님이 로그아웃 하였습니다.");
  			pr.flush();
  			pr.close();
  			try {
  				br.close();
  			} catch (IOException e1) {
  				e1.printStackTrace();
  			}
  			offComponent();
  		});
  		id = new TextField("아이디입력");
  		id.setPrefSize(100, 50);
  		
  		tf = new TextField();
  		tf.setPrefSize(300, 50);
  		// 입력상자를 초기에 사용할수 없게 설정.
  		tf.setOnAction(e -> {
  			String msg = tf.getText();
  			String user = id.getText() + ": ";
  			pr.print(user);
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
  		offComponent();
  		FlowPane flowpane = new FlowPane();
  		flowpane.setPrefSize(700, 50);
  		flowpane.getChildren().add(connectBtn);
  		flowpane.getChildren().add(id);
  		flowpane.getChildren().add(tf);
  		flowpane.getChildren().add(logoutBtn);
  
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
  		logoutBtn.setDisable(false);
  		id.setDisable(true);
  		connectBtn.setDisable(true);
  	}
  
  	public void offComponent() {
  		tf.setDisable(true);
  		logoutBtn.setDisable(true);
  		id.setDisable(false);
  		connectBtn.setDisable(false);
  
  	}
  
  	public static void main(String[] args) {
  		launch();
  
  	}
  
  }
  
  ```

* 코드 오류있음.

  * 해당코드에서 pr과 br을 닫아버리면 소켓이 자동으로 닫힘.
  * 위 오류로.. 중복이 되는 오류는 없어졌는데 찜찜함.

