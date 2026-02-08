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

	private static final ThreadLocal<Playwright> playwrightThreadLocal = new ThreadLocal<>();
	private static final ThreadLocal<Browser> browserThreadLocal = new ThreadLocal<>();
	private static final ThreadLocal<BrowserContext> browserContexThreadLocal = new ThreadLocal<>();
	private static final ThreadLocal<Page> pageThreadLocal = new ThreadLocal<>();

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

	public static void initGlobalResources() {
		setPlaywright(Playwright.create());
		setBrowser(selectBrowser(PropertiesReader.getProperty().getProperty("browser")));
	}

	public void launchBrowser() {
		setBrowserContext(getBrowser().newContext(new NewContextOptions().setViewportSize(null)));
//				.setRecordVideoDir(Path.of(System.getProperty("user.dir") + "/videos/"))
//				.setRecordVideoSize(1920, 1080));
		LoggerHandler.info("Launching browser");
		setPage(getBrowserContext().newPage());
	}

	public void navigateToUrl(String url) {
		LoggerHandler.info("Opening website");
		getPage().navigate(url);
	}

	public static Browser selectBrowser(String browserType) {
		LoggerHandler.info("Scripts running on browser: " + browserType);
		switch (browserType.toLowerCase()) {
		case "chrome", "msedge":
			return getPlaywright().chromium().launch(new BrowserType.LaunchOptions().setChannel(browserType)
					.setHeadless(false).setArgs(List.of("--start-maximized")));
		case "firefox":
			return getPlaywright().firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
		case "webkit":
			return getPlaywright().webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
		default:
			throw new IllegalArgumentException("Unsupported browser type: " + browserType);
		}
	}

	public void startTracerUtils() {
		LoggerHandler.info("Started tracing test");
		getBrowserContext().tracing()
				.start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true).setSources(true));
	}

	public void stopTracerUtils(String filePath) {
		LoggerHandler.info("Stopped tracing test");
		getBrowserContext().tracing().stop(new Tracing.StopOptions().setPath(Path.of(filePath)));
	}

	public String saveVideoAs(String videoName) {
		Path originalPath = getPage().video().path();
		LoggerHandler.info("Target video saving path: " + originalPath.toString());
		Path newPath = Path.of(System.getProperty("user.dir") + "/videos/" + videoName + ".webm");
		LoggerHandler.info("Target video saving path: " + newPath.toString());
		try {
			Files.move(originalPath, newPath, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return newPath.toString();
	}

	public void teardown(String videoName) {
		getPage().close();
		getBrowserContext().close();
//		videoFilePath = saveVideoAs(videoName);
	}

	public static void destroyGlobalResources() {
		getBrowser().close();
		getPlaywright().close();
	}

	public static void removeThreadLocalResources() {
		playwrightThreadLocal.remove();
		browserContexThreadLocal.remove();
		browserThreadLocal.remove();
		pageThreadLocal.remove();
	}
}
