package com.itheima.crm.web.action;

import org.apache.struts2.ServletActionContext;

import com.itheima.crm.domain.User;
import com.itheima.crm.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	User user = new User();
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	// 注入
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String login() {
		System.out.println(user.toString());
		User loginUser = userService.findUserByCodeAndPass(user);
		if (loginUser==null) {
			addActionError("用户名或密码错误");
			return LOGIN;
		}else{
			ServletActionContext.getRequest().getSession().setAttribute("loginUser", loginUser);
			return SUCCESS;
		}
	}

}
