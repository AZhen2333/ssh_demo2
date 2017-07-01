package com.itheima.crm.service.impl;

import java.util.List;

import com.itheima.crm.dao.BaseDictDAO;
import com.itheima.crm.domain.BaseDict;
import com.itheima.crm.service.BaseDictService;

public class BaseDictServiceImpl implements BaseDictService {

	private BaseDictDAO baseDictDAO;
	public void setBaseDictDAO(BaseDictDAO baseDictDAO) {
		this.baseDictDAO = baseDictDAO;
	}


	@Override
	public List<BaseDict> findBaseDict(BaseDict baseDict) {
		return baseDictDAO.findBaseDict(baseDict.getDict_type_code());
	}

}
