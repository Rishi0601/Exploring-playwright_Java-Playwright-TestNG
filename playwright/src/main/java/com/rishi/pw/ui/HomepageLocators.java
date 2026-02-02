package com.rishi.pw.ui;

import com.microsoft.playwright.Locator;
import com.rishi.pw.utils.DriverSetup;

public final class HomepageLocators extends DriverSetup {

	public final Locator loginBtnImg = page.getByAltText("Login").first();
	public final Locator loginBtn = page.locator("[class*='lr29Nk']");
	public final Locator signUp = page.locator("a[title='Sign Up']");
	public final Locator footerLinks = page.locator(".XnhcQm");
	public final Locator socialLinks = page.locator("//div[@class='OPpkAJ']/a");
	public final Locator homepageCategories = page.locator(".tVzyDb");
	public final Locator sellerSection = page.locator("[class*='ijdqUS'][title='Become a Seller']");
	public final Locator searchBar = page.getByPlaceholder("Search for Products, Brands and More").first();
	public final Locator searchBtn = page.locator("button[class='kV1UjG']");
}
