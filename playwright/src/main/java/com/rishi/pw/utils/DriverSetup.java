package com.rishi.pw.utils;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DriverSetup {

	protected Page page;
	protected Browser browser;
	
	public void launchBrowser(String browserType, String url) {
		Playwright playwright = Playwright.create();

		switch (browserType.toLowerCase()) {
			case "chrome", "msedge" -> {
				browser = playwright.chromium()
						.launch(new BrowserType.LaunchOptions().setChannel(browserType).setHeadless(false));
			}
			case "firefox" -> {
				browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			}
			case "webkit" -> {
				browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
			}
		}
		
		page = browser.newContext().newPage();
		page.navigate(url);
	}
}
