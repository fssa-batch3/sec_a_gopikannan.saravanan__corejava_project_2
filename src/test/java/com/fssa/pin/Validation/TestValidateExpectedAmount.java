package com.fssa.pin.Validation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.fssa.pin.validation.FundraiseValidation;
import com.fssa.pin.validation.exceptions.InvalidFundraiseException;

class TestValidateExpectedAmount {
	@Test
	void testValidAmount() {
		try {
			assertTrue(FundraiseValidation.validateExpectedAmount(15000));

		} catch (InvalidFundraiseException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	void testInvalidAmount() {
		try {
			assertFalse(FundraiseValidation.validateExpectedAmount(5000));

		} catch (InvalidFundraiseException e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	void testMaximumValidAmount() {
		try {
			assertFalse(FundraiseValidation.validateExpectedAmount(100000000));
		} catch (InvalidFundraiseException e) {
			System.out.println("The fundraise amount should not be a more than 10000000.");
		}
	}

	@Test
	void testNegativeAmount() {
		try {
			assertFalse(FundraiseValidation.validateExpectedAmount(-5000));
			System.out.println("The amount is invalid.");
		} catch (InvalidFundraiseException e) {
			System.out.println("The fundraise amount should not be in negative");
		}
	}

}