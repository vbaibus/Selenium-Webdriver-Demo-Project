package com.mailru.test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.mailru.pages.HomePage;
import com.mailru.pages.LoginPage;

public class LoginTest extends BasicTest {
	
	private LoginPage loginPage = PageFactory.initElements(getWebDriver(), 
			LoginPage.class);
	private HomePage homePage = PageFactory.initElements(driver, 
			HomePage.class);
	
	@Test
	public void testLoginLogout() throws Exception {
		loginPage.open();
		loginPage.loginAs(user);
		assertTrue(homePage.isLoggedIn());
		homePage.logout();
		assertTrue(loginPage.isLoggedOut());
	}

}
