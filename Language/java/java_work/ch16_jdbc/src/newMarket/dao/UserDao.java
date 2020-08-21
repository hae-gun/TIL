package newMarket.dao;

import newMarket.vo.User;

public interface UserDao {

	User login(String id, String pw);

}
