package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import util.JdbcUtil;

public class Test02 {

	public static void main(String[] args) {
		System.out.println("JDBC TEST");
		
		
		
		String sql = "select * from emp where deptno = ? and sal > ?"; // 오타없이 완벽하게 동작해야함.
		
		
		
		
		Connection con = null; // 특정DB에 연결
		PreparedStatement ps = null; // sql구문 관리 "'?'가 있는 sql구문 처리하는 곳." Statement는 ?처리 불가능하다.
		ResultSet rs = null; // select문 의 결과값 표. dml(insert delete update) 결과값은 int가 나옴.
		
		try {
			
			con = JdbcUtil.getConnection();
			
			//3. 생성된Connection으로부터 Statement생성
			ps = con.prepareStatement(sql);
			
			// ? 값 세팅
			
			String deptno = JOptionPane.showInputDialog("deptno");		
			ps.setInt(1,Integer.parseInt(deptno));
			String sal = JOptionPane.showInputDialog("sal");		
			ps.setInt(2,Integer.parseInt(sal));
			
			
			
			
			//4. 생성된 Statement를 이용해서 sql수행(execute, executeUpdate, executeQuery)
			rs = ps.executeQuery(); // 결과값이 들어감.
			//5. 결과 처리(ResultSet, int)
			while(rs.next()) {
				System.out.print(rs.getString("ename")+" ");
				System.out.print(rs.getString("sal")+" ");
				System.out.print(rs.getString("job")+" ");
				System.out.print(rs.getDate("hiredate")+" ");
				System.out.print(rs.getInt("deptno")+" ");
				System.out.println("\n------------------------------------");
			}
			
			
			
//			System.out.println(con);
		} catch (Exception e) {
			//6. SQLException 처리(try, catch, finally)
			System.out.println(e);
		} finally {
			//7. 자원정리(connection, statement, resultset)
			JdbcUtil.close(con,ps,rs);
		}
		
		System.out.println("JDBC TEST END");
		
		
		
	}

}
