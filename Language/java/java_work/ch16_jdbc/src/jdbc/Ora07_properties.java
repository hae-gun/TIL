package jdbc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Ora07_properties {
	public static void main(String[] args) {

		Connection conn = null;
		
		Properties db = new Properties();
		String path = Ora07_properties.class.getResource("database.properties").getPath();
		try {
			path = URLDecoder.decode(path, "utf-8");
			System.out.println(path);
			db.load(new FileReader(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		//String driver = db.getProperty("driver");
		String url = db.getProperty("url");
		String username = db.getProperty("username");
		String password = db.getProperty("password");
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		
		try {
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("DB connected!!!");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				System.out.println("DB connection closed!");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
