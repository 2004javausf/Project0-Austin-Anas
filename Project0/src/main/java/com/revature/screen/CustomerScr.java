package com.revature.screen;

import java.util.Scanner;
import java.util.Set;

import com.revature.beans.Customer;
import com.revature.driver.Driver;
import com.revature.menu.PrintMenu;
import com.revature.util.UserInfo;

public class CustomerScr {
	
	public static Scanner scanInt = new Scanner(System.in);
	public static Scanner scan = new Scanner(System.in);
	public static Scanner scanDub = new Scanner(System.in);
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
			}else System.out.println("Username not found");
			}while(logged == false);
		}	
		
		public static void customerMenu() {
			
			System.out.println("\n====================================");
			System.out.println("Welcome back my child");
			
			PrintMenu loginMenu = new PrintMenu("Menu", "Check Balance", "Deposit", "Withdraw","Transfer Funds", "Open New Bank Account", "Exit");
			loginMenu.display();
			int customerMenuChoice = scanInt.nextInt();
			
			// Switch statement to process option chosen
			switch(customerMenuChoice) {
			case 1:
				// Check balance
				checkBalance(c);
				break;
			case 2:
				// Deposit
				deposit(c);
				
				break;
			case 3:
				// Withdrawals
				withdraw(c);
				break;
			case 4: 
				transferFunds(c);
				 // Transfer Funds
				break;
			case 5:
				// Open new acc
				applyNewAcc(c);
				break;
			case 6:
				// Main menu
				Driver.mainMenu();
			default:
				System.out.println("Invalid input. Goodbye \n");
				
				//Terminate program
				System.exit(0);
			}
		}
	
		//----------------------------Methods for Customer Screen---------------------------------------//
		
		// Method for checking if customer has account or not
		public static boolean hasAccount(Customer c) {
			
			boolean hasAcc = true;
			
			if(c.getAccNo().isEmpty()) {
				hasAcc = false;
			}		
			return hasAcc;	
		}
		
		// Method to check customer's account balance
		public static void checkBalance(Customer c) {
			
			Set<Integer> acc = c.getAccNo().keySet();
			
			for(Integer i: acc) {
				System.out.println( "Account Number: " + Integer.valueOf(i) + "  Balance: " + "$" + c.getAccNo().get(i) );
	    	}
			customerMenu();
		}
			
		// Method for withdrawals
		public static void withdraw(Customer c) {
			
		 if(hasAccount(c) == true) {
			
			double availableFunds = 0;
			double newFunds;
			boolean accExist = false;
			Integer accNo;
			Set<Integer> acc = c.getAccNo().keySet();
			
			System.out.println("Available account(s):");
			for(Integer i: acc) {
				System.out.println( "Account Number: " + Integer.valueOf(i) );
	    	}
			
			do {
			System.out.println("Please enter the account number that you would like to withdraw money from:");
			accNo = scanInt.nextInt();
			
			for(Integer i: acc) {
				if(accNo.equals(Integer.valueOf(i))){
					availableFunds = c.getAccNo().get(i);
					accExist = true;
				}	
			}
			
			if (accExist == false) {
				System.out.println("Invalid account number inserted");
			}}while(accExist == false);
	    	
			System.out.println("Enter the amount to withdraw");
			double withdraw = scanDub.nextDouble();
			
			if(withdraw > availableFunds) {
				System.out.println("Not enough funds available");
				System.out.println("Sending you back to the menu");
			} else {
				newFunds = availableFunds - withdraw;
				c.getAccNo().remove(accNo, availableFunds);
				c.getAccNo().put(accNo, newFunds);
				
				System.out.println("Prior funds: " + "$" + availableFunds);	
				System.out.println("New funds: " + "$" + newFunds);	
			}	
		 }
		   else {
				System.out.println("You are ineligible to perform any transactions at this moment.");
				System.out.println("Sending you back to the menu");
			}
			customerMenu();
		}
	
		// Method for deposits
		public static void deposit(Customer c) {
			
			if(hasAccount(c) == true) {
				
				double availableFunds = 0;
				double newFunds;
				boolean accExist = false;
				Integer accNo;
				Set<Integer> acc = c.getAccNo().keySet();
				
				System.out.println("Available account(s):");
				for(Integer i: acc) {
					System.out.println( "Account Number: " + Integer.valueOf(i) );
		    	}
				
				do {
				System.out.println("Please enter the account number that you would like to deposit money to:");
				accNo = scanInt.nextInt();
				
				for(Integer i: acc) {
					if(accNo.equals(Integer.valueOf(i))){
						availableFunds = c.getAccNo().get(i);
						accExist = true;
					}	
				}
				
				if (accExist == false) {
					System.out.println("Invalid account number inserted");
				}}while(accExist == false);
		    	
				System.out.println("Enter the amount to deposit");
				double deposit = scanDub.nextDouble();
				
				if(deposit <= 0) {
					System.out.println("We don't deal with beggars");
					System.out.println("Sending you back to the menu");
				} else {
					newFunds = availableFunds + deposit;
					c.getAccNo().remove(accNo, availableFunds);
					c.getAccNo().put(accNo, newFunds);
					
					System.out.println("Prior funds: " + availableFunds);	
					System.out.println("New funds: " + newFunds);	
				}	
					
			 }
			   else {
					System.out.println("You are ineligible to perform any transactions at this moment.");
					System.out.println("Sending you back to the menu");
				}
				customerMenu();
		}
		
		
		// Method for applying for new accounts
		public static void applyNewAcc(Customer c){
			System.out.println("\n\nThank you for applying to open a new account!");
			System.out.println("We will process your application shortly");
			c.setPendingAcc(true);
			customerMenu();
		}
		
		// Method to transfer funds
		public static void transferFunds(Customer c) {
			boolean acc1Exist = false;
			boolean acc2Exist = false;
			Double fromBalance = 0.00;
			Double toBalance = 0.00;
			Integer toAccount = 0;
			Integer fromAccount = 0;
			
			if(hasAccount(c) == true) {
				Set<Integer> acc = c.getAccNo().keySet();
				
				
				for(Integer i: acc) {
					System.out.println( "Account Number: " + Integer.valueOf(i) + "  Balance: " + c.getAccNo().get(i) );
				}
					
					
					// Check Account 2
					do {	
					System.out.println("Which account will you be transferring from?");
					fromAccount = scanInt.nextInt();
					for (Integer j : acc ) {
						if (fromAccount.equals(j)) {
							fromBalance = c.getAccNo().get(j);
							acc1Exist = true;
						}	
					}
						
					if (acc1Exist == false) {
						System.out.println("Invalid account number");
					}}while(acc1Exist == false);
					
					
					// Account to transfer to					
					do {
					System.out.println("What's the account number you'd like to transfer to?");
					toAccount = scanInt.nextInt();
					for (Integer j : acc ) {
						if (toAccount.equals(j)) {
							toBalance = c.getAccNo().get(j);
							acc2Exist = true;
						}	
					}
						
					if (acc2Exist == false) {
						System.out.println("Invalid account number");
					}}while(acc1Exist == false);
					
					System.out.println("What is the amount you would like to transfer?");
					Double transferAmount = scanDub.nextDouble();
								
					if (transferAmount >= 0 && transferAmount < fromBalance) {
						double newFromBalance = fromBalance - transferAmount;
						double toAccountBalance = toBalance + transferAmount;
						c.getAccNo().remove(fromAccount, fromBalance);
						c.getAccNo().put(fromAccount, newFromBalance);
						c.getAccNo().remove(toAccount, toBalance);
						c.getAccNo().put(toAccount, toAccountBalance);
						
						System.out.println("\n====================================================");
						System.out.println("Prior funds Account 1: " + "$" + fromBalance);	
						System.out.println("Prior funds Account 2: " + "$" + toBalance);
						
						System.out.println("New funds Account 1: " + "$" + newFromBalance);	
						System.out.println("New funds Account 2: " + "$" + toAccountBalance);
					} else {
						System.out.println("Not possible little one");
					}
				}  else {
					System.out.println("You are ineligible to perform any transactions at this moment.");
					System.out.println("Sending you back to the menu");
				}
				customerMenu();
			}
							
												
} 

