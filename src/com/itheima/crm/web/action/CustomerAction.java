package com.itheima.crm.web.action;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.itheima.crm.domain.Customer;
import com.itheima.crm.page.Pagination;
import com.itheima.crm.service.CustomerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author Tay
 *
 */
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	Customer customer = new Customer();
	@Override
	public Customer getModel() {
		return customer;
	}
	
	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	//回显addjsp
	public String addShow(){
		return "addjsp";
	}

	//添加客户信息
	public String saveCustomer(){
		customerService.saveCustomer(customer);
		return "listAction";
	}
	
	
	//属性驱动
	private int page;
	private int pageSize;
	public void setPage(int page) {
		this.page = page;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	//分页查询
	public String listPage(){
		Pagination<Customer> pagination=new Pagination<Customer>();
		//条件查询
		Map<String, String[]> parameterMap = ServletActionContext.getRequest().getParameterMap();
		pagination.setParameterMap(parameterMap);
		//封装参数
		if(page>0){
			pagination.setPage(page);
		}
		pagination.setParameterMap(parameterMap);
		if(pageSize>0){
			pagination.setPageSize(pageSize);
		}
		//查询页数
		customerService.findAllByPage(pagination);
//		System.out.println(pagination.toString());
		//回显
		ActionContext.getContext().put("pagination", pagination);
		return "listjsp";
	}
	
}
