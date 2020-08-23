package newMarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import newMarket.connector.ConGenerator;
import newMarket.vo.Order_List;
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
//		boolean flag = false;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				flag = true;
//			}
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

	@Override
	public User searchUser(String id) {
		User user = null;
		String sql = "select * from market_user where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public int registerUser(String id, String pw, String roll) {
		String sql = "insert into market_user(id,pw,roll) values(?,?,?)";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, roll);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<User> getUserList() {
		List<User> list = new ArrayList<User>();
		String sql = "select * from market_user where roll = 'customer'";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getString("id"));
				user.setPoint(rs.getInt("point"));
				user.setRoll(rs.getString("roll"));
				list.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public int updatePoint(User user, int point) {
		int result = 0;
		if (user.getPoint() + point < 0) {
			System.out.println("충전실패.");
			return 0;
		}

		user.setPoint(user.getPoint() + point);

		String sql = "update market_user set point = ? where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, user.getPoint());
			pstmt.setString(2, user.getId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Order_List> getOrderList(User user) {
		List<Order_List> list = new ArrayList<Order_List>();
		String sql = "select * from order_list where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int order_id = rs.getInt("order_id");
				String nsn = rs.getString("nsn");
				String id = rs.getString("id");
				Date date = rs.getDate("ORDER_DATE");
				int amount = rs.getInt("amount");
				Order_List order = new Order_List(order_id, nsn, id, date, amount);
				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

}
