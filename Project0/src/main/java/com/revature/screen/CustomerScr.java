package com.revature.screen;

import java.util.Scanner;

import com.revature.beans.Customer;
import com.revature.driver.Driver;
import com.revature.menu.PrintMenu;
import com.revature.util.UserInfo;

public class CustomerScr {
	
	public static Scanner scanInt = new Scanner(System.in);
	public static Scanner scan = new Scanner(System.in);
	static boolean logged = false;
	public static Customer c;
	
	// Customer Login
		public static void userLogin() {
			logged = false;
			do {
			System.out.println("Please enter your username");
			String inputUsername = scan.nextLine();
			c = UserInfo.findCustomerByUsername(inputUsername);
			if(c.getUsername().equals(inputUsername)) {
				System.out.println("Please enter your password");
				String inputPassword = scan.nextLine();
				if (inputPassword.equals(c.getPassword())) {
					logged = true;
					customerMenu();
				} else System.out.println("My child, wrong password");
			}
			}while(logged == false);
		}	
		
		public static void customerMenu() {
			
			System.out.println("\n====================================");
			System.out.println("Welcome back my child");
			
			PrintMenu loginMenu = new PrintMenu("Menu", "Check Balance", "Deposit", "Withdraw", "Open New Bank Account", "Exit");
			loginMenu.display();
			int customerMenuChoice = scan.nextInt();
			
			// Switch statement to process option chosen
			switch(customerMenuChoice) {
			case 1:
				// Check balance
				break;
			case 2:
				// Deposit
				
				break;
			case 3:
				// Withdrawals
				withdraw(c);
				break;
			case 4: 
				 // Open new account
				break;
			case 5:
				// Main menu
				Driver.mainMenu();
				break;
			case 6:
				// Exit
			default:
				System.out.println("Invalid input. Goodbye \n");
				
				//Terminate program
				System.exit(0);
			}
		}
	
		
		//----------------------------Methods for Customer Screen---------------------------------------//
		
		// method for checking if customer has account or not
		public static boolean hasAccount(String username) {
			
			return false;	
		}
		
		// method for withdrawals
		public static void withdraw(Customer c) {
			System.out.println("Enter the amount to withdraw");
			double withdraw = scanInt.nextDouble();
			
			
		}
		
		
		// method for deposits
		public static Double deposit(String acc) {
			Double balance = 0.00;
			
			return balance;	
		}
		
		
		// method for applying for new accounts
		public static void applyNewAcc(String username){
			System.out.println("What type of account would you like to open?");
					
		}
		
		// method to transfer funds
		public static void transferFunds(String acc1, String acc2) {
			
		}
}
