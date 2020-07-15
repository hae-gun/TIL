package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.JdbcUtil;

public class Jdbc_template {

	public static void main(String[] args) {

		
	}
				
	
	
	//JDBC Template
	public void temp() {
		
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0; //dml결과값
		
		
		String sql = "select ~~~"; // DB연동에 필요한 변수들.
		
		try {
			con = JdbcUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			// ? 값세팅 작업
			
			rs = ps.executeQuery(); // select
			row = ps.executeUpdate(); // DML 
			
			//결과 값 처리
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(con, ps, rs);
		}
		
	}
	
	
}
