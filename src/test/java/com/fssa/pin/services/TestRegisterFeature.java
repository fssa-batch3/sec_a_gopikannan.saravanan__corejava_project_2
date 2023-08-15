package com.fssa.pin.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fssa.pin.model.*;
import com.fssa.pin.service.*;
import com.fssa.pin.service.exception.ServiceException;

 class TestRegisterFeature {
	@Test
	 void testRegistrationSuccess() {

		UserService userservice = new UserService();
		User user1 = new User("gopikannan2906@gmail.com", "Gopikannan", "Wow@2002", "9092500612");

		try {
			assertTrue(userservice.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();
			System.out.println(e);

		}

	}

	@Test
	 void testRegistrationFail() {

		UserService userservice = new UserService();
		User user1 = new User("soffafuywg892698gmail.com", "Soffan", "Wow@2002", "9092500612");

		try {
			assertFalse(userservice.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}

	}

	@Test
	 void testUserNull() {

		UserService userservice = new UserService();
		User user1 = null;

		try {
			assertFalse(userservice.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}

	}

}