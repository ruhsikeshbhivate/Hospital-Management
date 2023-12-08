package com.HMS.PageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DoctorListPage {

	WebDriver driver;
	public DoctorListPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath = "//button[text()=\"Add Doctor\"]")
	WebElement AddDoctor;
	
	public void addDoctor()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", AddDoctor);
	}
	
	public  By FirstName = By.xpath("//input[@name=\"fName\"]");
	public  By LastName = By.xpath("//input[@name=\"lName\"]");

	public  By MobileNumber = By.xpath("//input[@name=\"mobileNo\"]");
	public  By RegistrationNumber = By.xpath("//input[@name=\"registrationNo\"]");
		
	@FindBy(xpath = "//button[text()=\"Submit\"]")
	WebElement submit;
	
	public void Submit()
	{
		submit.click();
	}
	@FindBy(xpath = "//input[@name=\"education\"]")
	WebElement Education;
	
	public void education(String EDUCATION)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollIntoView();", submit);
		Education.sendKeys(EDUCATION);
	}
	
	@FindBy(xpath = "//*[@id=\"mui-component-select-speciality\"]")
	WebElement Specialty;
	
	@FindBy(xpath = "(//li[@role=\"option\"])[1]")
	WebElement SpecialtyName;
	
	public void selectSpecialty() throws InterruptedException
	{
		Specialty.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", SpecialtyName);
	}
	
	@FindBy(xpath = "//input[@name=\"password\"]")
	WebElement Password;
	
	public void password(String pass)
	{
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
	
	@FindBy(xpath = "(//div[@role=\"button\"])[5]")
	WebElement Logout;
}
