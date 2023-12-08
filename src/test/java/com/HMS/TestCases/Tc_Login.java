package com.HMS.TestCases;

import org.testng.annotations.Test;

import com.HMS.PageObject.loginPage;

public class Tc_Login extends BaseClass{
	
	@Test
	public void verifyLogin()
	{
		loginPage LoginPage = new loginPage(driver);
		LoginPage.enterUsername("rushi.bhivate@anveshak.com");
		LoginPage.enterPassword("12345");
		LoginPage.clickOnLoginButton();
		LoginPage.goToDashboard();
	}

}
