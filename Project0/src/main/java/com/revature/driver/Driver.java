package com.revature.driver;

import java.util.Scanner;

import com.revature.menu.PrintMenu;
import com.revature.screen.AdminScr;
import com.revature.screen.CustomerScr;
import com.revature.screen.EmployeeScr;
import com.revature.screen.Registration;
import com.revature.util.IO;
import com.revature.util.UserInfo;

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


