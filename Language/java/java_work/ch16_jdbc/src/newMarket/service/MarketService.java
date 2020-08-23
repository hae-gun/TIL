package newMarket.service;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import newMarket.dao.ProductDao;
import newMarket.dao.ProductDaoImpl;
import newMarket.dao.UserDao;
import newMarket.dao.UserDaoImpl;
import newMarket.vo.Order_List;
import newMarket.vo.Product;
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

		if ((user = userDao.login(id, pw)) != null) {
			System.out.println("로그인 성공");
		} else {
			System.out.println("로그인 실패");
		}

		return user;
	}

	public void registerUser() {
		System.out.println("회원 가입");
		System.out.println("1.구매자 2.판매자 >>");
		int rollNumber = Integer.parseInt(scan.nextLine());
		String roll = "";

		switch (rollNumber) {
		case 1:
			roll = "customer";
			break;
		case 2:
			roll = "seller";
			break;
		default:
			System.out.println("잘못된 입력");
			return;
		}
		System.out.println("ID >>");
		String id = scan.nextLine();
		if (userDao.searchUser(id) != null) {
			System.out.println("이미 등록된 유저");
			return;
		}
		System.out.println("PW >>");
		String pw = scan.nextLine();
		int result = userDao.registerUser(id, pw, roll);
		if (result > 0)
			System.out.println("회원가입 완료!");
		else
			System.out.println("회원가입 실패");

	}

	public void getProductList() {
		List<Product> list = productDao.getAll();
		if (!list.isEmpty()) {
			System.out.println("no.제품이름 | 가격 | 갯수");
			System.out.println("--------------------------");
			int i = 1;
			for (Product p : list) {
				System.out.printf("%d.%s | %d | %d\n", i++, p.getName(), p.getPrice(), p.getAmount());
			}
		} else
			System.out.println("제품이 없습니다.");
		System.out.println("--------------------------");

	}

	public void addProduct() {

		System.out.println("물건등록");
		System.out.println("NSN(000000) >>");
		String nsn = scan.nextLine();
		if (productDao.searchNSN(nsn) != null) {
			System.out.println("NSN중복!");
			return;
		}
		System.out.println("TYPE_NO (10:FOOD / 20:FURNITURE / 30:MACHINE) >>");
		int type_no = Integer.parseInt(scan.nextLine());
		System.out.println("NAME >>");
		String name = scan.nextLine();
		System.out.println("PRICE >>");
		int price = Integer.parseInt(scan.nextLine());
		System.out.println("AMOUNT >>");
		int amount = Integer.parseInt(scan.nextLine());

		int result = productDao.insertProduct(nsn, type_no, name, price, amount);
		if (result > 0) {
			System.out.println("등록완료");
		} else {
			System.out.println("등록실패");
		}
	}

	public void updateProduct() {
		HashMap<Integer, Product> map = new HashMap<>();
		List<Product> list = productDao.getAll();
		getProductList();
		int i = 1;
		for (Product p : list) {
			map.put(i++, p);
		}
		Product temp = null;
		System.out.println("제품 선택(no) >>");
		int index = Integer.parseInt(scan.nextLine());
		try {
			temp = map.get(index);
		} catch (NullPointerException e) {
			System.out.println("잘못된 선택");
			return;
		}
		System.out.println("추가 갯수 >>");
		int amount = Integer.parseInt(scan.nextLine());
		String nsn = temp.getNsn();
		int result = productDao.updateProduct(nsn, amount);

		if (result > 0) {
			System.out.println("제품업데이트완료");
		} else {
			System.out.println("제품업데이트실패");
		}

	}

	public void getuserList() {
		System.out.println("--유저목록--");
		System.out.println("no. id - point");
		List<User> list = userDao.getUserList();
		int i=1;
		for(User u : list) {
			System.out.printf("%d. %s - %d\n",i++,u.getId(),u.getPoint());
		}
		
		
	}

	public void setPoint(User user) {
		System.out.println("충전할 포인트 입력(양수) >>");
		int point = Integer.parseInt(scan.nextLine());
		int result = userDao.updatePoint(user,point);
		if(result>0) {
			System.out.println("충전완료");
		}else{
			System.out.println("충전실패");
		}
		
	}

	public void buyProduct(User user) {
		System.out.println("보유 포인트: "+user.getPoint());
		HashMap<Integer, Product> map = new HashMap<>();
		List<Product> list = productDao.getAll();
		getProductList();
		int i = 1;
		for (Product p : list) {
			map.put(i++, p);
		}
		Product temp = null;
		System.out.println("제품 선택(no) >>");
		int index = Integer.parseInt(scan.nextLine());
		try {
			temp = map.get(index);
			System.out.println("구매할 갯수");
			int amount = Integer.parseInt(scan.nextLine());
			int result = productDao.orderProduct(temp.getNsn(),user.getId(),user.getPw(),amount);
			if(result>0) {
				System.out.println("구매완료");
			}else {
				System.out.println("구매실패");
			}
			
		} catch (NullPointerException e) {
			System.out.println("잘못된 선택");
			return;
		}
		
	}

	public void orderList(User user) {
		System.out.println();
		List<Order_List> list = userDao.getOrderList(user);
		System.out.println("=== 구매목록 ===");
		System.out.println("ID: "+user.getId());
		int i=1;
		for(Order_List order:list) {
			Product product = productDao.searchNSN(order.getNsn());
			System.out.printf("%d. %s -- %s\n",i++,product.getName(),order.getDate().toString());
		}
	}

}
