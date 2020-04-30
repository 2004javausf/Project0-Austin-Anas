package com.revature.beans;

import java.io.Serializable;

import com.revature.util.IO;
import com.revature.util.UserInfo;

public class Employee implements Serializable {

	private static final long serialVersionUID = -7903604722078061506L;
	
	// Variables
	private String username;
	private String password;
	
	// Constructors
	public Employee() {
		super();
		this.username = "";
		UserInfo.employeeList.add(this);
	}
	
	
	public Employee(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		UserInfo.employeeList.add(this);
		IO.writeEmployeeFile(UserInfo.employeeList);
	}

	// Setter & Getter Methods
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
		return "Employee [username=" + username + ", password=" + password + "]";
	}
	
	
}
