package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Ora08_pstmt {
	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		
		
		
		String url = "jdbc:oracle:thin:@localhost:49161:xe";
		String user = "scott";
		String password = "TIGER";

		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("DB connected at localhost:49161!!!");

			
			// 값 입력
			System.out.println("empno(0000)>>> ");
			int ins_empno = Integer.parseInt(sc.nextLine());
			System.out.println("ename(jack)>>> ");
			String ins_ename = sc.nextLine();
			// hiredate : sysdate 로 처
			System.out.println("sal(0000)>>> ");
			int ins_sal = Integer.parseInt(sc.nextLine());

			String sql1 = "insert into emp(empno, ename,hiredate,sal)" + " values(?,?,sysdate,?)";
			String sql2 = "select empno,ename,hiredate,sal from emp where empno = "+ins_empno;

			pstmt1 = conn.prepareStatement(sql1);
			
			pstmt1.setInt(1, ins_empno);
			pstmt1.setString(2, ins_ename);
			pstmt1.setInt(3, ins_sal);
			
			pstmt2 = conn.prepareStatement(sql2);

			int result = pstmt1.executeUpdate();
			
//			int result = stmt.executeUpdate(sql1);
			if (result > 0) {
				System.out.println("저장 완료");
				rs = pstmt2.executeQuery();
				print(rs);
			} else
				System.out.println("저장 실패");

//			System.out.println(rs.next());

			

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt1!=null) pstmt1.close();
				if(pstmt2!=null) pstmt2.close();
				if(conn!=null) conn.close();
				System.out.println("DB conncetion closed!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private static void print(ResultSet rs) {
		
		System.out.printf("empno\t %8s \t %10s \t sal\n", "ename","hiredate");
		System.out.println("-----------------------------------------------------------");

		try {
			while (rs.next()) {
				
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				Date hiredate = rs.getDate("hiredate");
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
				sdf.format(hiredate);
				
				int sal = rs.getInt("sal");
				System.out.printf("%d \t %8s \t %10s \t %4d\n", empno, ename, hiredate,sal);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
