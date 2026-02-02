package com.rishi.pw.test.runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.rishi.pw.utils.ExtentReportManager;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/", glue = "com.rishi.pw.test.stepdefinitions", plugin = {
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, dryRun = false)
public class Runner extends AbstractTestNGCucumberTests {

	@BeforeClass
	public void initReport() {
		ExtentReportManager.initReport();
	}

	@AfterClass
	public void flushReport() {
		ExtentReportManager.flushReport();
	}
}