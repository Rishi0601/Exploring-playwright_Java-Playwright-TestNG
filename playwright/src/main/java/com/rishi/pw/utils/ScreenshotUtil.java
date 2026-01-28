package com.rishi.pw.utils;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Page;

public class ScreenshotUtil {

	public static String takeScreenshot(Page page, String imageName) {
		Path screenshotPath = Paths
				.get("screenshots/" + imageName + "_" + HelperMethods.getTimestamp("dd-MM-yyyy-HH-mm-SS") + ".png");
		page.screenshot(new Page.ScreenshotOptions().setPath(screenshotPath));
		return screenshotPath.toString();
	}
}
