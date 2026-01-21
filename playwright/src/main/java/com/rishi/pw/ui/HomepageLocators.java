package com.rishi.pw.ui;

import com.microsoft.playwright.Locator;
import com.rishi.pw.utils.DriverSetup;

public final class HomepageLocators extends DriverSetup {

	public final Locator loginBtn = page.locator("a[title='Login'][class='iyMZqb']");
	public final Locator signUp = page.locator("a[title='Sign Up']");
	public final Locator footerLinks = page.locator(".XnhcQm");
}
