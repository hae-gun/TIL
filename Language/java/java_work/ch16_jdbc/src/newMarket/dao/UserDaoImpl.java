package newMarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import newMarket.connector.ConGenerator;
import newMarket.vo.User;

public class UserDaoImpl implements UserDao {

	private static UserDaoImpl instance;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private UserDaoImpl() {
		conn = ConGenerator.getInsatance();
	}

	public static UserDaoImpl getInstance() {
		if (instance == null) {
			instance = new UserDaoImpl();
		}
		return instance;
	}

	@Override
	public User login(String id, String pw) {
		String sql = "select * from market_user where id = ? and pw = ?";
		boolean flag = false;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				flag = true;
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String getId = rs.getString("id");
				String getPw = rs.getString("pw");
				String roll = rs.getString("roll");
				int point = rs.getInt("point");
				return new User(getId, getPw, roll, point);
//				System.out.printf("%s - %s - %s - %d\n",getId,getPw,roll,point);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
