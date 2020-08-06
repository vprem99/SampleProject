package com.cleartrip.utils;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


@Listeners({ com.cleartrip.utils.TestReport.class })
public class Base {
	public static WebDriver driver;
	public Properties prop;
	protected static ExtentTest testLog;
	protected static ExtentReports extentReporter;

	@BeforeTest // Pre-Conditions
	public void beforeTest() throws Exception {
		prop = PropertyReader.getInstance();
		extentReporter = new ExtentReports();
		extentReporter.attachReporter(new ExtentHtmlReporter("ClearTripReport0.html"));

		driver = HelperFunctions.setBrowser(prop.getProperty("browser"));
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("implicit.wait")),
				TimeUnit.SECONDS);
	}

	@AfterTest // Post- COndition
	public void afterTest() {
		// driver.quit();
	}

	/*
	 * @AfterMethod public void afterMethod(ITestResult result) { if
	 * (result.getStatus() == ITestResult.FAILURE) { Date date = new Date(); String
	 * newDate = date.toString().replaceAll(" ", "_").replaceAll(":", "_");
	 * HelperFunctions.getSnap("Login" + newDate + ".png"); } }
	 */
}