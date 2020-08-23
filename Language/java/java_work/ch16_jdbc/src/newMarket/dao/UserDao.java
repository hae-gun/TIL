package newMarket.dao;

import java.util.List;

import newMarket.vo.Order_List;
import newMarket.vo.User;

public interface UserDao {

	User login(String id, String pw);

	User searchUser(String id);

	int registerUser(String id, String pw, String roll);

	List<User> getUserList();

	int updatePoint(User user, int point);

	List<Order_List> getOrderList(User user);

}
