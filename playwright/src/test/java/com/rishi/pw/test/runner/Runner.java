package com.rishi.pw.test.runner;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.rishi.pw.utils.ExtentReportManager;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/", glue = "com.rishi.pw.test.stepdefinitions", plugin = {
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, dryRun = false)
public class Runner extends AbstractTestNGCucumberTests {

	@BeforeSuite
	public void initReport() {
		ExtentReportManager.initReport();
	}

	@AfterSuite
	public void flushReport() {
		ExtentReportManager.flushReport();
	}

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
