package com.itheima.crm.service;

import com.itheima.crm.domain.Customer;
import com.itheima.crm.page.Pagination;

public interface CustomerService {

	public void saveCustomer(Customer customer);


	public void findAllByPage(Pagination<Customer> pagination);

}
