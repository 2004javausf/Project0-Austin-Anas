package com.revature.screen;

import java.util.Scanner;

import com.revature.beans.Admin;
import com.revature.driver.Driver;
import com.revature.menu.PrintMenu;
import com.revature.util.UserInfo;

public class AdminScr {
	
	public static Scanner scanInt = new Scanner(System.in);
	public static Scanner scan = new Scanner(System.in);
	static boolean logged = false;
	
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
				adminMenu();
			} else System.out.println("Sir, wrong password");
			}while(logged == false);
		}
		
		//------------------------------Admin Menu---------------------------------------------//
				public static void adminMenu() {
					System.out.println("Welcome back sir");
					System.out.println("Please select an option");
					
					PrintMenu adminMenu = new PrintMenu("Menu", "Accounts", "Pending Applications", "Exit");
					adminMenu.display();
					int adminMenuChoice = scan.nextInt();
					
					// Switch statement to process option chosen
					switch(adminMenuChoice) {
					case 1:
						// Check customer bank accounts
						break;
					case 2:
						// Check, approve & reject applications
						break;
					case 3:
						// Exit
						Driver.mainMenu();
					default:
						System.out.println("Invalid input. Goodbye \n");	
						//Terminate program
						System.exit(0);
					}
			}
}
