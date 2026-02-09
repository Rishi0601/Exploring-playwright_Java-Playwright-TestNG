package com.rishi.pw.test.utils;

import java.util.HashMap;
import java.util.List;

import org.testng.Assert;

import com.microsoft.playwright.Page;
import com.rishi.pw.ui.HomepageLocators;
import com.rishi.pw.ui.LoginpageLocators;
import com.rishi.pw.ui.ProductResultspageLocators;
import com.rishi.pw.utils.AppContext;
import com.rishi.pw.utils.DriverSetup;
import com.rishi.pw.utils.HelperMethods;

public class TestValidation extends DriverSetup {

	HomepageLocators homepageLocators = new HomepageLocators();
	LoginpageLocators loginpageLocators = new LoginpageLocators();
	ProductResultspageLocators productResultspageLocators = new ProductResultspageLocators();
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
		helperMethods.waitTillPageLoad(AppContext.getPage(), "page");
		String pageUrl = helperMethods.getPageUrl();
		Assert.assertEquals(pageUrl, url);
	}

	public void validateSocialLink(List<String> list) {
		List<String> localList = helperMethods.getAttributesFromListOfElements(homepageLocators.socialLinks, "href");
		for (int i = 0; i < localList.size(); i++) {
			Assert.assertTrue(localList.get(i).toLowerCase().contains(list.get(i).toLowerCase()));
		}
	}

	public void validateSellerSectionUrl(String url) {
		String currentUrl = helperMethods.getPageUrl();
		Assert.assertTrue(currentUrl.toLowerCase().contains(url.toLowerCase()));
	}

	public void validateResultsAfterSearch(HashMap<String, String> map, int price) {
		for (String str : map.keySet()) {
			Assert.assertTrue(Integer.parseInt(str) <= price);
		}
	}
}
