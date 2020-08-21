package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

// 부서번호 10번의 loc를 '서울' 로 바꾸고  empno, ename, dname, loc를 출력.
public class Ora09_pstmtExample {
	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);

		conn = ConGenerator.GetInsatance();
		if (conn != null) {

			System.out.println("deptno(00)>>");
			int deptno = Integer.parseInt(sc.nextLine());
			System.out.println("loc(london)>>");
			String update_dname = sc.nextLine();

			String sql1 = "update dept set loc = ? where deptno = ?";
			String sql2 = "select empno,ename,dname,loc from emp,dept where emp.deptno = dept.deptno";

			try {
				pstmt1 = conn.prepareStatement(sql1);
				pstmt1.setString(1, update_dname);
				pstmt1.setInt(2, deptno);
//
				pstmt2 = conn.prepareStatement(sql2);


				int result = pstmt1.executeUpdate();

				
				if (result > 0) {
					System.out.println("update succeed");
					rs = pstmt2.executeQuery();
					print(rs);
				} else
					System.out.println("update fail");
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	private static void print(ResultSet rs) {

		System.out.printf("empno\t %8s \t %10s \t loc\n", "ename", "dname");
		System.out.println("--------------------------------------------------");

		try {
			while (rs.next()) {


				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");

				System.out.printf("%d \t %8s \t %10s \t %6s\n", empno, ename, dname, loc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
