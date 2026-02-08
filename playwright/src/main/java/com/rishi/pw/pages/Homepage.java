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
		helperMethods.waitTillPageLoad(DriverSetup.getPage(), "");
		helperMethods.clickOnElement(homepageLocators.loginBtnImg);
	}

	public void goToFooter() {
		LoggerHandler.info("Login button visible");
		helperMethods.waitTillPageLoad(DriverSetup.getPage(), "");
		helperMethods.waitForElementToBeVisible(homepageLocators.searchBar);
		LoggerHandler.info("Scrolling to footer links");
		helperMethods.scrollToElement(homepageLocators.footerLinks.nth(0));
	}

	public void goToSocialLinksAtFooter() {
		LoggerHandler.info("Navigate to social links at footer");
		helperMethods.scrollToElement(homepageLocators.socialLinks);
		helperMethods.getTextFromListOfElements(homepageLocators.socialLinks);
	}

	public void goToSellerSection() {
		LoggerHandler.info("Navigate to Seller section");
		helperMethods.waitTillPageLoad(DriverSetup.getPage(), "");
		helperMethods.clickOnElement(homepageLocators.sellerSection);
		helperMethods.waitTillPageLoad(DriverSetup.getPage(), "");
	}

	public void searchProducts(String product) {
		LoggerHandler.info("Searching product: " + product);
		helperMethods.waitTillPageLoad(DriverSetup.getPage(), "");
		helperMethods.clickOnElement(homepageLocators.searchBar);
		helperMethods.enterText(homepageLocators.searchBar, product);
		helperMethods.keyboardAction(homepageLocators.searchBar, "Enter");
		helperMethods.waitTillPageLoad(DriverSetup.getPage(), "page");
	}
}
