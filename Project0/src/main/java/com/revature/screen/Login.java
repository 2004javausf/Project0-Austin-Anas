package com.revature.screen;

import java.util.Scanner;

import com.revature.beans.Customer;
import com.revature.beans.Employee;
import com.revature.menu.Menu;
import com.revature.util.UserInfo;

public class Login {
	public static Scanner scan = new Scanner(System.in);

	// Customer Login
	public static void userLogin() {
		System.out.println("Please enter your username");
		String inputUsername = scan.nextLine();
		Customer c = UserInfo.findCustomerByUsername(inputUsername);
		System.out.println("Please enter your password");
		String inputPassword = scan.nextLine();
		if (inputPassword.equals(c.getPassword())) {
			Menu.customerMenu();
		} else System.out.println("My child, wrong password");
	}	
	
	// Employee Login
	public static void employeeLogin() {
		System.out.println("Please enter your username");
		String inputUsername = scan.nextLine();
		Employee c = UserInfo.findEmployeeByUsername(inputUsername);
		System.out.println("Please enter your password");
		String inputPassword = scan.nextLine();
		if (inputPassword.equals(c.getPassword())) {
			//methods for customers
			Menu.employeeMenu();
		} else System.out.println("Sir, wrong password");
	}
	
	// Admin Login
	public static void adminLogin() {
		
		
	}
}
