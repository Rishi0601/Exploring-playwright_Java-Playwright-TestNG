package com.rishi.pw.test.utils;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.rishi.pw.ui.HomepageLocators;
import com.rishi.pw.ui.LoginpageLocators;
import com.rishi.pw.utils.DriverSetup;
import com.rishi.pw.utils.HelperMethods;

public class TestValidation extends DriverSetup {

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
		helperMethods.waitTillPageLoad(page, "page");
		String pageUrl = helperMethods.getPageUrl();
		Assert.assertEquals(pageUrl, url);
	}

	public void validateListOfElements(Locator locator, String attribute, List<String> list) {
		List<String> extractedList = new ArrayList<String>();
		for (int i = 0; i < locator.count(); i++) {
			extractedList.add(helperMethods.getAttribute(locator.nth(i), attribute));
		}
		for (int i = 0; i < extractedList.size(); i++) {
			Assert.assertTrue(extractedList.get(i).toLowerCase().contains(list.get(i).toLowerCase()));
		}
	}

	public void validateSocialLink(List<String> list) {
		validateListOfElements(homepageLocators.socialLinks, "href", list);
	}

	public void validateHomepageProductCategories(List<String> list) {
		validateListOfElements(homepageLocators.homepageCategories, "aria-label", list);
	}
}
