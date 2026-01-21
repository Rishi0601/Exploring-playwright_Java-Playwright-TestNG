package com.rishi.pw.test.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/login.feature", glue = "com.rishi.pw.test.stepdefinitions", plugin = {
		"pretty", "html:target/cucumber-reports.html" }, dryRun = false)
public class Runner extends AbstractTestNGCucumberTests {
}