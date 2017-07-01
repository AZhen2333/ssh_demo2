package com.itheima.crm.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itheima.crm.dao.BaseDictDAO;
import com.itheima.crm.domain.BaseDict;

public class BaseDictDAOImpl extends HibernateDaoSupport implements BaseDictDAO{

	@Override
	public List<BaseDict> findBaseDict(String dict_type_code) {
		DetachedCriteria criteria=DetachedCriteria.forClass(BaseDict.class);
		criteria.add(Restrictions.eq("dict_type_code", dict_type_code));
		return 	(List<BaseDict>) getHibernateTemplate().findByCriteria(criteria);
	}

	

}
