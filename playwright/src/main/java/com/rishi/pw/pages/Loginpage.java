package com.rishi.pw.pages;

import com.microsoft.playwright.Page;
import com.rishi.pw.ui.LoginpageLocators;
import com.rishi.pw.utils.DriverSetup;
import com.rishi.pw.utils.HelperMethods;

public class Loginpage {

	LoginpageLocators loginpageLocators = new LoginpageLocators();
	HelperMethods helperMethods = new HelperMethods();

	public void loginByMobileNumber(String mobileNumber) {
		helperMethods.waitForElementToBeVisible(loginpageLocators.mobileNumber);
		helperMethods.clickOnElement(loginpageLocators.mobileNumber);
		helperMethods.waitTillPageLoad(DriverSetup.getPage(), "page");
		helperMethods.enterText(loginpageLocators.mobileNumber, mobileNumber);
		helperMethods.clickOnElement(loginpageLocators.continueBtn);
	}

	public Page gotoTermsAndCondition() {
		return helperMethods
				.switchToNewWindow(() -> helperMethods.clickOnElement(loginpageLocators.termsAndConditions));
	}

	public Page gotoPrivacyNotes() {
		return helperMethods.switchToNewWindow(() -> helperMethods.clickOnElement(loginpageLocators.privacyPolicy));
	}

	public void backToLoginPage() {
		helperMethods.switchToOriginalWindow();
	}

	public void gotoFlipkartPlus() {
		helperMethods.clickOnElement(loginpageLocators.flipkartPlus);
	}
}
