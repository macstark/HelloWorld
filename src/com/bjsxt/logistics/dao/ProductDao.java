package com.bjsxt.logistics.dao;

import com.bjsxt.logistics.entity.Product;

/**
 * 
 * @author Lif
 *
 */
public interface ProductDao {
	// 添加产品 & 修改产品
	void addPro(Product pt);	
	// 通过ID查找产品
	Product getPro(int id);
	// 通过名称查找产品
	Product getPro(String name);
	// 删除产品
	void deletePro(int id);
	// 追踪产品
	void tracePro(int id);
}
