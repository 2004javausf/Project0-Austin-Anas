package com.revature.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Customer;

public class IO {
	public static final String customerFile = "customerList.txt";
	public static final String pendingFile = "pendingCustomerList.txt";
	
	public static void writeCustomerFile(List<Customer> a) {
		try {
			ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(customerFile));
			objectOut.writeObject(a);
			objectOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//read method
	@SuppressWarnings("unchecked")
	public static void readCustomerFile() {
		try {
			ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(customerFile));
			UserInfo.customerList = (ArrayList<Customer>) objectIn.readObject();
			objectIn.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		}
	}
}