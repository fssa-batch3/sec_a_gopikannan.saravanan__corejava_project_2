package com.fssa.pin.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.fssa.pin.validation.exceptions.InvalidUserException;

 class TestValidateMobileNo {
	@Test
	 void testValidMobileNo() {
		try {
		
			assertTrue(UserValidator.validateMobileNo("9876543210"));
			System.out.println("Your mobile number is correct");
		} catch (InvalidUserException e) {

			System.out.println(e.getMessage());
		}
	} 

	@Test
	 void testInvalidMobileNoWithLessThan10Digits() {
		try {
			
			assertFalse(UserValidator.validateMobileNo("987654321"));
			System.out.println("Mobile number should be in 10 digits only");
		} catch (InvalidUserException e) {

			System.out.println(e.getMessage());
		}
	}

	@Test
	 void testInvalidMobileNoWithMoreThan10Digits() {
		try {
			
			assertFalse(UserValidator.validateMobileNo("98765432101"));
			System.out.println("Mobile number contains 10 digits only");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	 void testInvalidMobileNoWithPrefixOtherThan6789() {
		try {
		
			assertFalse(UserValidator.validateMobileNo("5678901234"));
			System.out.println("Mobile number do not start with 5 ");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage()); 
		}
	}

	@Test
	 void testInvalidMobileNoWithNonNumericCharacters() {
		try {
			
			assertFalse(UserValidator.validateMobileNo("9876a43210"));
			System.out.println("Mobile number contains integer");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());

		}
	}

	@Test
	 void testInvalidMobileNoStartingWithZero() {
		try {
			
			assertFalse(UserValidator.validateMobileNo("0123456789"));
			System.out.println("Mobile number do not start with 0 ");
		} catch (InvalidUserException e) {
			System.out.println(e.getMessage());
		}
	}
}
