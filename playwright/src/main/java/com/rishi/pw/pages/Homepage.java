package com.rishi.pw.pages;

import java.util.List;

import com.rishi.pw.ui.HomepageLocators;
import com.rishi.pw.utils.HelperMethods;

public class Homepage {

	HomepageLocators homepageLocators = new HomepageLocators();
	HelperMethods helperMethods = new HelperMethods();

	public void loginToFlipkart() {
		helperMethods.waitForElementToBeVisible(homepageLocators.loginBtn);
		helperMethods.clickOnElement(homepageLocators.loginBtn);
	}

	public void goToFooter() {
		helperMethods.waitForElementToBeVisible(homepageLocators.loginBtn);
		helperMethods.scrollToElement(homepageLocators.footerLinks.nth(0));
	}
}
