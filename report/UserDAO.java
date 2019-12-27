package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.UserVO;





public class UserDAO {
	
	
		
		
		
	public UserVO login(String id, String pw) {
		
		UserVO SU = new UserVO();
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		
		String sql = "select * from users where id=? and pw=?"; // DB연동에 필요한 변수들.
		
		try {
			con = JdbcUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			// ? 값세팅 작업
			
			ps.setString(1,id);
			ps.setString(2,pw);
			
			
			
			rs = ps.executeQuery(); // select
			rs.next();
			try {
			SU.setId(rs.getString("id"));
			SU.setPw(rs.getString("pw"));
			}catch (Exception e) {
				SU.setId(null);
				SU.setPw(null);
			}
			
			//결과 값 처리
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(con, ps, rs);
		}
		
		
		
		return SU;
		
				
	}
	
	

}
