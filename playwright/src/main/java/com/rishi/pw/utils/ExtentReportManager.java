package com.rishi.pw.utils;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager extends AppContext {

	public static ExtentReports extentReports;

	public static ExtentReports initReport() {
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "/target/reports/SummaryReport_"
						+ HelperMethods.getTimestamp("dd-MM-yyyy-HH-mm-ss") + "/TestReports.html");
		extentSparkReporter.config().setReportName("FlipKart Automation Test Suite");
		extentSparkReporter.config().setTheme(Theme.DARK);
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);

		extentReports.setSystemInfo("OS", PropertiesReader.getProperty().getProperty("windows"));
		extentReports.setSystemInfo("JAVA_VER", PropertiesReader.getProperty().getProperty("java-version"));
		extentReports.setSystemInfo("PLAYWRIGHT_VER", PropertiesReader.getProperty().getProperty("playwright-version"));
		extentReports.setSystemInfo("APP_ENV", PropertiesReader.getProperty().getProperty("app-env"));
		extentReports.setSystemInfo("EXECUTION_VIA", PropertiesReader.getProperty().getProperty("execution-mode"));
		extentReports.setSystemInfo("USERNAME", PropertiesReader.getProperty().getProperty("username"));
		extentReports.setAnalysisStrategy(AnalysisStrategy.TEST);
		
		return extentReports;
	}

	public static void createTest(String testName) {
		setTest(extentReports.createTest(testName));
	}

	public static void passLogWithSS(String description, String ssName) {
		getTest().log(Status.PASS, description, MediaEntityBuilder
				.createScreenCaptureFromPath(ScreenshotUtil.getScreenshotPath(ssName).toString()).build());
	}

	public static void failLogWithSS(String description, String ssName) {
		getTest().log(Status.FAIL, description, MediaEntityBuilder
				.createScreenCaptureFromPath(ScreenshotUtil.getScreenshotPath(ssName).toString()).build());
	}

	public static void flushReport() {
		extentReports.flush();
	}
}
