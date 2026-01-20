package com.rishi.pw.pages;

import org.testng.Assert;

import com.rishi.pw.ui.LoginpageLocators;
import com.rishi.pw.utils.HelperMethods;

public class Loginpage {

	LoginpageLocators loginpageLocators = new LoginpageLocators();
	HelperMethods helperMethods = new HelperMethods();

	public void loginByMobileNumber(String mobileNumber) {
		helperMethods.clickOnElement(loginpageLocators.mobileNumber);
		helperMethods.enterText(loginpageLocators.mobileNumber, mobileNumber);
		helperMethods.clickOnElement(loginpageLocators.continueBtn);
		Assert.assertTrue(helperMethods.isDisplayed(loginpageLocators.invalidMobileNumberMsg));
	}
}
