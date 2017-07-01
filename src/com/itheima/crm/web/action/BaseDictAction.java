package com.itheima.crm.web.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;

import org.apache.struts2.ServletActionContext;

import com.itheima.crm.domain.BaseDict;
import com.itheima.crm.service.BaseDictService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
import net.sf.json.util.JSONUtils;

public class BaseDictAction extends ActionSupport implements ModelDriven<BaseDict> {
	BaseDict baseDict = new BaseDict();

	@Override
	public BaseDict getModel() {
		return baseDict;
	}

	// 注入service
	private BaseDictService baseDictService;

	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}

	// 根据id查询
	public String findByTypeCode() throws Exception {
		List<BaseDict> baseDictList = baseDictService.findBaseDict(baseDict);
		System.out.println(baseDictList.toString());
		// 转换成json
		JSONArray jsonArray = JSONArray.fromObject(baseDictList);
		// 设置响应格式
		ServletActionContext.getResponse().setContentType("application/json;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().print(jsonArray.toString());
		return NONE;
	}

}
