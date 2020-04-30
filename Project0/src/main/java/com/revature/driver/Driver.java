package com.revature.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.revature.beans.Admin;
import com.revature.beans.Customer;
import com.revature.beans.Employee;
import com.revature.menu.PrintMenu;
import com.revature.screen.AdminScr;
import com.revature.screen.CustomerScr;
import com.revature.screen.EmployeeScr;
import com.revature.screen.Registration;
import com.revature.util.IO;
import com.revature.util.UserInfo;

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
	
	static Scanner scan = new Scanner(System.in);
	static Scanner scString = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		// Reads in the customer details
		IO.readCustomerFile();
		IO.readEmployeeFile();
		IO.readAdminFile();
		System.out.println(UserInfo.customerList.toString());
		System.out.println(UserInfo.employeeList.toString());
		System.out.println(UserInfo.adminList.toString());
		
//		Map<Integer, Double> acc = new HashMap<>();
//		acc.put(3892147, 999999999.99);
//		acc.put(3845355, 999999999.99);
		
//		Customer matt = new Customer("Matt", "passwordy", acc);
//		ArrayList<Integer> acc = new ArrayList<Integer>();
//		acc.add(99999);
		
//		Employee anas = new Employee("Anas", "password1");
//		Admin anas2 = new Admin("Anas", "password2");
		
		// Print main menu
		mainMenu();
	}
	
	
	
	//----------------------Main Menu--------------------------------------------//
	
	public static void mainMenu() {
		System.out.println("Welcome to Children's Bank");
		System.out.println("Please select an option");
		
		PrintMenu mainMenu = new PrintMenu("Main Menu", "Register Account", "Login", "Employee", "Bank Admin", "Exit");
		mainMenu.display();
		int mainMenuChoice = scan.nextInt();
		// Switch statement to process option chosen
		
		switch(mainMenuChoice) {
		default:
			System.out.println("Invalid input\n");
			mainMenu();
			//Terminate program
			System.exit(0);
		case 1:
			Registration.registerMenu();
			break;
		case 2:
			// Process login for existing user
			CustomerScr.userLogin();
			break;
		case 3:
			// Employee login
			EmployeeScr.employeeLogin();
			break;
		case 4: 
			 // Bank administrator login
			AdminScr.adminLogin();
			break;
		case 5:
			// Exit program
			System.out.println("\nThank you for banking with us");
			break;
		}
		
	}
}


