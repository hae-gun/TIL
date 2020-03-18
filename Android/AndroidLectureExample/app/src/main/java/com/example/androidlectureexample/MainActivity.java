package com.example.androidlectureexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
        Button _02_ClickBtn =
                (Button) findViewById(R.id._02_EventBtn);
        _02_ClickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                ComponentName cname = new ComponentName("com.example.androidlectureexample",
                        "com.example.androidlectureexample.Example02_EventActivity");
                i.setComponent(cname);
                startActivity(i);

            }
        });


    }
}
