package com.HMS.PageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

	WebDriver driver;
	public DashboardPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=\"Dashboard\"]")
	WebElement Dashboard ;

	public void dashboard()
	{
		Dashboard.click();
	}

	@FindBy(xpath = "//span[text()=\"Users\"]")
	WebElement Users;

	public void users()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Users);
	}

	@FindBy(xpath = "//span[text()=\"Doctor\"]")
	WebElement Doctors;

	public void doctor()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Doctors);
	}

	@FindBy(xpath = "//span[text()=\"Patient\"]")
	WebElement Patient;

	public void patient()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Patient);
	}

	@FindBy(xpath = "//span[text()=\"Appointments\"]")
	WebElement Appointments;

	public void appointmnets()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Appointments);
	}

	@FindBy(xpath = "//table//tbody//tr[1]//td[6]//button[1]")
	WebElement ViewDoctorDetails;

	public void viewDoctorDetails() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		ViewDoctorDetails.click();

		//JavascriptExecutor executor = (JavascriptExecutor)driver;
		//executor.executeScript("arguments[0].click();", ViewDoctorDetails);
	}

	@FindBy(xpath = "//span[text()=\"Logout\"]")
	WebElement Logout;

	public void logout()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Logout);
	}

	@FindBy(xpath = "//table//tbody//tr[1]//td[6]//button[2]")
	WebElement Attend;

	@FindBy(xpath = "//table//tbody//tr[1]//td[2]")
	WebElement Attendpatient;

	public void attend()
	{
		String PatientName = Attendpatient.getText();
		System.out.println("Appointments Attended Patient Name : " + PatientName);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Attend);
		
	}
	
	@FindBy(xpath = "//p[text()=\"Today's Appointment\"]")
	WebElement TodaysAppointment;
	
	public void todaysAppointment()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		TodaysAppointment.click();
	}
	
	
	public void doctorAvailibilty() throws InterruptedException
	{
		Thread.sleep(4000);
		String sunday = driver.findElement(By.xpath("//div[text()=\"Sunday\"]")).getText();
		WebElement monday = driver.findElement(By.xpath("//div[text()=\"Sunday\"]"));
		WebElement tuesday = driver.findElement(By.xpath("//div[text()=\"Sunday\"]"));
		WebElement wednesday = driver.findElement(By.xpath("//div[text()=\"Sunday\"]"));
		WebElement thursday = driver.findElement(By.xpath("//div[text()=\"Sunday\"]"));
		WebElement friday = driver.findElement(By.xpath("//div[text()=\"Sunday\"]"));
		WebElement saturday = driver.findElement(By.xpath("//div[text()=\"Sunday\"]"));
		//	String SUNDAY = sunday.getText();
		//System.out.println(SUNDAY);
		String MONDAY = monday.getText();
		String TUESDAY = tuesday.getText();
		String WEDNESDAY = wednesday.getText();
		String THURDAY = thursday.getText();
		String FRIDAY = friday.getText();
		String SATURDAY = saturday.getText();
		String day = "Sunday";

		if (sunday.contains(day)) {

			System.out.println("Appointment Day       Avaibility Time");
			String AvailableTime = driver.findElement(By.xpath("(//span[@class=\"black-common-subheading\"])[1]")).getText();
			System.out.println("Sunday                "+ AvailableTime);
		}

		else if (MONDAY.contentEquals(day)) {
			System.out.println("Appointment Day       Avaibility Time");
			String AvailableTime = driver.findElement(By.xpath("(//span[@class=\"black-common-subheading\"])[2]")).getText();
			System.out.println("Monday                "+ AvailableTime);
		}

		else if (TUESDAY.contentEquals(day)) {
			System.out.println("Appointment Day       Avaibility Time");
			String AvailableTime = driver.findElement(By.xpath("(//span[@class=\"black-common-subheading\"])[3]")).getText();
			System.out.println("Tuesday               "+ AvailableTime);
		}

		else if (WEDNESDAY.contentEquals(day)) {
			System.out.println("Appointment Day       Avaibility Time");
			String AvailableTime = driver.findElement(By.xpath("(//span[@class=\"black-common-subheading\"])[4]")).getText();
			System.out.println("Wednesday             "+ AvailableTime);
		}

		else if (THURDAY.contentEquals(day)) {
			System.out.println("Appointment Day       Avaibility Time");
			String AvailableTime = driver.findElement(By.xpath("(//span[@class=\"black-common-subheading\"])[5]")).getText();
			System.out.println("Thursday              "+ AvailableTime);
		}

		else if (FRIDAY.contentEquals(day)) {
			System.out.println("Appointment Day       Avaibility Time");
			String AvailableTime = driver.findElement(By.xpath("(//span[@class=\"black-common-subheading\"])[6]")).getText();
			System.out.println("Friday                "+ AvailableTime);
		}

		else if (SATURDAY.contentEquals(day)) {
			System.out.println("Appointment Day       Avaibility Time");
			String AvailableTime = driver.findElement(By.xpath("(//span[@class=\"black-common-subheading\"])[7]")).getText();
			System.out.println("Saturday              "+ AvailableTime);
		}
	}
}
