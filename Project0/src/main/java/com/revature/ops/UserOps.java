package com.revature.ops;

import java.util.Scanner;

public abstract class UserOps {
	
	public static Scanner scanInt = new Scanner(System.in);
	

	// method for checking if customer has account or not
	
	public static boolean hasAccount(String username) {
		
		return false;	
	}
	
	// method for withdrawals
	public static void withdraw(String acc) {
		System.out.println("Enter the amount to withdraw");
		double withdraw = scanInt.nextDouble();
		
		if(withdraw > )
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
