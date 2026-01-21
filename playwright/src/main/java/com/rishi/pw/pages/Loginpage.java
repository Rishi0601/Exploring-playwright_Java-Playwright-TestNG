package com.rishi.pw.pages;

import com.microsoft.playwright.Page;
import com.rishi.pw.ui.LoginpageLocators;
import com.rishi.pw.utils.HelperMethods;

public class Loginpage {

	LoginpageLocators loginpageLocators = new LoginpageLocators();
	HelperMethods helperMethods = new HelperMethods();
	Page page;

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

	public Page gotoTermsAndCondition() {
		page = helperMethods
				.switchToNewWindow(() -> helperMethods.clickOnElement(loginpageLocators.termsAndConditions));
		return page;
	}

	public Page gotoPrivacyNotes() {
		page = helperMethods.switchToNewWindow(() -> helperMethods.clickOnElement(loginpageLocators.privacyPolicy));
		return page;
	}

	public void backToLoginPage() {
		helperMethods.switchToOriginalWindow();
	}

	public void gotoFlipkartPlus() {
		helperMethods.clickOnElement(loginpageLocators.flipkartPlus);
	}
}
