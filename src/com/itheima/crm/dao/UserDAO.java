package com.itheima.crm.dao;

import com.itheima.crm.domain.User;

public interface UserDAO {

	public User findUserByCodeAndPass(String user_code, String user_password);


}
