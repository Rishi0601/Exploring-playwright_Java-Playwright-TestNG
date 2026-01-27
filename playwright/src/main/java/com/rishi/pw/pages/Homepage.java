package com.rishi.pw.pages;

import com.rishi.pw.ui.HomepageLocators;
import com.rishi.pw.utils.DriverSetup;
import com.rishi.pw.utils.HelperMethods;
import com.rishi.pw.utils.LoggerHandler;

public class Homepage {

	HomepageLocators homepageLocators = new HomepageLocators();
	HelperMethods helperMethods = new HelperMethods();

	public void loginToFlipkart() {
		LoggerHandler.info("Login button visible");
		helperMethods.waitForElementToBeVisible(homepageLocators.loginBtn);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		helperMethods.clickOnElement(homepageLocators.loginBtn);
	}

	public void goToFooter() {
		LoggerHandler.info("Login button visible");
		helperMethods.waitForElementToBeVisible(homepageLocators.loginBtn);
		LoggerHandler.info("Scrolling to footer links");
		helperMethods.scrollToElement(homepageLocators.footerLinks.nth(0));
	}

	public void goToSocialLinksAtFooter() {
		LoggerHandler.info("Navigate to social links at footer");
		helperMethods.scrollToElement(homepageLocators.socialLinks);
		helperMethods.getTextFromListOfElements(homepageLocators.socialLinks);
	}
	
	public void goToHomepageCategories() {
		LoggerHandler.info("Navigate to Home page product Categries");
		helperMethods.scrollToElement(homepageLocators.homepageCategories.nth(0));
	}
	
	public void goToSellerSection() {
		LoggerHandler.info("Navigate to Seller section");
		helperMethods.clickOnElement(homepageLocators.sellerSection);
		helperMethods.waitTillPageLoad(DriverSetup.page, "");
	}
	
	public void searchProducts(String product) {
		LoggerHandler.info("Searching product: "+product);
		helperMethods.clickOnElement(homepageLocators.searchBar);
		helperMethods.enterText(homepageLocators.searchBar, product);
		helperMethods.clickOnElement(homepageLocators.searchBtn);
		helperMethods.waitTillPageLoad(DriverSetup.page, "page");
	}
}
