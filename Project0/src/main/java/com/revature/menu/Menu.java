package com.revature.menu;

import java.util.Scanner;

import com.revature.screen.Login;
import com.revature.screen.Registration;

public class Menu {
	static Scanner scan = new Scanner(System.in);
	static Scanner scString = new Scanner(System.in);
	
	public static void mainMenu() {
		System.out.println("Welcome to Children's Bank");
		System.out.println("Please select an option");
		
		PrintMenu mainMenu = new PrintMenu("Main Menu", "Register Account", "Login", "Employee", "Bank Admin", "Exit");
		mainMenu.display();
		int mainMenuChoice = scan.nextInt();
		// Switch statement to process option chosen
		
		switch(mainMenuChoice) {
		case 1:
			Registration.registerMenu();
			break;
		case 2:
			// Process login for existing user
			Login.userLogin();
			break;
		case 3:
			// Employee login
			break;
		case 4: 
			 // Bank admin login
			break;
		case 5:
			System.out.println("Thanks for banking with us");
			break;
		default:
			System.out.println("Invalid input. Goodbye \n");
			//Terminate program
			System.exit(0);
		}
	}
	
	
	//----------------------------Customer Menu------------------------------------------------//
	public static void customerMenu() {
		System.out.println("Welcome back my child");
		System.out.println("Please select an option");
		
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
			break;
		case 4: 
			 // Open new account
			break;
		case 5:
			// Main menu
			Menu.mainMenu();
			break;
		case 6:
			// Exit
		default:
			System.out.println("Invalid input. Goodbye \n");
			
			//Terminate program
			System.exit(0);
		}
	}
	
	//------------------------------Employee Menu---------------------------------------------//
	public static void employeeMenu() {
		System.out.println("Welcome back sir");
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
			Menu.mainMenu();
		default:
			System.out.println("Invalid input. Goodbye \n");	
			//Terminate program
			System.exit(0);
		}
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
				Menu.mainMenu();
			default:
				System.out.println("Invalid input. Goodbye \n");	
				//Terminate program
				System.exit(0);
			}
	}
}
