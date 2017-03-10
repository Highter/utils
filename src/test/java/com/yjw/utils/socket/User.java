package com.yjw.utils.socket;

import java.io.Serializable;

/**
 * 
 *@author yangjianwei
 *@date 4:50:51 PM,8 Mar 2017
 *@vesion 1.0
 *@see yjwsmileatlife@126.com
 */
public class User implements Serializable{
	
	private static final long serialVersionUID = 3463012689154060232L;

	private String name;
	
	private String password;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

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

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + "]";
	}
	
	
}
