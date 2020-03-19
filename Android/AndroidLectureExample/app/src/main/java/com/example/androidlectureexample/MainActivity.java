package com.example.androidlectureexample;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button _01_linearlayoutBtn =
                (Button) findViewById(R.id._01_linearlayoutBtn);
        _01_linearlayoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 버튼이 눌리면 이 부분이 실행되요!!
                // 새로운 activity를 찾아서 실행!!
                // 2가지 방식으로 activity를 찾을 수 있다.
                // explicit 방식과 implicit 방식이 있다.
                Intent i = new Intent(); // explicit 방식.
                ComponentName cname = new ComponentName("com.example.androidlectureexample",
                        "com.example.androidlectureexample.Example01_LayoutActivity");
                //ComponentName(패키지명,클래스이름(패키지풀name으로))
                i.setComponent(cname); // Intent에 클래스 부착
                startActivity(i); // Intent 시작!

            }
        });
        Button _02_EventBtn =
                (Button) findViewById(R.id._02_EventBtn);
        _02_EventBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                ComponentName cname = new ComponentName("com.example.androidlectureexample",
                        "com.example.androidlectureexample.Example02_EventActivity");
                i.setComponent(cname);
                startActivity(i);

            }
        });

        Button _03_Event2Btn =
                (Button) findViewById(R.id._03_Event2Btn);
        _03_Event2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                ComponentName cname = new ComponentName("com.example.androidlectureexample",
                        "com.example.androidlectureexample.Example03_Event2Activity");
                i.setComponent(cname);
                startActivity(i);
            }
        });
        Button _04_ActivityEventBtn =
                (Button) findViewById(R.id._04_ActivityEventBtn);
        _04_ActivityEventBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                ComponentName cname = new ComponentName("com.example.androidlectureexample",
                        "com.example.androidlectureexample.Example04_TouchEventActivity");
                i.setComponent(cname);
                startActivity(i);
            }
        });
        Button _05_SwipeEventBtn =
                (Button) findViewById(R.id._05_SwipeEventBtn);
        _05_SwipeEventBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                ComponentName cname = new ComponentName("com.example.androidlectureexample",
                        "com.example.androidlectureexample.Example05_SwipeEventActivity");
                i.setComponent(cname);
                startActivity(i);
            }
        });
        Button _06_SendMessageBtn =
                (Button) findViewById(R.id._06_SendMessageBtn);
        _06_SendMessageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aler창 (dialog) 를 이용하여 문자열을 입력받고 입력받은 문자열을 다음 `Activity`로 전달.

                // 사용자가 문자열을 입력할 수 있는 widget을 하나 생성
                final EditText edittext = new EditText(MainActivity.this); //(컨텍스트 객체)
                // AlertDialog를 하나 생성.
                AlertDialog.Builder builder =
                        new AlertDialog.Builder(MainActivity.this);// Diaglog 만드는놈. 컨텍스트 추가
                builder.setTitle("Activity 데이터 전달"); //제목
                builder.setMessage("다음 Activity에 전달할 내용을 입력하세요");
                builder.setView(edittext); // 입력상자
                builder.setPositiveButton("전달", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 전달을 눌렀을때 수행되는 이벤트 처리작업을 하면된다.
                        Intent i = new Intent();
                        ComponentName cname = new ComponentName("com.example.androidlectureexample",
                                "com.example.androidlectureexample.Example06_SendMessageActivity");
                        i.setComponent(cname);
                        // 데이터를 전달해서 Activity를 시작해야 한다.
                        i.putExtra("sendMSG",
                                edittext.getText().toString());
                        // getText()는 문자열이 아닌 Character Sequence로 가져옴.
                        // Intent에 여러가지를 붙일수 있다.
                        startActivity(i);
                    }

                }); // (텍스트, 이벤트핸들러)
                builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 취소버튼이기 때문에 특별한 이벤트 처리가 필요없다.
                    }
                });
                builder.show();
            }
        });

        Button _07_DataFromBtn =
                (Button) findViewById(R.id._07_DataFromBtn);
        _07_DataFromBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                ComponentName cname = new ComponentName("com.example.androidlectureexample",
                        "com.example.androidlectureexample.Example07_DataFromActivity");
                i.setComponent(cname);
                // 새로 생성되는 Activity로부터 데이터를 받아오기 위한 용도
                // 두번째 Activity가 finsh되는 순간 데이터를 받아옴.
                startActivityForResult(i,3000); //(Intent,requestCode) Code는 숫자의미x 유니크한값으로 맘대로 지정.
                //requestCode : 호출한 Activity를 판별하기 위한 코드.
            }
        });

    }// end of onCreate()

    // Activity 에게 결과값이 도착했을때 실행되는 callback method
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==3000 && resultCode == 7000){
            String msg = (String)data.getExtras().get("ResultValue");
            Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
        }
    }
}
