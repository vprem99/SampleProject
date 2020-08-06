package com.cleartrip.flightTestRunner;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.cleartrip.flight.FlightSearchPage;
import com.cleartrip.utils.Base;
@Listeners()
public class FlightSearchTest extends Base {
	@Test
	public void flightSearchForm() {

		driver.get(prop.getProperty("url"));
		FlightSearchPage fp = new FlightSearchPage(driver);
		fp.doSearch("Ahmedabad", "Mumbai", testLog);
		try {
			new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//div[@class='row']//div[1]//div[1]//div[2]//div[4]//button[1]")));
		} catch (Exception E) {
			throw new AssertionError("Search Test Failed");
		}
	}
}