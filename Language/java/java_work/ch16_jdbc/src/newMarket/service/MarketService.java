package newMarket.service;

import java.util.Scanner;

import newMarket.dao.ProductDao;
import newMarket.dao.ProductDaoImpl;
import newMarket.dao.UserDao;
import newMarket.dao.UserDaoImpl;
import newMarket.vo.User;

public class MarketService {
	
	private UserDao userDao = UserDaoImpl.getInstance();
	private ProductDao productDao = ProductDaoImpl.getInstance();
	private Scanner scan;
	public MarketService(Scanner scan) {
		this.scan = scan;
	}

	public User login() {
		User user = null;
		System.out.println("id>> ");
		String id = scan.nextLine();
		System.out.println("pw>> ");
		String pw = scan.nextLine();
		if((user = userDao.login(id,pw))!=null) {
			System.out.println("로그인 성공");
		}else {
			System.out.println("로그인 실패");
		}
		return user;
	}

	public void registerUser() {
		
		
	}
	
	
	
	
}
