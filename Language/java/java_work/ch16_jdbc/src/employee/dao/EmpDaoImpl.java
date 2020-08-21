package employee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import employee.dto.Employee;

public class EmpDaoImpl implements EmpDao {

	private static EmpDaoImpl singleton;

	private EmpDaoImpl() {

	}

	public static EmpDao getInstance() {

		if (singleton == null) {
			singleton = new EmpDaoImpl();
		}
		return singleton;
	}

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private boolean conect() {
		boolean result = false;
		try {
			String url = "jdbc:oracle:thin:@localhost:49161:xe";
			String user = "scott";
			String password = "TIGER";
			conn = DriverManager.getConnection(url, user, password);
			result = true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	private void close() {
		try {
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {

		}
	}
	
	@Override
	public List<Employee> selectAll() {
		List<Employee> li = new ArrayList<Employee>();
		if(conect()) {
			String sql = "select * from employee";
			try {
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					
//					int bunho = rs.getInt("bunho");
//					String name = rs.getString("name");
//					Date birth = rs.getDate("birth");
//					String tel = rs.getString("tel");
//					String addr = rs.getString("addr");
//					String email = rs.getString("email");
					
//					Employee emp = new Employee(bunho, name, birth, tel, addr, email);
					Employee emp = new Employee();					
					emp.setBunho(rs.getInt("bunho"));
					emp.setName(rs.getString("name"));
					emp.setBirth(rs.getDate("birth"));
					emp.setTel(rs.getString("tel"));
					emp.setAddr(rs.getString("addr"));
					emp.setEmail(rs.getString("email"));
					
					
					li.add(emp);
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		close();
		return li;
	}

	@Override
	public List<Employee> selectName(String name) {
		List<Employee> li = new ArrayList<Employee>();
		if(conect()) {
			String sql = "select * from employee where name like ?";
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+name+"");
				rs = pstmt.executeQuery();
				while(rs.next()) {
					

					Employee emp = new Employee();					
					emp.setBunho(rs.getInt("bunho"));
					emp.setName(rs.getString("name"));
					emp.setBirth(rs.getDate("birth"));
					emp.setTel(rs.getString("tel"));
					emp.setAddr(rs.getString("addr"));
					emp.setEmail(rs.getString("email"));
					
					
					li.add(emp);
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return li;
	}

	@Override
	public boolean insertEmployee(Employee emp) {
		String sql1 = "insert into employee values(?,?,?,?,?,?)";
		System.out.println(emp);
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql1);
			pstmt.setInt(1, emp.getBunho());
			pstmt.setString(2, emp.getName());
			pstmt.setDate(3, (java.sql.Date) emp.getBirth());
			pstmt.setString(4, emp.getTel());
			pstmt.setString(5, emp.getAddr());
			pstmt.setString(6, emp.getEmail());
			
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		if(result >0) {
			return true;
		}
		return false;
	}
	
	
	

}
