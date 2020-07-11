package com.example.demo.service.imp;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	
	@Override
	public User getUser() {
		User user = userDao.getUser();
		return user;
	}
}
