package com.cleartrip.utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class HelperFunctions {
	static WebDriver driver;

	public static WebDriver setBrowser(String browserName) {
		browserName = browserName.toLowerCase();

		switch (browserName) {
		case "chrome": {
			System.setProperty("webdriver.chrome.driver",
					".\\src\\test\\resources\\drivers\\chromedriver.exe");
			
			ChromeOptions cp=new ChromeOptions();;
			cp.addArguments("--disable-notifications");
			driver = new ChromeDriver(cp); // Starts Chrome Browser
			driver.manage().window().maximize();
			break;
		}
		case "firefox": {
			System.setProperty("webdriver.gecko.driver",
					".\\src\\test\\resources\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver(); // Starts Chrome Browser
			break;
		}
		default:
			System.out.println("Invalid Browser");
		}
		return driver;
	}

	public static String getSnap(String fileNameWithLocation) {
		TakesScreenshot tc = (TakesScreenshot) driver;
		// It will take ScreenShot & store in Java Buffer memory
		File scFile = tc.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(scFile, new File(fileNameWithLocation));
			return fileNameWithLocation;
		} catch (IOException e) {
			System.out.println("Error with ScreenShot");
			return null;
		}
	}
}