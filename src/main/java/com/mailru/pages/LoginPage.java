package com.mailru.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.mailru.data.UserData;
import com.mailru.utils.ConfigProperties;

public class LoginPage extends Page {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (id = "mailbox__login")
	public WebElement usernameField;
	
	@FindBy (id = "mailbox__password")
	public WebElement passField;
	
	@FindBy (id = "mailbox__auth__button")
	public WebElement loginButton;
	
	@FindBy (xpath = "//span[@id='portal-headline_login']/a")
	public WebElement loginLink;
	
	public void loginAs (UserData user){ //void instead void HomePage
		type(usernameField, user.name);
		type(passField, user.pass);
		loginButton.click();
		//return PageFactory.initElements(driver, HomePage.class);
	}

	@Override
	public void open() {
		driver.get(ConfigProperties.getProperty("login.url"));	
	}
	
	public boolean isLoggedOut() {
		return isElementPresent(loginLink);
	}
}
