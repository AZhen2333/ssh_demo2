package com.itheima.crm.utils;

import java.util.UUID;

public class UUIDUtils {
	// 生成商品ID
	public static String getID() {
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}

	public static void main(String[] args) {
		System.out.println(getID());
	}

}
