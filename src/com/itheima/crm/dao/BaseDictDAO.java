package com.itheima.crm.dao;

import java.util.List;

import com.itheima.crm.domain.BaseDict;

public interface BaseDictDAO {

	public List<BaseDict> findBaseDict(String dict_type_code);

}
