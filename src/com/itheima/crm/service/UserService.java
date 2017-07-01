package com.itheima.crm.service;

import com.itheima.crm.domain.User;

public interface UserService {

	public User findUserByCodeAndPass(User user);

}
