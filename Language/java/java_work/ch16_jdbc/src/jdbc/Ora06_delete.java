package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Ora06_delete {
	// empno 입력 받아서 delete
		public static void main(String[] args) {
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			Scanner sc = new Scanner(System.in);

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "SCOTT";
			String password = "TIGER";
			try {
				// 커넥션 생성
				conn = DriverManager.getConnection(url, user, password);
				System.out.println("DB connected!!!");
				// Statement 생성
				stmt = conn.createStatement();
				// 값 입력받음
				System.out.println("empno(0000)>>> ");
				int ins_empno = Integer.parseInt(sc.nextLine());
				
				// sql 정의
				String sql1 = "delete emp where empno = " + ins_empno;
				String sql2 = "select empno, ename, hiredate, sal from emp";// where empno = " + ins_empno;
				System.out.println(sql1);
				// conn.setAutoCommit(false);
				int result = stmt.executeUpdate(sql1);
				System.out.println(result);
				if (result > 0) {
					System.out.println("삭제 완료!");
					rs = stmt.executeQuery(sql2);
					// conn.commit();
					print(rs);
				} else
					System.out.println("삭제 실패, 관리자에게 문의 요망");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if (rs != null)
						rs.close();
					if (stmt != null)
						stmt.close();
					if (conn != null)
						conn.close();
					System.out.println("DB connection closed!");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		private static void print(ResultSet rs) {
			try {
				while (rs.next()) {
					int empno = rs.getInt("empno");
					String ename = rs.getString("ename");
					Date hiredate = rs.getDate("hiredate");
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
					sdf.format(hiredate);
					int sal = rs.getInt("sal");
					System.out.printf("%d \t %s   \t %s \t %d \n", empno, ename, hiredate, sal);
					System.out.println("----------------------------------------------");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

}
