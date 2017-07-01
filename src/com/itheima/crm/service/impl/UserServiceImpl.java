package com.itheima.crm.service.impl;

import com.itheima.crm.dao.UserDAO;
import com.itheima.crm.domain.User;
import com.itheima.crm.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDAO userDAO;
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public User findUserByCodeAndPass(User user) {
		return userDAO.findUserByCodeAndPass(user.getUser_code(),user.getUser_password());
	}
	
}
