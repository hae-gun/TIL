package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ora02_Statement {
	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String url = "jdbc:oracle:thin:@localhost:49161:xe";

		String user = "scott";
		String password = "TIGER";

		try {
			// 커넥션 생성.
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("DB connected!!!");
			
			// Statement 생성.
			stmt = conn.createStatement();
			// SQL 정의
			
			String sql = "SELECT * FROM dept";
			
			rs= stmt.executeQuery(sql);
			
			//System.out.println(rs.next());
			System.out.println("부서번호\t 부서 이름 \t 부서 위치");
			
			// 반환된 set 객체로부터 한 행씩 뽑고 그 행의 컬럼값을 받아 처리.
			while(rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				System.out.printf("%d \t %s \t %s\n",deptno,dname,loc);
			}
			
			
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
				System.out.println("DB conncetion closed!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
