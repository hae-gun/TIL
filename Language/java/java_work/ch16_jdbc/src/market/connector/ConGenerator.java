package market.connector;

import java.io.FileReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConGenerator {
	
	private static Connection conn;
	
	private ConGenerator() {
		
	}
	// Connection 객체 생성해서 반환하는 메소드 - 생성된 객체가 있으면 그것을 반환하고 없으면 생성해서 반환함 - 2개 이상 생성 안됨.
	public static Connection GetInsatance() {
//		Connection conn = null;

		Properties db = new Properties();
		String path = ConGenerator.class.getResource("database.properties").getPath();
		try {
			path = URLDecoder.decode(path, "utf-8");
			System.out.println(path);
			db.load(new FileReader(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		//String driver = db.getProperty("driver");
		String url = db.getProperty("url");
		String user = db.getProperty("username");
		String password = db.getProperty("password");
		
		if(conn==null) {
			try {
				conn=DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
		return conn;
	}
	
}	
