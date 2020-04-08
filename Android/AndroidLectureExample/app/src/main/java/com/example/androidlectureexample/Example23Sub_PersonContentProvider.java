package com.example.androidlectureexample;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.util.Log;

public class Example23Sub_PersonContentProvider extends ContentProvider {

    // URI 형식 ( content provider 를 찾기위한 특수한 문자열)
    // content://Authority/BASE_PATH(테이블이름)
    // 예 ) content://com.exam.person.provider/

    private SQLiteDatabase database; // Database 를 사용하려면 이게 있어야 한다. (DB Handle)

    public Example23Sub_PersonContentProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        Log.i("DBTest", "CP 의 insert 호출");
        // database table 에 insert 하는 방법중 하나. SQL 문장을 이용하지 않고.
        // ContentValues values 에 key, value 형태로 입력할 데이터를 묘사.
        database.insert("person", null, values);
        return uri;
    }

    @Override
    public boolean onCreate() {
        Log.i("DBTest", "CP 의 onCreate() 실행");
        // 여기에서 Database 생성 및 Table 생성에 관한 코드가 나오면 된다.
        // Database reference 를 획득하는 코드도 나오면 된다.
        PersonDatabaseHelper helper = new PersonDatabaseHelper(getContext());
        database = helper.getWritableDatabase();

        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        // TODO: Implement this to handle query requests from clients.
        Log.i("DBTest", "query() 실행");
        // 1번째 인자 : table 명
        // 2번째 인자 : projection : select 에서 가져올 컬럼명을 문자배열로 표현.
        // 3번째 인자 : selection : where 절 조건을 명시.
        // 4번째 인자 : selection 의 In Parameter 의 값.
        // 5번째 인자 : Group by 방법
        // 6번째 인자 : having 절
        // 7번째 인자 : 정렬방법
        Cursor cursor = database.query("person",
                projection, selection, selectionArgs,null,null, sortOrder);

        return cursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
