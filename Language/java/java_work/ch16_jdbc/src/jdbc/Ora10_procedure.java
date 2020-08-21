package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class Ora10_procedure {
	
	public static void main(String[] args) {

		Connection conn = ConGenerator.GetInsatance();
		// procedure 사용시 사용하는 객체.
		CallableStatement cstmt = null;

		if (conn != null) {
			String sql = "{call del_ename(?)}";
			
			try {
				cstmt = conn.prepareCall(sql);
				cstmt.setString(1, "최혜근");
				cstmt.executeQuery();
				cstmt.close();
				conn.close();
				System.out.println("종료");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		String[] split = "abcdf".split("");
		for(String s:split) {
			System.out.println(s);
		}
	}
	
}
