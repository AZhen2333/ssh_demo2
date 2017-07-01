package com.itheima.crm.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.itheima.crm.domain.Customer;

public interface CustomerDAO {

	public void saveCustomer(Customer customer);

	public Long findByCriteria(DetachedCriteria criteria);

	public List<Customer> findByCriteria(DetachedCriteria criteria, int firstResult, int maxResults);

	public Customer findCustomer(Long cust_id);

	public void delete(Customer customerQuery);

}
