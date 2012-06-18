package com.mailru.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

import com.mailru.data.UserData;
import com.mailru.utils.ConfigProperties;

public class BasicTest {

	protected static WebDriver driver;

	public UserData user = new UserData("aleks.selenium.aleksovich",
			"12345qwert");

	protected WebDriver getWebDriver() {
		if (driver == null) {
			driver = new FirefoxDriver();
			driver.manage()
					.timeouts().implicitlyWait(
							Long.parseLong(ConfigProperties
									.getProperty("imp.wait")), 
										TimeUnit.SECONDS);
		}
		return driver;
	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
	}
}
