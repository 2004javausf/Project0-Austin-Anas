package com.revature.beans;

import java.io.Serializable;

import com.revature.util.IO;
import com.revature.util.UserInfo;

public class Admin implements Serializable{
//Has a method that can approve accounts
	
	private static final long serialVersionUID = 6963249833586819265L;
	
	// Variables
	private String username;
	private String password;
	
	// Constructors
	public Admin() {
		super();
		this.username = "";
		UserInfo.adminList.add(this);
	}
	
	public Admin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		UserInfo.adminList.add(this);
		IO.writeAdminFile(UserInfo.adminList);
	}

	// Setters & Getters
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public String toString() {
		return "EmployeeAdmin [username=" + username + ", password=" + password + "]";
	}
	
	
}
