package com.revature.menu;

import java.util.Scanner;

import com.revature.screen.Login;
import com.revature.screen.Register;

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
			Register.registerMenu();
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
	
	public static void loginMenu() {
		System.out.println("Welcome back my child");
		System.out.println("Please select an option");
		
		PrintMenu loginMenu = new PrintMenu("Menu", "Check Balance", "Deposit", "Withdraw", "Open New Bank Account", "Exit");
		loginMenu.display();
		int loginMenuChoice = scan.nextInt();
		// Switch statement to process option chosen
		switch(loginMenuChoice) {
		case 1:
			Register.registerMenu();
			break;
		case 2:
			// Process login for existing user
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
}
