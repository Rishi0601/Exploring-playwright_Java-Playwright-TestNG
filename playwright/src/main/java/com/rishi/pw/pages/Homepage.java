package com.rishi.pw.pages;

import com.rishi.pw.ui.HomepageLocators;
import com.rishi.pw.utils.HelperMethods;
import com.rishi.pw.utils.LoggerHandler;

public class Homepage {

	HomepageLocators homepageLocators = new HomepageLocators();
	HelperMethods helperMethods = new HelperMethods();

	public void loginToFlipkart() {
		LoggerHandler.info("Login button visible");
		helperMethods.waitForElementToBeVisible(homepageLocators.loginBtn);
		helperMethods.clickOnElement(homepageLocators.loginBtn);
	}

	public void goToFooter() {
		LoggerHandler.info("Login button visible");
		helperMethods.waitForElementToBeVisible(homepageLocators.loginBtn);
		LoggerHandler.info("Scrolling to footer links");
		helperMethods.scrollToElement(homepageLocators.footerLinks.nth(0));
	}
}
