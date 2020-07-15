package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test01 {

	public static void main(String[] args) {
		System.out.println("JDBC TEST");
		
		String driver="oracle.jdbc.OracleDriver"; // 특정 DB정보. 컴파일이 아니라 runtime에서 결정될 정보.
		String url="jdbc:oracle:thin:@127.0.0.1:1521:xe"; // 환경설정으로 밖으로 나갈 정보.
		String user="SCOTT";
		String pw="TIGER";
		
		String sql = "select * from dept"; // 오타없이 완벽하게 동작해야함.
		
		Connection con = null; // 특정DB에 연결
		PreparedStatement ps = null; // sql구문 관리
		ResultSet rs = null; // select문 의 결과값 표. dml(insert delete update) 결과값은 int가 나옴.
		
		try {
			//1. Driver클래스를 로딩
			Class.forName(driver);//메모리에 올라가 관리.
			
			//2. 로딩된 Driver클래스를 이용해서 Connection요청(url, user, pwd)
			con = DriverManager.getConnection(url,user,pw); 
			
			//3. 생성된Connection으로부터 Statement생성
			ps = con.prepareStatement(sql);
			
			//4. 생성된 Statement를 이용해서 sql수행(execute, executeUpdate, executeQuery)
			rs = ps.executeQuery(); // 결과값이 들어감.
			
			//5. 결과 처리(ResultSet, int)
			while(rs.next()) {
				System.out.print(rs.getString("deptno")+" ");
				System.out.print(rs.getString("dname")+" ");
				System.out.print(rs.getString("loc")+" ");
				System.out.println("\n-------------------");
			}
			
			
			
//			System.out.println(con);
		} catch (Exception e) {
			//6. SQLException 처리(try, catch, finally)
			System.out.println(e);
		} finally {
			//7. 자원정리(connection, statement, resultset)
			try {
				if(rs != null)	rs.close();
				if(ps != null)	ps.close();
				if(con != null)	con.close();
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
		
		System.out.println("JDBC TEST END");
		
		
		
	}

}
