package com.revature.screen;

import java.util.Scanner;

import com.revature.beans.Customer;
import com.revature.menu.Menu;
import com.revature.util.PersonalUserInfo;

public class Login {
	public static Scanner scan = new Scanner(System.in);

	public static void userLogin() {
		System.out.println("Please enter your username");
		String inputUsername = scan.nextLine();
		Customer c = PersonalUserInfo.findCustomerByUsername(inputUsername);
		System.out.println("Please enter your password");
		String inputPassword = scan.nextLine();
		if (inputPassword.equals(c.getPassword())) {
			//methods for customers
			Menu.loginMenu();
		} else System.out.println("Child, wrong password");
	}
	
	
	
	
	
}
