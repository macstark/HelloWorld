package com.bjsxt.logistics.entity;

import java.io.Serializable;

/**
 * 用户实体类
 * 
 * @author Lif
 *
 */
public class User implements Serializable{

	private static final long serialVersionUID = -4778536207467483335L;
	// 用户名
	private String name;
	// 用户密码
	private String password;

	// 构造方法
	public User() {
	}

	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	// Getter和Setter方法
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// 重写toString方法
	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + "]";
	}

}
