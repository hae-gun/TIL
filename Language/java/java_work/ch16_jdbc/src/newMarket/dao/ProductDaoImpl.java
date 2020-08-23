package newMarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import newMarket.connector.ConGenerator;
import newMarket.vo.Product;
import newMarket.vo.User;

public class ProductDaoImpl implements ProductDao {

	private static ProductDaoImpl instance;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private ProductDaoImpl() {
		conn = ConGenerator.getInsatance();
	}

	public static ProductDaoImpl getInstance() {
		if (instance == null) {
			instance = new ProductDaoImpl();
		}
		return instance;
	}

	@Override
	public List<Product> getAll() {
		String sql = "select * from product";
		List<Product> list = new ArrayList<Product>();

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String nsn = rs.getString("nsn");
				int type_no = rs.getInt("type_no");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				int amount = rs.getInt("amount");
				Product temp = new Product(nsn, type_no, name, price, amount);
				list.add(temp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Product searchNSN(String nsn) {
		Product product = null;
		String sql = "select * from product where nsn = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nsn);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String getNsn = rs.getString("nsn");
				int type_no = rs.getInt("type_no");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				int amount = rs.getInt("amount");

				product = new Product(getNsn, type_no, name, price, amount);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public int insertProduct(String nsn, int type_no, String name, int price, int amount) {
		int result = 0;
		String sql = "insert into product values(?,?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nsn);
			pstmt.setInt(2, type_no);
			pstmt.setString(3, name);
			pstmt.setInt(4, price);
			pstmt.setInt(5, amount);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("등록오류");
			result = 0;
		}

		return result;
	}

	@Override
	public int updateProduct(String nsn, int amount) {
		int result = 0;
//		System.out.println(nsn);
//		System.out.println(searchNSN(nsn));
		Product product = searchNSN(nsn);
//		System.out.println(product);
		int updateAmount = product.getAmount() + amount;
		if (updateAmount < 0) {
			System.out.println("제고부족");
			return result;
		}

		String sql = "update product set amount = ? where nsn = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, updateAmount);
			pstmt.setString(2, nsn);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("수정오류");
		}

		return result;
	}

	@Override
	public int orderProduct(String nsn, String id,String pw, int amount) {
		int result = 0;
		
		// get product point inform
		Product product = searchNSN(nsn);
		int point = product.getPrice() * amount;
		
		UserDaoImpl userdao = UserDaoImpl.getInstance();
		User user = userdao.login(id, pw);
		// update user point
		if (user.getPoint() >= point) {
			userdao.updatePoint(user, -point);
		} else {
			System.out.println(user.getPoint());
			System.out.println(point);
			System.out.println("point");
			return result;
		}
		
		// update product table
		if(product.getAmount()>=amount) {
			updateProduct(nsn, -amount);
		}else {
			System.out.println(product.getAmount());
			System.out.println(amount);
			System.out.println("product");
			return result;
		}
		
		// make order list
		result = makeOrderList(nsn, user.getId(),amount);
		

		return result;
	}

	@Override
	public int makeOrderList(String nsn, String id,int amount) {
		int result = 0;
		String sql = "insert into order_list(order_id,nsn,id,amount) values(BUY_SEQ.nextval,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nsn);
			pstmt.setString(2, id);
			pstmt.setInt(3, amount);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	

}
