package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ora01_Connection {
	public static void main(String[] args) {

		Connection conn = null;

		String url = "jdbc:oracle:thin:@localhost:49161:xe";

		String user = "scott";
		String password = "TIGER";

		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("DB connected!!!");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				System.out.println("DB conncetion closed!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
