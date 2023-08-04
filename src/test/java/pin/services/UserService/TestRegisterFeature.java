package pin.services.UserService;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import pin.model.*;

import pin.service.*;
import pin.service.exception.ServiceException;

public class TestRegisterFeature {
	@Test
	public void testRegistrationSuccess() {

		UserService userservice = new UserService();
		User user1 = new User("soffan2906@gmail.com", "Soffan", "Wow@2002", "9092500612");

		try {
			assertTrue(userservice.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();
			System.out.println(e);

		}

	}

	@Test
	public void testRegistrationFail() {

		UserService userservice = new UserService();
		User user1 = new User("soffafuywg892698gmail.com", "Soffan", "Wow@2002", "9092500612");

		try {
			assertFalse(userservice.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}

	}

	@Test
	public void testUserNull() {

		UserService userservice = new UserService();
		User user1 = null;

		try {
			assertFalse(userservice.registerUser(user1));
		} catch (ServiceException e) {
			e.printStackTrace();

		}

	}

}
