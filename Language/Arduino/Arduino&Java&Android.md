# 2020-04-27

# Android, Java Network Server, Arduino 통신

* Socket 통신 : Android + Java Network Server
* Serial 통신 : Java Network Server + Arduino

## Arduino 구성

* 안드로이드에서 클라이언트의 개념으로 소켓통신을 진행

* 그러나 소켓 통신 코드를 Activity 의 onCreate 에서 진행하면 아래와 같은 에러가 발생한닥.

  ![image-20200427093322416](C:%5CUsers%5Cstudent%5CAppData%5CRoaming%5CTypora%5Ctypora-user-images%5Cimage-20200427093322416.png)

* 따라서 안드로이드에서 소켓 통신을 하기 위해서는 Thread를 이용한다.

  ```java
  public class Example25_ArduinoActivity extends AppCompatActivity {
  
      private TextView _25_statusTv;
      private Socket socket;
      private BufferedReader br;
      private PrintWriter pr;
  
      @Override
      protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_example25_arduino);
  
          _25_statusTv = (TextView) findViewById(R.id._25_statusTv);
  
          Button _25_ledOnBtn = (Button) findViewById(R.id._25_ledOnBtn);
          Button _25_ledOffBtn = (Button) findViewById(R.id._25_ledOffBtn);
  
          // Java Network Server 에 접속
          // Activity(UI Thread) 에서 Network 처리코드를 사용할 수 없다.
          // 별도의 Thread를 이용해서 처리해야 한다.
          // 1. Runnable 객체를 만든다
          Runnable r= new Runnable() {
              @Override
              public void run() {
                  try {
                      socket = new Socket("localhost", 8080);
                      br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                      pr = new PrintWriter(socket.getOutputStream());
                      Log.i("ArduinoTest","서버에 접속 성공!");
                  } catch (IOException e) {
                      Log.i("ArduinoTest", e.toString());
                  }
              }
          };
          // 2. Thread 객체를 생성한 후 실행.
          Thread t = new Thread(r);
          t.start();
  
          _25_ledOnBtn.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
  
              }
          });
  
          _25_ledOffBtn.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
  
              }
          });
  
  
      }
  }
  ```

* 버튼 클릭시 Stream 을 이용하여 서버에 데이터를 전송하면 되지만 이 과정 또한 네트워크 통신이기 때문에 Thread를 이용하여 전송해야 한다.

* 또한 버튼 클릭시 전송되는 데이터는 공용객체를 이용하여 전달한다.

