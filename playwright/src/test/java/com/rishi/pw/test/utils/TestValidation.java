package com.rishi.pw.test.utils;

import org.testng.Assert;

import com.rishi.pw.ui.LoginpageLocators;
import com.rishi.pw.utils.HelperMethods;

public class TestValidation {

	LoginpageLocators loginpageLocators = new LoginpageLocators();
	HelperMethods helperMethods = new HelperMethods();

	public void validateErrorMessage(String expectedMessage) {
		String actualMessage = helperMethods.getText(loginpageLocators.invalidMobileNumberMsg);
		Assert.assertTrue(actualMessage.equalsIgnoreCase(expectedMessage));
	}
}
