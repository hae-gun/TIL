package market.dao;

import java.util.List;

import market.vo.User;

public interface UserOracleDao {
	public List<User> getAllUsers();

	public User getUser(String id);
}
