package com.HMS.PageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientListPage {

	WebDriver driver;
	
	public PatientListPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[text()=\"Add Patient\"]")
	WebElement AddPatient;
	
	public void addPatient()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", AddPatient);
	}
	
	public  By FirstName = By.xpath("//input[@name=\"fName\"]");
	public  By LastName = By.xpath("//input[@name=\"lName\"]");
	public  By MobileNumber = By.xpath("//input[@name=\"mobileNo\"]");
		
	@FindBy(xpath = "//button[text()=\"Submit\"]")
	WebElement submit;
	
	public void Submit()
	{
		submit.click();
	}
	
	@FindBy(xpath = "//input[@name=\"password\"]")
	WebElement Password;
	
	public void password(String pass)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollIntoView();", submit);
		Password.sendKeys(pass);
	}
	
	@FindBy(xpath = "//input[@name=\"confirmPassword\"]")
	WebElement ConfirmPassword;
	
	public void confirmPassword(String confirmPass)
	{
		ConfirmPassword.sendKeys(confirmPass);
	}
	
	@FindBy(xpath = "//button[text()=\"Ok\"]")
	WebElement OK;
	
	public void ok()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		OK.click();
	}
	
}
