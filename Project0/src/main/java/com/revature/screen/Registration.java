package com.revature.screen;

import java.util.Scanner;

import com.revature.beans.Customer;
import com.revature.util.UserInfo;

public class Registration {
	
	public static Scanner scan = new Scanner(System.in);
	Registration registeredUser = new Registration();
	
	public static void registerMenu() {
		boolean unique;
		String userName;
		String password;
		
		do {
		System.out.println("Please create your desired username");
		userName = scan.nextLine();
		
		// Validate that user name is unique
		 unique = UserInfo.validateUniqueUsername(userName);
		} while(unique == false);
		
		System.out.println("Please create a password");
		password = scan.nextLine();
		
		// Create new customer object
		new Customer(userName, password);
		System.out.println("Thank you for applying! Once your application is reviewed, you will be able to utilize our banking services.");
		
	}
}
