package com.itheima.crm.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itheima.crm.dao.UserDAO;
import com.itheima.crm.domain.User;

public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {

	@Override
	public User findUserByCodeAndPass(String user_code, String user_password) {
		DetachedCriteria criteria=DetachedCriteria.forClass(User.class);
		criteria.add(Restrictions.eq("user_code", user_code));
		criteria.add(Restrictions.eq("user_password", user_password));
		List<User> list = (List<User>) getHibernateTemplate().findByCriteria(criteria);
		return list==null?null:list.get(0);
	}
}
