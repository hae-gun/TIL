package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

// update
public class Ora05_update {
	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		String url = "jdbc:oracle:thin:@localhost:49161:xe";

		String user = "scott";
		String password = "TIGER";

		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("DB connected at localhost:49161!!!");
			conn.setAutoCommit(false);
//			stmt = conn.createStatement();
			// 값 입력
			System.out.println("empno(0000)>>> ");
			int ins_empno = Integer.parseInt(sc.nextLine());
			System.out.println("sal(0000)>>> ");
			int ins_sal = Integer.parseInt(sc.nextLine());

			String sql1 = "update emp set sal = "+ins_sal+" where empno = " + ins_empno;
			String sql2 = "select empno,ename,hiredate,sal from emp where empno = " + ins_empno;

			// update 할때 만약 sqlDeveloper 에서 update후에 commit을 안하면 데이터가 잡혀 진행이 안됨.
			int result = stmt.executeUpdate(sql1);
			if (result > 0) {
				System.out.println("저장 완료");
				rs = stmt.executeQuery(sql2);
				print(rs);
//				conn.commit();
			} else
				System.out.println("저장 실패");

//			System.out.println(rs.next());

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
				System.out.println("DB conncetion closed!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private static void print(ResultSet rs) {

		System.out.printf("empno\t %8s \t %10s \t sal\n", "ename", "hiredate");
		System.out.println("-----------------------------------------------------------");

		try {
			while (rs.next()) {

				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				Date hiredate = rs.getDate("hiredate");

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				sdf.format(hiredate);

				int sal = rs.getInt("sal");
				System.out.printf("%d \t %8s \t %10s \t %4d\n", empno, ename, hiredate, sal);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
