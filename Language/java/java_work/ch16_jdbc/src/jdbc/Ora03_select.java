package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


// Scanner로 부서번호 입력받아 급여 가장 많은 3사람만 empno,ename,sal 출력
public class Ora03_select {
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
			
			
			stmt = conn.createStatement();
			System.out.println("부서번호를 입력하세요>>> ");
			int deptno= sc.nextInt();
			
			String sql= "select a.empno, a.ename, a.sal from (select * from emp where deptno = "
			+deptno+" order by sal desc) a where rownum <= 3";
			
			rs = stmt.executeQuery(sql);
//			System.out.println(rs.next());
			
			System.out.printf("empno\t %8s \t sal\n","ename");
			System.out.println("-------------------------------");
			
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				int sal = rs.getInt("sal");
				System.out.printf("%d \t %8s \t %4d\n",empno,ename,sal);
			}
			
		
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
