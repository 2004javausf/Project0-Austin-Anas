package com.revature.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.beans.Customer;
import com.revature.util.UserInfo;

class UserInfoTest {

		Customer c = new Customer("Brad", "password");
		String brad = "Brad";
		
		
		@Test
		void checkUserInfo() {
			//expected, actual
			assertEquals(false, UserInfo.validateUniqueUsername(brad));
		}
		
		@Test
		void validateUser() {
			//expected, actual
			assertEquals(c, UserInfo.findCustomerByUsername(brad));
		}


}
