package com.cleartrip.utils;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class BasePage {
	public WebDriver driver;
	public Properties prop;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		prop = PropertyReader.getInstance();
	}
}
