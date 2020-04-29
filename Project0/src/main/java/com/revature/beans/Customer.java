package com.revature.beans;

import java.io.Serializable;

import com.revature.util.IO;
import com.revature.util.PersonalUserInfo;

public class Customer implements Serializable {
		
		private static final long serialVersionUID = -843910110760542167L;
		//personal account 
		private String username;
		private String password;
		private static int accountNumber = 10000;
		private double accountBalance;

		//Constructors
		public Customer() {
			super();
			this.accountNumber = accountNumber++;
			PersonalUserInfo.customerList.add(this);
		}
		
		public Customer(String username, String password) {
			super();
			this.username = username;
			this.password = password;
			PersonalUserInfo.customerList.add(this);
			IO.writeCustomerFile(PersonalUserInfo.customerList);
		}

		public Customer(String username, String password, int accountNumber, double accountBalance) {
			super();
			this.username = username;
			this.password = password;
			this.accountNumber = accountNumber++;
			this.accountBalance = accountBalance;
			PersonalUserInfo.customerList.add(this);
			IO.writeCustomerFile(PersonalUserInfo.customerList);
		}
		//getters and setters
		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public int getAccountNumber() {
			return accountNumber;
		}

		public void setAccountNumber(int accountNumber) {
			this.accountNumber = accountNumber;
		}

		public double getAccountBalance() {
			return accountBalance;
		}

		public void setAccountBalance(double accountBalance) {
			this.accountBalance = accountBalance;
		}

		@Override
		public String toString() {
			return "Customer [username=" + username + ", password=" + password + ", accountNumber=" + accountNumber
					+ ", accountBalance=" + accountBalance + "]";
		}
		
		
		
}
