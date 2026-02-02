package com.rishi.pw.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Page;

public class ScreenshotUtil extends DriverSetup {

	public static Path getScreenshotPath(String imageName) {
		return Paths.get(System.getProperty("user.dir") + "/target/screenshots/" + imageName + "_"
				+ HelperMethods.getTimestamp("dd-MM-yyyy-HH-mm-SS") + ".png");
	}

	public static byte[] takeScreenShots(String imgName) {
		Path screenshotPath = getScreenshotPath(imgName);
		byte[] array = page.screenshot(new Page.ScreenshotOptions().setFullPage(false).setPath(screenshotPath));
		try {
			Files.write(Paths.get(screenshotPath.toUri()), array);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return array;
	}
}
