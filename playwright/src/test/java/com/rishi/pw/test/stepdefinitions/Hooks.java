package com.rishi.pw.test.stepdefinitions;

import com.rishi.pw.utils.DriverSetup;
import com.rishi.pw.utils.PropertiesReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends DriverSetup {

	@Before
	public void launchApp() {
		launchBrowser(PropertiesReader.getProperty().getProperty("browser"));
		startTracerUtils(browserContext);
	}
	
	@After
	public void cleanUpResources() {
		stopTracerUtils(browserContext, System.getProperty("user.dir") + "/tracer/tracer.zip");
		teardown("test-vid");
	}
}
