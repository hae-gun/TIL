package market.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import market.connector.ConGenerator;
import market.vo.Customer;
import market.vo.Product;
import market.vo.Seller;
import market.vo.User;

public class MarketDaoImpl implements ProductOracleDao, UserOracleDao {

	private static MarketDaoImpl instance;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private MarketDaoImpl() {
		conn = ConGenerator.GetInsatance();
	}

	public static MarketDaoImpl getInstance() {

		if (instance == null) {
			instance = new MarketDaoImpl();
		}

		return instance;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(String id) {
		String sql = "select * from marketuser where id = ?";
		User user = null;
		String pw = "";
		String roll = "";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				pw = rs.getString("pw");
				roll = rs.getString("roll").toLowerCase();
				if ("seller".equals(roll)) {
					user = new Seller(id, pw);
					System.out.println("conn Seller");
				} else if ("customer".equals(roll)) {
					user = new Customer(id, pw);
					System.out.println("conn Customer");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (user != null)
			System.out.println("conn failed");
		return user;
	}

}
