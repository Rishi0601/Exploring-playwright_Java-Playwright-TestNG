package com.rishi.pw.test.stepdefinitions;

import com.rishi.pw.utils.DriverSetup;
import com.rishi.pw.utils.ExtentReportManager;
import com.rishi.pw.utils.PropertiesReader;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;

public class Hooks extends DriverSetup {

	@BeforeAll
	public static void initResources() {
		initGlobalResources();
		ExtentReportManager.initReport();
	}

	@Before
	public void launchApp() {
		launchBrowser();
		startTracerUtils();
	}

	@Given("the user initialises test dependencies and launches the Flipkart application")
	public void the_user_initialises_test_dependencies_and_launches_the_flipkart_application() {
		ExtentReportManager.createTest("test");
		navigateToUrl(PropertiesReader.getProperty().getProperty("url"));
	}

	@After
	public void cleanUpResources() {
		stopTracerUtils(System.getProperty("user.dir") + "/tracer/tracer.zip");
		teardown("test-vid");
		ExtentReportManager.flushReport();
	}

	@AfterAll
	public static void destoryResources() {
		destroyGlobalResources();
	}
}
