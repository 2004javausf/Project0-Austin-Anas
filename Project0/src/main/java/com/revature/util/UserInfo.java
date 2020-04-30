package com.revature.util;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Admin;
import com.revature.beans.Customer;
import com.revature.beans.Employee;
import com.revature.screen.CustomerScr;
import com.revature.screen.Registration;

public class UserInfo {
	
	public static List<Customer> customerList = new ArrayList<Customer>();
	public static List<Employee> employeeList = new ArrayList<Employee>();
	public static List<Admin>	adminList =  new ArrayList<Admin>();
	
	// Validate unique username creation
	public static boolean validateUniqueUsername(String inputUserName) {
		
		boolean unique = true;
		for (int i = 0; i < customerList.size(); i++) {
			String userName = customerList.get(i).getUsername();
			if (inputUserName.equals(userName)) {
				unique = false;
			}
		}
		return unique;
	}	
	
	// Validate existing username 
	public static void validateUsername(String inputUserName) {
		
		boolean usernameExist = false;
		
		for (int i = 0; i < customerList.size(); i++) {
			String userName = customerList.get(i).getUsername();
			if (inputUserName.equals(userName)) {
				usernameExist = true;
			}
		}
		
		if(usernameExist == false) {
			System.out.println("Username not found");
			CustomerScr.userLogin();
		}
	}
		
	
	// Find customer
	public static Customer findCustomerByUsername(String inputUserName) {
		Customer c = new Customer();
		
		for (int i = 0; i < customerList.size(); i++) {
			String userName = customerList.get(i).getUsername();
			if (inputUserName.equals(userName)) {
				c = customerList.get(i);
			}
		}
		return c;
	}	
	
	public static Customer findCustomerByPassword(String inputPassword) {
		for (int i = 0; i < customerList.size(); i++) {
			String password = customerList.get(i).getPassword();
			if (inputPassword.equals(password)) {
				return customerList.get(i);
			}
		}
			System.out.println("Password not found");
			return null;
	}
	
	// Find Employee by user name
	public static Employee findEmployeeByUsername(String inputUserName) {
		for (int i = 0; i < employeeList.size(); i++) {
			String userName = employeeList.get(i).getUsername();
			if (inputUserName.equals(userName)) {
				return employeeList.get(i);
			}
		}
			System.out.println("Username not found");
			return null;
	}	
	
	//---------------------------find Admin----------------------------------------//
	public static Admin findAdminByUsername(String inputUserName) {
		for (int i = 0; i < adminList.size(); i++) {
			String userName = adminList.get(i).getUsername();
			if (inputUserName.equals(userName)) {
				return adminList.get(i);
			}
		}
			System.out.println("Username not found");
			return null;
	}	
}

