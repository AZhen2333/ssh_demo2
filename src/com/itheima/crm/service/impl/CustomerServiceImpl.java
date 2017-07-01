package com.itheima.crm.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.itheima.crm.dao.CustomerDAO;
import com.itheima.crm.domain.Customer;
import com.itheima.crm.page.Pagination;
import com.itheima.crm.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	// 注入
	private CustomerDAO customerDAO;

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Override
	public void saveCustomer(Customer customer) {
		customerDAO.saveCustomer(customer);
	}

	// 分页查询
	@Override
	public void findAllByPage(Pagination<Customer> pagination) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		// 获取pagination中的map，并根据条件将封装参数
		Map<String, String[]> parameterMap = pagination.getParameterMap();
		// 获取cust_name
		String cust_name = parameterMap.get("cust_name") == null ? null : parameterMap.get("cust_name")[0];
		if (StringUtils.isNotBlank(cust_name)) {
			criteria.add(Restrictions.like("cust_name", cust_name, MatchMode.ANYWHERE));
		}
		// 获取cust_mobile
		String cust_mobile = parameterMap.get("cust_mobile") == null ? null : parameterMap.get("cust_mobile")[0];
		if (StringUtils.isNotBlank(cust_mobile)) {
			criteria.add(Restrictions.like("cust_mobile", cust_name, MatchMode.ANYWHERE));
		}

		// 查询总条数
		Long totalCount = customerDAO.findByCriteria(criteria);
		pagination.setTotalCount(totalCount);

		// 查询每页的数据
		List<Customer> resultList = customerDAO.findByCriteria(criteria, pagination.getFirstResult(),
				pagination.getMaxResults());
		pagination.setResultList(resultList);

	}

}
