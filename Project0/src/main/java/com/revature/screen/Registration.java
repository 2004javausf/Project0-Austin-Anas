package com.revature.screen;

import java.util.Scanner;

import com.revature.beans.Customer;
import com.revature.util.UserInfo;

public class Registration {
	
	public static Scanner scan = new Scanner(System.in);
	Registration registeredUser = new Registration();
	
	public static void registerMenu() {
		System.out.println("Please create your desired username");
		String userName = scan.nextLine();
		
		// Validate that user name is unique
		UserInfo.validateUniqueUsername(userName);
		
		System.out.println("Please create a password");
		String password = scan.nextLine();
		
		// Create new customer object
		new Customer(userName, password);
		System.out.println("Thank you for applying! Once your application is reviewed, you will be able to sign in.");
		
	}
}
