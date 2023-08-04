package pin.Validation.UserTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pin.validation.UserValidator;
import pin.validation.exceptions.InvalidUserException;

public class TestValidateEmail {
	@Test
	void testValidEmail() {

		try {

			assertTrue(UserValidator.validateEmail("soffan2906@gmail.com"));
			System.out.println("Your email is valid");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	void testInvalidEmailWithoutAtSymbol() {
		try {

			assertFalse(UserValidator.validateEmail("soffan2906gmail.com"));
			System.out.println("Your email is not valid");
		} catch (InvalidUserException e) {
			System.out.println("Your email is valid");
		}
	}

	@Test
	void testInvalidEmailWithoutcom() {
		try {
			assertFalse(UserValidator.validateEmail("soffan2906@"));
			System.out.println("Your email is not valid");

		} catch (InvalidUserException e) {
			System.out.println("Your email is valid");
		}
	}

}
