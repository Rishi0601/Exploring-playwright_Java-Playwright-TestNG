package com.rishi.pw.pages;

import com.rishi.pw.ui.LoginpageLocators;
import com.rishi.pw.utils.HelperMethods;

public class Loginpage {

	LoginpageLocators loginpageLocators = new LoginpageLocators();
	HelperMethods helperMethods = new HelperMethods();

	public void loginByMobileNumber(String mobileNumber) {
		helperMethods.waitForElementToBeVisible(loginpageLocators.mobileNumber);
		helperMethods.clickOnElement(loginpageLocators.mobileNumber);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		helperMethods.enterText(loginpageLocators.mobileNumber, mobileNumber);
		helperMethods.clickOnElement(loginpageLocators.continueBtn);
	}
}
