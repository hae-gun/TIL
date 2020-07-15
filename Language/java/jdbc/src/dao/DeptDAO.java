package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.JdbcUtil;
import vo.DeptVO;

public class DeptDAO {
	
		
	
		public void deleteDept(int deptno) {
		
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int row = 0; //dml결과값
		
		
		String sql = "delete from dept where deptno=?"; // DB연동에 필요한 변수들.
		
		try {
			con = JdbcUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			// ? 값세팅 작업
			
			ps.setInt(1 ,deptno);
			row = ps.executeUpdate(); // DML 
			
			//결과 값 처리
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(con, ps, rs);
		}
		
	}
	
		
		public void insertDept(String dname, String loc) {
			
			Connection con =null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			int row = 0; //dml결과값
			
			
			String sql = "insert into dept (deptno,dname,loc) "+ "values((select nvl(max(deptno),0)+1 from dept),?,?)"; // DB연동에 필요한 변수들.
			
			try {
				con = JdbcUtil.getConnection();
				ps = con.prepareStatement(sql);
				
				// ? 값세팅 작업
					
					
					ps.setString(1, dname);
					ps.setString(2, loc);
				
					row = ps.executeUpdate();
				
				//결과 값 처리
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				JdbcUtil.close(con, ps, rs);
			}
			
		}
		
		public List<DeptVO> deptList() {
			
			Connection con =null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			int row = 0; //dml결과값
			
			
			String sql = "select * from dept order by deptno"; // DB연동에 필요한 변수들.
			List<DeptVO> list = new ArrayList<DeptVO>();
			try {
				
				con = JdbcUtil.getConnection();
				ps = con.prepareStatement(sql);
				
				// ? 값세팅 작업
				
				rs = ps.executeQuery(); // select
				
				while(rs.next()) {
					
					DeptVO vo = new DeptVO(
									rs.getInt("deptno"),
									rs.getString("dname"),
									rs.getString("loc")
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

