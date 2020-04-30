package com.revature.screen;

import java.util.Scanner;

import com.revature.beans.Employee;
import com.revature.driver.Driver;
import com.revature.menu.PrintMenu;
import com.revature.util.UserInfo;

public class EmployeeScr {

	public static Scanner scanInt = new Scanner(System.in);
	public static Scanner scan = new Scanner(System.in);
	static boolean logged = false;
	
	// Employee Login
	public static void employeeLogin() {
		logged = false;
		do {
			System.out.println("Please enter your username");
			String inputUsername = scan.nextLine();
			Employee c = UserInfo.findEmployeeByUsername(inputUsername);
			if(c.getUsername().equals(inputUsername)) {
				System.out.println("Please enter your password");
				String inputPassword = scan.nextLine();
				if (inputPassword.equals(c.getPassword())) {
					logged = true;
					employeeMenu();
				} else System.out.println("My child, wrong password");
			 }
		}while(logged=false);
	}
		
		//------------------------------Employee Menu---------------------------------------------//
		public static void employeeMenu() {
			System.out.println("\nWelcome back sir");
			System.out.println("Please select an option");
			
			PrintMenu employeeMenu = new PrintMenu("Menu", "Accounts", "Pending Applications", "Exit");
			employeeMenu.display();
			int employeeMenuChoice = scan.nextInt();
			
			// Switch statement to process option chosen
			switch(employeeMenuChoice) {
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
		
		//-----------------------Enployee Methods-----------------------------------------//
		
		// Method to review pending applications
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
