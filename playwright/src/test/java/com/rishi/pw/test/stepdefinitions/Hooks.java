package com.rishi.pw.test.stepdefinitions;

import com.rishi.pw.utils.DriverSetup;
import com.rishi.pw.utils.ExtentReportManager;
import com.rishi.pw.utils.PropertiesReader;
import com.rishi.pw.utils.ScreenshotUtil;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;

public class Hooks extends DriverSetup {

	@Before
	public void launchApp(Scenario scenario) {
		initGlobalResources();
		launchBrowser();
		ExtentReportManager.createTest(scenario.getName());
		startTracerUtils();
	}

	@Given("the user initialises test dependencies and launches the Flipkart application")
	public void the_user_initialises_test_dependencies_and_launches_the_flipkart_application() {
		navigateToUrl(PropertiesReader.getProperty().getProperty("url"));
	}

	@After
	public void cleanUpResources(Scenario scenario) {
		String scenarioName = scenario.getName();
		String updatedScenarioName = scenarioName.replaceAll(" ", "_");
		if (scenario.isFailed()) {
			ExtentReportManager.failLogWithSS(scenarioName, updatedScenarioName);
			scenario.attach(ScreenshotUtil.takeScreenShots(updatedScenarioName), "image/png", "Failure Screenshots");
		} else {
			ExtentReportManager.passLogWithSS(scenarioName, updatedScenarioName);
			scenario.attach(ScreenshotUtil.takeScreenShots(updatedScenarioName), "image/png", "Pass Screenshots");
		}
		stopTracerUtils(System.getProperty("user.dir") + "/tracer/tracer.zip");
		teardown("test-vid");
		destroyGlobalResources();
		removeThreadLocalResources();
	}
}
