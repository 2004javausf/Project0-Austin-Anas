package com.revature.screen;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.revature.beans.Admin;
import com.revature.beans.Customer;
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
			if(c.getUsername().equals(inputUsername)) {
				System.out.println("Please enter your password");
				String inputPassword = scan.nextLine();
				if (inputPassword.equals(c.getPassword())) {
					logged = true;
					adminMenu();
				} else System.out.println("Sir, wrong password");
			}
		}while(logged == false);
	}
		
	//------------------------------Admin Menu---------------------------------------------//
	public static void adminMenu() {
		System.out.println("\nWelcome back sir");
		System.out.println("Please select an option");
					
		PrintMenu adminMenu = new PrintMenu("Menu", "Accounts", "Pending Applications", "Delete Account", "Exit");
		adminMenu.display();
		int adminMenuChoice = scanInt.nextInt();
					
		// Switch statement to process option chosen
		switch(adminMenuChoice) {
			case 1:
				// Check customer bank accounts
				checkAcc();
				break;
			case 2:
				reviewPendingApp();
				// Check, approve & reject applications
				break;
			case 3:
				// Delete existing user accounts
				deleteAcc();
				break;
			case 4 :
				
				// Exit to Main Menu
				Driver.mainMenu();
			default:
				System.out.println("Invalid input. Goodbye \n");	
				//Terminate program
				System.exit(0);
		}
	}
	
	//------------------------------Admin Methods---------------------------------------------//
	
	
	
	// Method to delete account under customer
	public static void deleteAcc() {
		
		Map<Integer,Double> existingAcc = new HashMap();
		Set<Integer> acc = new HashSet();
		Customer c = new Customer();
		String userName;
		Integer deletedAcc;
		boolean userFound = false;
		boolean accExist = false;
		
		System.out.println("Customer List:\n");
		
		for (int i = 0; i < UserInfo.customerList.size(); i++) {
			Customer customer = UserInfo.customerList.get(i);
			if(!customer.getUsername().isEmpty()) {
			System.out.println("Username: " + customer.getUsername());
			System.out.println("Accounts & Balances: " + customer.getAccNo());
			}
		}
		
		do {
			System.out.println("Please enter the customer's username:");
			userName = scan.nextLine();
			c = UserInfo.findCustomerByUsername(userName);
			
				if(c.getUsername().equals(userName)) {
					userFound = true;
					 acc = c.getAccNo().keySet();
				}
			}while(userFound == false);
			
		do {
			System.out.println("Which account would you like to destroy?");
			deletedAcc = scanInt.nextInt();
				
				for(Integer i: acc) {
					if(deletedAcc.equals(Integer.valueOf(i))){
						 existingAcc = c.getAccNo();
						 accExist = true;
					}
				}
			}while(accExist == false);
		
			existingAcc.remove(deletedAcc);
			c.setAccNo(existingAcc);
		
		adminMenu();
		} 		
	
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
				
				adminMenu();
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
		
				adminMenu();
			}

}
