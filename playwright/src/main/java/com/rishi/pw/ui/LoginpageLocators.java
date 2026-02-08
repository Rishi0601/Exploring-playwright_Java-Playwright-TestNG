package com.rishi.pw.ui;

import com.microsoft.playwright.Locator;
import com.rishi.pw.utils.DriverSetup;

public final class LoginpageLocators extends DriverSetup {

	public final Locator signUpMsg1 = getPage().locator(".iq0fCx");
	public final Locator signUpMsg2 = getPage().locator(".rda_OW");
	public final Locator mobileNumber = getPage().locator("input[class*=c3Bd2c]");
	public final Locator continueBtn = getPage().locator("button[class*='dSM5Ub']");
	public final Locator existingUserBtn = getPage().locator("a[class*='dSM5Ub']");
	public final Locator invalidMobileNumberMsg = getPage().locator(".AiNWLu");
	public final Locator termsAndConditions = getPage().locator("a[class='OJROhA'][href*=terms]");
	public final Locator privacyPolicy = getPage().locator("a[class='OJROhA'][href*=privacy]");
	public final Locator flipkartPlus = getPage().locator(".p8iyLE");
}
