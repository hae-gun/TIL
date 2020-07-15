package test.com.abcde;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
		Connection conn = null;
		ResultSet rs = null;
		try {
			// 1. Driver Loading
			String driver = "org.apache.hive.jdbc.HiveDriver";
			Class.forName(driver);
			
			// 2. DataBase 접속
			String url = "jdbc:hive2://192.168.111.128:10000/hivedb"; // default PortNumber -> 10000
			String id = "hive";
			String pw = "hive";
			
			conn = DriverManager.getConnection(url,id,pw);
			
			// 3. Statement 생성
			String sql = "select count(*) from mytlb";
			Statement stmt = conn.createStatement();
			
			// 4. Query 실행
			rs = stmt.executeQuery(sql);
			
			// 5. 결과처리
			rs.next();
			int count = rs.getInt(1); // count(*) 값을 가져옴. 결과는 0
			System.out.println("얻어온 데이터 수: " + count);
			
			// 6. resource 해제
			rs.close();
			stmt.close();
			conn.close();
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
