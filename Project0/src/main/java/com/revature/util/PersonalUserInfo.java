package com.revature.util;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Customer;

public class PersonalUserInfo {
	
	
	public static List<Customer> customerList = new ArrayList<Customer>();
	
	public static Customer findCustomerByUsername(String inputUserName) {
		for (int i = 0; i < customerList.size(); i++) {
			String userName = customerList.get(i).getUsername();
			if (inputUserName.equals(userName)) {
				return customerList.get(i);
			}
		}
			System.out.println("Username not found");
			return null;
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
}

