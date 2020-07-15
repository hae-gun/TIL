package com.pjt.edu.user;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO_mybatis implements DAO {
	//@Autowired
	private SqlSession session;
	public void setSession(SqlSession session) {
		this.session = session;
	}
	@Override
	public int insertUser(UserVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int deleteUser(UserVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public UserVO getUser(UserVO vo) {
		System.out.println(vo.getId());
		UserVO user = session.selectOne("oneUser",vo.getId());
		return user;
	}
	
	

}
