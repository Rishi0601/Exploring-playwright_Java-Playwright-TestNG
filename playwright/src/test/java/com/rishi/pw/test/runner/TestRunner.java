package com.rishi.pw.test.runner;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rishi.pw.pages.Homepage;
import com.rishi.pw.pages.Loginpage;
import com.rishi.pw.utils.DriverSetup;
import com.rishi.pw.utils.PropertiesReader;

public class TestRunner extends DriverSetup {

	@BeforeMethod
	public void launchApp() {
		launchBrowser(PropertiesReader.getProperty().getProperty("browser"),
				PropertiesReader.getProperty().getProperty("url"));
		startTracerUtils(browserContext);
	}

	@Test
	public void TC01_negativeLogin() {
		Homepage homepage = new Homepage();
		Loginpage loginpage = new Loginpage();
		homepage.loginToFlipkart();
		loginpage.loginByMobileNumber("123456789");
	}

	@AfterMethod
	public void cleanUpResources() {
		stopTracerUtils(browserContext, System.getProperty("user.dir") + "/tracer/tracer.zip");
		teardown("test-vid");
	}
}
