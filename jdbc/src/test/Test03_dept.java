package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.JdbcUtil;
import vo.DeptVO;

public class Test03_dept {

	public static void main(String[] args) {
		
		
		for(DeptVO data : deptList()) {
			
			System.out.printf("%2d  |   %-10s |  %-10s|\n",data.getDeptno(),data.getDname(),data.getLoc());
			
		}
		
		
	}

public static List<DeptVO> deptList() {
		
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
