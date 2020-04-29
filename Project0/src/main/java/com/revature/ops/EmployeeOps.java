package com.revature.ops;

import com.revature.util.UserInfo;

public class EmployeeOps extends UserOps {

	
	//Method to review pending applications
	public static boolean reviewPendingApp() {
		for (int i = 0; i < UserInfo.customerList.size(); i++) {
			String userName = UserInfo.customerList.get(i).getUsername();

		}
			System.out.println("Username not found");
		
		return false;
	}
	
	
	// Method to check acc
	public static void checkAcc() {
		
		for (int i = 0; i < UserInfo.customerList.size(); i++) {
			String userName = UserInfo.customerList.get(i).getUsername();

		}
			System.out.println("Username not found");
		
	}
	
	
	// Method to add account under customer
	public static void addAcc(String cust, String acc) {
		
	}
	
	
	// Method to delete account under customer
	public static void deleteAcc(String cust, String acc) {
		
	}
	
	
	
	
	
}
