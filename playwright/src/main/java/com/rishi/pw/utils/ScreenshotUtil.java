package com.rishi.pw.utils;

import java.nio.file.Paths;

import com.microsoft.playwright.Page;

public class ScreenshotUtil {

	public void takeScreenshot(Page page, String imagePath) {
		page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot.png")));
	}
}
