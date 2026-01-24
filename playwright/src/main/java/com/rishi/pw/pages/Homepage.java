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

	public void goToScialLinksAtFooter() {
		LoggerHandler.info("Navigate to social links at footer");
		helperMethods.scrollToElement(homepageLocators.socialLinks);
		helperMethods.getTextFromListOfElements(homepageLocators.socialLinks);
	}
	
	public void goToHomepageCategories() {
		LoggerHandler.info("Navigate t Home page product Categries");
		helperMethods.scrollToElement(homepageLocators.homepageCategories.nth(0));
	}
}
