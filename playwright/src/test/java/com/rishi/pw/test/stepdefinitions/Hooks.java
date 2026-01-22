package com.rishi.pw.test.stepdefinitions;

import com.rishi.pw.utils.DriverSetup;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

public class Hooks extends DriverSetup {

	@BeforeAll
	public static void initResources() {
		initGlobalResources();
	}

	@Before
	public void launchApp() {
		launchBrowser();
		startTracerUtils(browserContext);
	}

	@After
	public void cleanUpResources() {
		stopTracerUtils(browserContext, System.getProperty("user.dir") + "/tracer/tracer.zip");
		teardown("test-vid");
	}

	@AfterAll
	public static void destoryResources() {
		destroyGlobalResources();
	}
}
