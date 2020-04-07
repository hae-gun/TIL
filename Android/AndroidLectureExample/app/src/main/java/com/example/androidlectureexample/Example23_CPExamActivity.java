package com.example.androidlectureexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/* Content Provider (내용제공자)
 *  App 에서 관리하는 데이터(SQLite Database)를 다른 App 이 접근할 수 있도록 해주는 기능을 한다.
 *  CP 는 Android 구성요소중의 하나로 안드로이드 시스템에 의해서 관리된다.
 *  AndroidManifest.xml 파일에 등록해서 사용하게된다.
 *  CP가 필요한 이유는 보안규정 때문이다.
 *  안들외드 App은 오직 자신의 App 안에서 생성한 데이터만 사용할 수 있다.
 *  다른 App 이 가지고 있는 데이터의 접근권한이 없다.
 *  CP 를 이용하면 다른 App 의 데이터에 접근할 수 있다.
 *  CP 를 이용해서 다른 App 의 데이터에 접근하는데 일반적으로 Database 에 접근하는 방식을 이용한다.
 *  그 이유는 CP 가 CRUD 를 기반으로 하고 있기 때문이다.
 *
 *  1. 데이터베이스(SQLite)를 이용하기 때문에 SQLiteOpenHelper class 를 이용해서 DB 를 이용한다.
 */

// SQLiteOpenHelper 이용.
// PersonDatabaseHelper 객체를 만들면 Database 가 생성되고 Table 이 만들어 진다.
class PersonDatabaseHelper extends SQLiteOpenHelper {

    PersonDatabaseHelper(Context context) {
        super(context, "person.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // 데이터베이스가 초기에 만들어지는 시점에
        // Table 도 같이 만든다.

        String sql = "CREATE TABLE IF NOT EXISTS " +
                "person( _id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, " +
                "age INTEGER, " +
                "mobile TEXT)";
        db.execSQL(sql);

        Log.i("DBTest", "Table 생성 완료");
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // 일단 제외.
    }
}

public class Example23_CPExamActivity extends AppCompatActivity {
    private Uri uri ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example23_cp_exam);

        Button _23_empInsertBtn = findViewById(R.id._23_empInsertBtn);
        _23_empInsertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 원래는 입력된 데이터를 가지고 와서 CP 를 이용해서 입력처리!
                // CP 를 찾아야 한다.
                String uriString = "content://com.exam.person.provider/person";

                // 문자를 uri 로 만듬.
                uri = new Uri.Builder().build().parse(uriString);

                // HashMap 형태로 데이터베이스에 입력할 데이터를 저장.
                ContentValues values = new ContentValues();
                values.put("name","홍길동");
                values.put("age",20);
                values.put("mobile","010-1111-5555");

                getContentResolver().insert(uri,values); // ContentProvider 과 대응되는 것. ContentProvider 를 찾는다.
                Log.i("DBTest","데이터 입력 완료");
            }
        });

        final TextView  _23_resultTv = findViewById(R.id._23_resultTv);


//        Button _23_empSelectBtn = findViewById(R.id._23_empSelectBtn);
//        _23_empSelectBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                _23_resultTv.setText("");
//                String sql = "SELECT _id, name, age, mobile FROM person";
//                // JDBC 와 상당히 유사하다.
//
//                // execSQL() : select 계열이 아닌 SQL 문장을 실행할때 사용.
//                // rawQuery() : select 계열의 SQL 문장을 실행할때 사용
//                // 커서는 위치를 가르키는 포인터 => 컬럼을 가르키는 포인터
//                String[] mSelctionArgs = {""};
//                Cursor cursor = getContentResolver().query(uri, null, "WHERE name = '홍길동'",mSelctionArgs,"_id ASC" );
//
//                while (cursor.moveToNext()) {
//                    int id = cursor.getInt(0);
//                    String name = cursor.getString(1);
//                    int age = cursor.getInt(2);
//                    String mobile = cursor.getString(3);
//
//                    String result = "레코드 : " + id + ", " + name + ", " + age + ", " + mobile;
//                    _23_resultTv.append(result+"\n");
//                }
//            }
//        });
    }





}
