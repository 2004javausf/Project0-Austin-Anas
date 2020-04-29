package com.revature.beans;

import java.io.Serializable;

public class Admin implements Serializable{
//Has a method that can approve accounts
	
	private static final long serialVersionUID = 6963249833586819265L;
	
	// Variables
	private String username;
	private String password;
	
	
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
