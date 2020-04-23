package com.revature.driver;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*Build the application using Java 8
	- All interaction with the user should be done through the console using the Scanner class
	Customers of the bank should be able to register with a username and password, 
	and apply to open an account.
	Customers should be able to apply for joint accounts
	Once the account is open, customers should be able to withdraw, deposit, 
	and transfer funds between accounts
	All basic validation should be done, such as trying to input negative amounts, 
	overdrawing from accounts etc.
	Employees of the bank should be able to view all of their customers' information
	This includes: account information, account balances, personal information
	Employees should be able to approve/deny open applications for accounts
	Bank admins should be able to view and edit all accounts
	This includes: - Approving/denying accounts
				   - Withdrawing, depositing, transferring from all accounts
				   - Canceling accounts
	All information should be persisted using text files and serialization
	100% test coverage is expected using J-Unit
		You should be using TDD
 */

public class Driver {
	
	// Initialize the Scanner objects to receive input from user
	public static Scanner scString = new Scanner(System.in);
	public static Scanner scInt = new Scanner(System.in);

	public static void main(String[] args) {
		
		// Initialize a map object to store user names and passwords
		Map<List<String>, List<String>> loginInfo = new LinkedHashMap<>();
		
		System.out.println("Welcome to the bank!");
		System.out.println("Do you have an account with us?");
		System.out.println("If yes, enter 'Y'. Otherwise, enter 'N'");
		String reply = scString.nextLine();
		
		// If user replies 'Y', prompt user to enter login details
		if (reply.equalsIgnoreCase("Y")) {
			System.out.print("Please enter your username: ");
			String username = scString.nextLine();
			System.out.print("Please enter your password: ");
			String password = scString.nextLine();
		} 
		
		// If user replies 'N', ask user if he/she wants to create an acc
		else if (reply.equalsIgnoreCase("N")){
			System.out.println("Would you like to register an account with us?");
			System.out.println("If yes, enter 'Y'. Otherwise, enter 'N'");
			
			String reply2 = scString.nextLine();
			
			if (reply2.equalsIgnoreCase("Y")) {
				System.out.print("Please create a username: ");
				String username = scString.nextLine();
				System.out.print("Please create a password: ");
				String password = scString.nextLine();
			} else {
				
				System.out.println("Goodbye!");
				return;
			}
		}
		
		else {
			System.out.println("Invalid input");
			return;
		}
		
		
	}

}
