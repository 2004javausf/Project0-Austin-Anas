package com.revature.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.revature.util.IO;
import com.revature.util.UserInfo;

public class Customer implements Serializable {
		
		private static final long serialVersionUID = -843910110760542167L;
		//personal account 
		private String username;
		private String password;
		private List<Integer> accountNumbers = new ArrayList<Integer>();
		private Map <Integer, Double> accNo = new HashMap<>();
		private boolean pendingAcc;

		// Constructors
		public Customer() {
			super();
			this.username = "";
			this.accountNumbers = new ArrayList<Integer>();
			UserInfo.customerList.add(this);
		}
		
		public Customer(String username, String password) {
			super();
			this.username = username;
			this.password = password;
			this.accountNumbers = new ArrayList<Integer>();
			UserInfo.customerList.add(this);
			IO.writeCustomerFile(UserInfo.customerList);
		}

		public Customer(String username, String password, Map<Integer, Double> accNo) {
			super();
			this.username = username;
			this.password = password;
			this.accNo = accNo;
			//this.accountNumbers = accountNumbers;
			UserInfo.customerList.add(this);
			IO.writeCustomerFile(UserInfo.customerList);
			
		}
		// Getter and Setter methods
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

		public List<Integer> getAccountNumbers() {
			return accountNumbers;
		}

		public void setAccountNumbers(List<Integer> accountNumbers) {
			this.accountNumbers = accountNumbers;
		}

		
		public Map<Integer, Double> getAccNo() {
			return accNo;
		}

		public void setAccNo(Map<Integer,Double> accNo) {
			this.accNo = accNo;
		}
		
		public boolean isPendingAcc() {
			return pendingAcc;
		}

		public void setPendingAcc(boolean pendingAcc) {
			this.pendingAcc = pendingAcc;
		}

		@Override
		public String toString() {
			return "Customer [username=" + username + ", password=" + password + ", accNo=" + accNo + "]";
		}
				
}
