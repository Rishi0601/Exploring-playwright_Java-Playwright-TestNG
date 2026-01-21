package com.rishi.pw.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;

public class DriverSetup {

	protected Playwright playwright;
	public static Page page;
	protected Browser browser;
	protected BrowserContext browserContext;
	protected static String videoFilePath;

	public void launchBrowser(String browserType) {
		playwright = Playwright.create();
		browser = selectBrowser(browserType);
		browserContext = browser.newContext(new NewContextOptions().setViewportSize(null)
				.setRecordVideoDir(Path.of(System.getProperty("user.dir") + "/videos/"))
				.setRecordVideoSize(1920, 1080));
		page = browserContext.newPage();
	}

	public void navigateToUrl(String url) {
		page.navigate(url);
	}

	public Browser selectBrowser(String browserType) {
		switch (browserType.toLowerCase()) {
		case "chrome", "msedge":
			return playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel(browserType)
					.setHeadless(false).setArgs(List.of("--start-maximized")));
		case "firefox":
			return playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
		case "webkit":
			return playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
		default:
			throw new IllegalArgumentException("Unsupported browser type: " + browserType);
		}
	}

	public void startTracerUtils(BrowserContext browserContext) {
		browserContext.tracing()
				.start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true).setSources(true));
	}

	public void stopTracerUtils(BrowserContext browserContext, String filePath) {
		browserContext.tracing().stop(new Tracing.StopOptions().setPath(Path.of(filePath)));
	}

	public String saveVideoAs(String videoName) {
		Path originalPath = page.video().path();
		Path newPath = Path.of(System.getProperty("user.dir") + "/videos/" + videoName + ".webm");
		try {
			Files.move(originalPath, newPath, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return newPath.toString();
	}

	public void teardown(String videoName) {
		page.close();
		browserContext.close();
		videoFilePath = saveVideoAs(videoName);
		browser.close();
		playwright.close();
	}
}
