package com.rishi.pw.ui;

import com.microsoft.playwright.Locator;
import com.rishi.pw.utils.DriverSetup;

public final class LoginpageLocators extends DriverSetup {

	public final Locator signUpMsg1 = page.locator(".iq0fCx");
	public final Locator signUpMsg2 = page.locator(".rda_OW");
	public final Locator mobileNumber = page.locator("input[class*=c3Bd2c]");
	public final Locator continueBtn = page.locator("button[class*='dSM5Ub']");
	public final Locator existingUserBtn = page.locator("a[class*='dSM5Ub']");
	public final Locator invalidMobileNumberMsg = page.locator(".AiNWLu");
}
