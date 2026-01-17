package com.rishi.pw.runner;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rishi.pw.utils.DriverSetup;
import com.rishi.pw.utils.PropertiesReader;

public class TestRunner extends DriverSetup {

	@BeforeMethod
	public void launchApp() {
		launchBrowser(PropertiesReader.getProperty().getProperty("browser"),
				PropertiesReader.getProperty().getProperty("url"));
	}

	@Test
	public void test01() {
		assertTrue(page.title().equalsIgnoreCase("google"));
	}

	@AfterMethod
	public void teardown() {
		page.close();
		browser.close();
	}
}
