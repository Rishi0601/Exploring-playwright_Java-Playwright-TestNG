package com.rishi.pw.ui;

import com.microsoft.playwright.Locator;
import com.rishi.pw.utils.DriverSetup;

public final class HomepageLocators extends DriverSetup {

	public final Locator loginBtnImg = getPage().getByAltText("Login").first();
	public final Locator loginBtn = getPage().locator("[class*='lr29Nk']");
	public final Locator signUp = getPage().locator("a[title='Sign Up']");
	public final Locator footerLinks = getPage().locator(".XnhcQm");
	public final Locator socialLinks = getPage().locator("//div[@class='OPpkAJ']/a");
	public final Locator homepageCategories = getPage().locator(".tVzyDb");
	public final Locator sellerSection = getPage().locator("[class*='ijdqUS'][title='Become a Seller']");
	public final Locator searchBar = getPage().getByPlaceholder("Search for Products, Brands and More").first();
	public final Locator searchBtn = getPage().locator("button[class='kV1UjG']");
}
