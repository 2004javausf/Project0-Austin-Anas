package com.revature.util;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Admin;
import com.revature.beans.Customer;
import com.revature.beans.Employee;
import com.revature.screen.CustomerScr;

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
		
	
	// Find Customer by user name
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
		
	// Find Employee by user name
	public static Employee findEmployeeByUsername(String inputUserName) {
		Employee c = new Employee();
		
		for (int i = 0; i < employeeList.size(); i++) {
			String userName = employeeList.get(i).getUsername();
			if (inputUserName.equals(userName)) {
				c = employeeList.get(i);
			}
		}
			return c;
	}	
	
	//---------------------------find Admin----------------------------------------//
	public static Admin findAdminByUsername(String inputUserName) {
		Admin c = new Admin();
		
		for (int i = 0; i < adminList.size(); i++) {
			String userName = adminList.get(i).getUsername();
			if (inputUserName.equals(userName)) {
				c = adminList.get(i);
			}
		}
			return c;
	}	
}

