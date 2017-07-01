package com.itheima.crm.dao.impl;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import com.itheima.crm.dao.CustomerDAO;
import com.itheima.crm.domain.Customer;

public class CustomerDAOImpl extends HibernateDaoSupport implements CustomerDAO {

	@Override
	public void saveCustomer(Customer customer) {
		getHibernateTemplate().save(customer);
	}

	//查询总条数，投影查询
	@Override
	public Long findByCriteria(DetachedCriteria criteria) {
		List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(criteria.setProjection(Projections.rowCount()));
		return list.isEmpty()?0:list.get(0);
	}

	@Override
	public List<Customer> findByCriteria(DetachedCriteria criteria, int firstResult, int maxResults) {
		//第二次查询去掉投影查询
		criteria.setProjection(null);
		return (List<Customer>) getHibernateTemplate().findByCriteria(criteria, firstResult, maxResults);
	}

}
