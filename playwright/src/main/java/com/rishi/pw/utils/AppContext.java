package com.rishi.pw.utils;

import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class AppContext {

	private static final ThreadLocal<Playwright> playwrightThreadLocal = new ThreadLocal<>();
	private static final ThreadLocal<Browser> browserThreadLocal = new ThreadLocal<>();
	private static final ThreadLocal<BrowserContext> browserContexThreadLocal = new ThreadLocal<>();
	private static final ThreadLocal<Page> pageThreadLocal = new ThreadLocal<>();
	private static final ThreadLocal<ExtentTest> testThreadlocal = ThreadLocal.withInitial(() -> null);

	public static void setTest(ExtentTest test) {
		testThreadlocal.set(test);
	}

	public static ExtentTest getTest() {
		return testThreadlocal.get();
	}

	public static void setPlaywright(Playwright playwright) {
		playwrightThreadLocal.set(playwright);
	}

	public static Playwright getPlaywright() {
		return playwrightThreadLocal.get();
	}

	public static void setBrowser(Browser browser) {
		browserThreadLocal.set(browser);
	}

	public static Browser getBrowser() {
		return browserThreadLocal.get();
	}

	public static void setBrowserContext(BrowserContext browserContext) {
		browserContexThreadLocal.set(browserContext);
	}

	public static BrowserContext getBrowserContext() {
		return browserContexThreadLocal.get();
	}

	public static void setPage(Page page) {
		pageThreadLocal.set(page);
	}

	public static Page getPage() {
		return pageThreadLocal.get();
	}

	public static void removeThreadLocalResources() {
		playwrightThreadLocal.remove();
		browserContexThreadLocal.remove();
		browserThreadLocal.remove();
		pageThreadLocal.remove();
		testThreadlocal.remove();
	}
}
