package com.revature.screen;

import java.util.Map;
import java.util.Scanner;

import com.revature.beans.Customer;
import com.revature.beans.Employee;
import com.revature.driver.Driver;
import com.revature.menu.PrintMenu;
import com.revature.util.UserInfo;

public class EmployeeScr {

	public static Scanner scanInt = new Scanner(System.in);
	public static Scanner scan = new Scanner(System.in);
	public static Scanner scan2 = new Scanner(System.in);
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
			int employeeMenuChoice = scanInt.nextInt();
			
			// Switch statement to process option chosen
			switch(employeeMenuChoice) {
			default:
				System.out.println("Invalid input");	

			case 1:
				// Check customer bank accounts
				checkAcc();
				break;
			case 2:
				// Check, Approve & reject applications
				reviewPendingApp();
				break;
			case 3:
				// Exit to Main Menu
				Driver.mainMenu();
			}
		}
		
		
		//-----------------------Employee Methods-----------------------------------------//
		
		// Method to check acc
		public static void checkAcc() {
			System.out.println("Customer List:\n");
			for (int i = 0; i < UserInfo.customerList.size(); i++) {
				Customer customer = UserInfo.customerList.get(i);
				if(!customer.getUsername().isEmpty()) {
				System.out.println("Username: " + customer.getUsername());
				System.out.println("Accounts & Balances: " + customer.getAccNo());
			}
			}
			
			employeeMenu();
		}
		
		// Method to review pending applications
		public static void reviewPendingApp() {
						
			boolean userFound = false;
			boolean pendingApp = false;
			String userName;
						
			System.out.println("Customers with pending applications:");
						
			for (int i = 0; i < UserInfo.customerList.size(); i++) {
				pendingApp = UserInfo.customerList.get(i).isPendingAcc();
							
				if(pendingApp == true) {
					System.out.println(UserInfo.customerList.get(i).getUsername());
				}
			}
						
			do {
				System.out.println("Please enter the customer's username which you would like to review his/her application:");
				userName = scan.nextLine();
				Customer c = UserInfo.findCustomerByUsername(userName);
							
				if(c.getUsername().equals(userName)) {
					userFound = true;
						
					System.out.println("Would you like to approve this customer's application? [Y/N]");	
					String ans = scan.nextLine();
							
					if(ans.equalsIgnoreCase("y")) {
						System.out.println("You have approved the customers application!");
						System.out.println("Please assign a new account number for his newly opened account:");
						Integer newAcc = scanInt.nextInt();
						Map<Integer,Double> existingAcc = c.getAccNo();
						existingAcc.put(newAcc, 0.00);
						c.setAccNo(existingAcc);
					}else {
						System.out.println("You have rejected the customer's application.");		
					}
					c.setPendingAcc(false);		
				} else System.out.println("Username not found");
			}while(userFound == false);
				
			employeeMenu();
		}

		
}
