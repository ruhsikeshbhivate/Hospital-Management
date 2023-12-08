package com.HMS.PageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

	WebDriver driver;

	//constructor
	public loginPage(WebDriver driver)
	{
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name=\"email\"]")
	WebElement userName;

	@FindBy(xpath = "//input[@name=\"password\"]")
	WebElement passWord;

	@FindBy(xpath = "//button[text()=\"Login\"]")
	WebElement LoginButton;

	@FindBy(xpath = "//button[text()=\"Go to dashboard\"]")
	WebElement GotoDashboard;
	
	public void enterUsername(String USERNAME)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		userName.sendKeys(USERNAME);
	}

	public void enterPassword(String pass)
	{
		passWord.sendKeys(pass);
	}

	public void clickOnLoginButton()
	{
		LoginButton.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void goToDashboard()
	{
		GotoDashboard.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
}

