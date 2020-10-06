package emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class EmpDao {
	private DataSource dataFactory;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public EmpDao() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void register(EmpVo vo) {
		
		try {
			conn = dataFactory.getConnection();
			String query = "INSERT INTO EMPTABLE (EMPNO, ENAME, EMPID, EMPPASSWORD, EMAIL, SALARY)"
					+ " VALUES (?, ? ,?, ?, ?, ?)";
			int empno = vo.getEmpNo();
			String ename = vo.getEname();
			String empid = vo.getEmpId();
			String emppassword = vo.getEmpPassword();
			String email = vo.getEmail();
			int salary = vo.getSalary();
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, empno);
			pstmt.setString(2, ename);
			pstmt.setString(3, empid);
			pstmt.setString(4, emppassword);
			pstmt.setString(5, email);
			pstmt.setInt(6, salary);
			
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public List<EmpVo> getAllMember() {
		ArrayList<EmpVo> list = new ArrayList<EmpVo>();
		try {
			conn= dataFactory.getConnection();
			String query = "select * from EMPTABLE";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int empno = rs.getInt(1);
				String ename = rs.getString(2);
				String empid = rs.getString(3);
				String emppassword = rs.getString(4);
				String email = rs.getString(5);
				int salary = rs.getInt(6);;
				Date joindate = rs.getDate(7);
				int sales = rs.getInt(8);
				EmpVo empVo = new EmpVo(empno, ename, empid, emppassword, email, salary,joindate,sales);
				list.add(empVo);
			}
			
			
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return list;
	}

	public EmpVo getUser(String id, String pw) {
		EmpVo empVo=null;
		try {
			conn = dataFactory.getConnection();
			String query = "select * from EMPTABLE where EMPID=? and EMPPASSWORD=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,id);
			pstmt.setString(2,pw);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int empno = rs.getInt(1);
				String ename = rs.getString(2);
				String empid = rs.getString(3);
				String emppassword = rs.getString(4);
				String email = rs.getString(5);
				int salary = rs.getInt(6);;
				Date joindate = rs.getDate(7);
				int sales = rs.getInt(8);
				empVo = new EmpVo(empno, ename, empid, emppassword, email, salary,joindate,sales);
			}
			System.out.println(empVo);
			
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empVo;
	}
	
}
