package com.rishi.pw.test.utils;

import java.util.List;

import org.testng.Assert;

import com.microsoft.playwright.Page;
import com.rishi.pw.ui.HomepageLocators;
import com.rishi.pw.ui.LoginpageLocators;
import com.rishi.pw.utils.DriverSetup;
import com.rishi.pw.utils.HelperMethods;

public class TestValidation {

	HomepageLocators homepageLocators = new HomepageLocators();
	LoginpageLocators loginpageLocators = new LoginpageLocators();
	HelperMethods helperMethods = new HelperMethods();

	public void validateErrorMessage(String expectedMessage) {
		String actualMessage = helperMethods.getText(loginpageLocators.invalidMobileNumberMsg);
		Assert.assertTrue(actualMessage.equalsIgnoreCase(expectedMessage));
	}

	public void validateLoginHyperlinks(Page page, String keyword) {
		String pageTitle = helperMethods.getPageTitle(page);
		Assert.assertTrue(pageTitle.toLowerCase().contains(keyword.toLowerCase()));
	}

	public void validateTotalFooterLinks(String value) {
		List<String> footerList = helperMethods.getTextFromListOfElements(homepageLocators.footerLinks);
		Assert.assertEquals(footerList.size(), Integer.parseInt(value));
	}

	public void validateFlipkartPlusPage(String url) {
		helperMethods.waitTillPageLoad(DriverSetup.page, "page");
		String pageUrl = helperMethods.getPageUrl();
		Assert.assertEquals(pageUrl, url);
	}
}
