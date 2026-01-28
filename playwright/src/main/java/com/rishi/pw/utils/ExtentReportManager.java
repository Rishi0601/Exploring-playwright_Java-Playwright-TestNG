package com.rishi.pw.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager extends DriverSetup {

	public static ExtentReports extentReports;
	public static ExtentTest test;

	public static ExtentReports initReport() {
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")
				+ "/reports/SummaryReport_" + HelperMethods.getTimestamp("dd-MM-yyyy-HH-mm-ss") + "/TestReports.html");
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		return extentReports;
	}

	public static void createTest(String testName) {
		test = extentReports.createTest(testName);
	}

	public void passLogWithSS(String description, String ssName) {
		test.log(Status.PASS, description,
				MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotUtil.takeScreenshot(page, ssName)).build());
	}

	public void failLogWithSS(String description, String ssName) {
		test.log(Status.FAIL, description,
				MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotUtil.takeScreenshot(page, ssName)).build());
	}

	public static void flushReport() {
		extentReports.flush();
	}
}
