package newMarket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import newMarket.connector.ConGenerator;

public class ProductDaoImpl implements ProductDao {
	
	
	private static ProductDaoImpl instance;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private ProductDaoImpl() {
		conn = ConGenerator.getInsatance();
	}
	
	
	public static ProductDaoImpl getInstance() {
		if(instance==null) {
			instance = new ProductDaoImpl();
		}
		return instance;
	}
	
	
	
	
	
}
