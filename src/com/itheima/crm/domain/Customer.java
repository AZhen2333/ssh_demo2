package com.itheima.crm.domain;

public class Customer {
	private Long cust_id;
	private String cust_name;
//	private String cust_source;//客户信息来源
//	private String cust_industry;//客户所属行业
//	private String cust_level;//客户级别
	private String cust_phone;
	private String cust_mobile;
	//文件
	private String cust_path;//文件相对路径
	private String cust_fileName;//文件名
	
	private BaseDict baseDictSource;
	private BaseDict baseDictIndustry;
	private BaseDict baseDictLevel;
	
	
	
	public String getCust_path() {
		return cust_path;
	}
	public void setCust_path(String cust_path) {
		this.cust_path = cust_path;
	}
	public String getCust_fileName() {
		return cust_fileName;
	}
	public void setCust_fileName(String cust_fileName) {
		this.cust_fileName = cust_fileName;
	}
	public Long getCust_id() {
		return cust_id;
	}
	public void setCust_id(Long cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public String getCust_phone() {
		return cust_phone;
	}
	public void setCust_phone(String cust_phone) {
		this.cust_phone = cust_phone;
	}
	public String getCust_mobile() {
		return cust_mobile;
	}
	public void setCust_mobile(String cust_mobile) {
		this.cust_mobile = cust_mobile;
	}
	public BaseDict getBaseDictSource() {
		return baseDictSource;
	}
	public void setBaseDictSource(BaseDict baseDictSource) {
		this.baseDictSource = baseDictSource;
	}
	public BaseDict getBaseDictIndustry() {
		return baseDictIndustry;
	}
	public void setBaseDictIndustry(BaseDict baseDictIndustry) {
		this.baseDictIndustry = baseDictIndustry;
	}
	public BaseDict getBaseDictLevel() {
		return baseDictLevel;
	}
	public void setBaseDictLevel(BaseDict baseDictLevel) {
		this.baseDictLevel = baseDictLevel;
	}
	
	
	
	
}
