package com.bjsxt.logistics.entity;

import java.io.Serializable;

/**
 * 产品实体类
 * @author Lif
 *
 */
public class Product implements Serializable{

	private static final long serialVersionUID = -3959918246276477378L;
	// 产品名称
	private String name;
	// 产品编号
	private int id;
	// 产品产地
	private String fromPlace;
	// 产品数量
	private int count;
	// 产品目的地
	private String toPlace;
		
	// 构造方法
	public Product() {
		super();
	}

	public Product(String name, int id, String fromPlace, int count, String toPlace) {
		super();
		this.name = name;
		this.id = id;
		this.fromPlace = fromPlace;
		this.count = count;
		this.toPlace = toPlace;
	}
	// Getter和Setter方法

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFromPlace() {
		return fromPlace;
	}

	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getToPlace() {
		return toPlace;
	}

	public void setToPlace(String toPlace) {
		this.toPlace = toPlace;
	}
	// 重写toString方法
	@Override
	public String toString() {
		return "Product [name=" + name + ", id=" + id + ", fromPlace=" + fromPlace + ", count=" + count + ", toPlace="
				+ toPlace + "]";
	}
	
}
