package com.revature.screen;

import java.util.Scanner;

import com.revature.beans.Admin;
import com.revature.beans.Customer;
import com.revature.beans.Employee;
import com.revature.menu.Menu;
import com.revature.util.UserInfo;

public class Login {
	public static Scanner scan = new Scanner(System.in);
	static boolean logged = false;

	// Customer Login
	public static void userLogin() {
		logged = false;
		do {
		System.out.println("Please enter your username");
		String inputUsername = scan.nextLine();
		Customer c = UserInfo.findCustomerByUsername(inputUsername);
		if(c.getUsername().equals(inputUsername)) {
			System.out.println("Please enter your password");
			String inputPassword = scan.nextLine();
			if (inputPassword.equals(c.getPassword())) {
				logged = true;
				Menu.customerMenu();
			} else System.out.println("My child, wrong password");
		}
		}while(logged == false);
	}	
	
	// Employee Login
	public static void employeeLogin() {
		logged = false;
		do {
		System.out.println("Please enter your username");
		String inputUsername = scan.nextLine();
		Employee c = UserInfo.findEmployeeByUsername(inputUsername);
		System.out.println("Please enter your password");
		String inputPassword = scan.nextLine();
		if (inputPassword.equals(c.getPassword())) {
			//methods for customers
			logged = true;
			Menu.employeeMenu();
		} else System.out.println("Sir, wrong password");
		}while(logged=false);
	}
	
	// Admin Login
	public static void adminLogin() {
		logged = false;
		do {
		System.out.println("Please enter your username");
		String inputUsername = scan.nextLine();
		Admin c = UserInfo.findAdminByUsername(inputUsername);
		System.out.println("Please enter your password");
		String inputPassword = scan.nextLine();
		if (inputPassword.equals(c.getPassword())) {
			logged = true;
			//methods for customers
			Menu.adminMenu();
		} else System.out.println("Sir, wrong password");
		}while(logged == false);
	}
	
}

