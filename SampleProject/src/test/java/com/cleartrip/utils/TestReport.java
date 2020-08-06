package com.cleartrip.utils;

import java.io.IOException;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestReport extends Base implements ITestListener {

	public void onTestStart(ITestResult result) {
		testLog = extentReporter.createTest(result.getName());
		testLog.info(result.getName() + " Started");
	}

	public void onTestSuccess(ITestResult result) {
		testLog.pass(result.getName() + " Successful");
		try {
			testLog.info("PFA : Final Snapshot Below ");
			String newDate = new Date().toString().replaceAll(" ", "_").replaceAll(":", "_");
			String path = HelperFunctions.getSnap("Login" + newDate + ".png");
			testLog.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestFailure(ITestResult result) {
		testLog.fail(result.getName() + " Unsuccessful");
		try {
			testLog.info("PFA : Final Snapshot Below ");
			String newDate = new Date().toString().replaceAll(" ", "_").replaceAll(":", "_");
			String path = HelperFunctions.getSnap("Login" + newDate + ".png");
			testLog.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onFinish(ITestContext context) {
		testLog.info("Writing Report");
		extentReporter.flush();
	}

	public void onTestSkipped(ITestResult result) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onStart(ITestContext context) {
	}

}