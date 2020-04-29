package com.revature.screen;

import java.util.Scanner;

import com.revature.beans.Customer;
import com.revature.util.PersonalUserInfo;

public class Register {
//	public String firstName;
//	public String lastName;
//	public String userName;
//	public String password;
	
	public static Scanner scan = new Scanner(System.in);
	Register registeredUser = new Register();
	
	public static void registerMenu() {
		System.out.println("Please create your desired username");
		String userName = scan.nextLine();
		System.out.println("Please create a password");
		String password = scan.nextLine();
		
		new Customer(userName, password);
		System.out.println("Thank you for applying! Once your application is reviewed, you will be able to sign in.");
		
		
		
		//add into the ArrayList
		
	}
}
