package com.mailru.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Page {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[contains(text(),'выход')]")
	public WebElement logoutLink;

	@Override
	public void open() {
	}

	public boolean isLoggedIn() {
		return isElementPresent(logoutLink);
	}

	public void logout() {
		logoutLink.click();
	}
}
