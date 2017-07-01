package com.itheima.crm.web.action;

import java.io.File;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.itheima.crm.domain.Customer;
import com.itheima.crm.page.Pagination;
import com.itheima.crm.service.CustomerService;
import com.itheima.crm.utils.SystemContent;
import com.itheima.crm.utils.UploadUtils;
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
	
	/*++++++++文件上传++++++++++ */
	//上传文件的属性
	private File upload;//文件引用对象
	private String uploadContentType;//Mime类型
	private String uploadFileName;//文件真实名字
	//set方法
	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	//添加客户信息
	public String saveCustomer() throws Exception{
		//生成随机的文件名和文件夹
		String randomFileName=UploadUtils.getUUIDName(uploadFileName);
		String randomDir=UploadUtils.getDir(randomFileName);
		//拼接相对路径
		String filePath=randomDir+"/"+randomFileName;
		//绝对路径
		String destFilePath=SystemContent.FILEUPLOADBASEPATH+filePath;
		//复制文件（上传）
		FileUtils.copyFile(upload, new File(destFilePath));
		
		
		customerService.saveCustomer(customer);
		return "listAction";
	}
	
	
	
	/*++++++++分页显示数据++++++++++ */
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
