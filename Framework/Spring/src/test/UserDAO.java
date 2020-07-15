package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;





public class UserDAO {
	
		
	
		public void deleteUsers(String id, String pw) {
		
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0; //dml결과값
		
		
		String sql = "delete from Users where id=? and pw=?"; // DB연동에 필요한 변수들.
		
		try {
			con = JdbcUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			// ? 값세팅 작업
			
			ps.setString(1 ,id);
			ps.setString(2 ,pw);
			
			row = ps.executeUpdate(); // DML 
			
			//결과 값 처리
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(con, ps, rs);
		}
		
	}
	
		
		public void insertUser(String id, String pw) {
			
			Connection con =null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			int row = 0; //dml결과값
			
			
			String sql = "insert into Users (id,pw) "+ "values(?,?)"; // DB연동에 필요한 변수들.
			
			try {
				con = JdbcUtil.getConnection();
				ps = con.prepareStatement(sql);
				
				// ? 값세팅 작업
					
					
					ps.setString(1, id);
					ps.setString(2, pw);
				
					row = ps.executeUpdate();
				
				//결과 값 처리
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				JdbcUtil.close(con, ps, rs);
			}
			
		}
	
		
		
		
	public UserVO login(String id, String pw) {
		
		
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0; //dml결과값
		
		
		UserVO SU = new UserVO();
		String sql = "select * from Users where id=? and pw=?"; // DB연동에 필요한 변수들.
		
		try {
			con = JdbcUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			// ? 값세팅 작업
			
			ps.setString(1,id);
			ps.setString(2,pw);
			
			
			
			rs = ps.executeQuery(); // select
			
				while(rs.next()) {
				
				SU.setId(rs.getString("id"));
				SU.setPw(rs.getString("pw"));
				
			}	
			
			
			//결과 값 처리
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(con, ps, rs);
		}
		
		return SU;
			
			
		
	}
	
	
	public List<UserVO> userList() {
		
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0; //dml결과값
		
		
		String sql = "select * from Users"; // DB연동에 필요한 변수들.
		List<UserVO> list = new ArrayList<UserVO>();
		try {
			
			con = JdbcUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			// ? 값세팅 작업
			
			rs = ps.executeQuery(); // select
			
			while(rs.next()) {
				
				UserVO vo = new UserVO(
								rs.getString("id"),
								rs.getString("pw")
								);
				list.add(vo);
			}	
				
				
				
			//결과 값 처리
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(con, ps, rs);
		}
		return list;
	}

}
