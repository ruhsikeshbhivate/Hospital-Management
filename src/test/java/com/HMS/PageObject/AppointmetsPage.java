package com.HMS.PageObject;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.bouncycastle.oer.its.ieee1609dot2.basetypes.PublicVerificationKey;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.javafaker.Faker;

public class AppointmetsPage {

	Faker faker = new Faker(new Locale("en-IND"));
	WebDriver driver;
	
	public AppointmetsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
		
	@FindBy(xpath = "//input[@name=\"fName\"]")
	public WebElement FirstName;
	
	@FindBy(xpath = "//input[@name=\"lName\"]")
	public WebElement LastName;
	
	public void PatientName()
	{
		FirstName.sendKeys(faker.name().firstName());
	//	String firstNAME = FirstName.getAttribute("value");
		
	LastName.sendKeys(faker.name().lastName());
	//	String lastNAME = LastName.getAttribute("value");
		
	//	String FullName = firstNAME + " " + lastNAME;
	//	System.out.println("Patient Name : " +FullName);
	}
	
	@FindBy(xpath = "//input[@name=\"mobileNo\"]")
	WebElement MobileNumebr;
	
	public void mobileNumber()
	{
		MobileNumebr.sendKeys(faker.phoneNumber().phoneNumber());
	}
	
	@FindBy(xpath = "//button[text()=\"Book Appointment\"]")
	WebElement BookAppointment;
	
	public void bookAppointment()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", BookAppointment);
	}
	
	@FindBy(xpath = "//input[@name=\"appointment_date\"]")
	WebElement AppointmentDate;
	
	public void currentDate()
	{
		LocalDate currentDate = LocalDate.now();
		//LocalDate nextDay = currentDate.
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String formattedNextDay = currentDate.format(formatter);
		AppointmentDate.sendKeys(formattedNextDay);
	}
	
	public void upcomingDate()
	{
		LocalDate currentDate = LocalDate.now();
		LocalDate nextDay = currentDate.plusDays(1);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String formattedNextDay = nextDay.format(formatter);
		AppointmentDate.sendKeys(formattedNextDay);
	}
	
	@FindBy(xpath = "//input[@name=\"appointment_time\"]")
	public WebElement AppointmentTime;
	
	public void appointmentTime()
	{
		LocalTime currenttime = LocalTime.now();
		LocalTime nexthour = currenttime.plusMinutes(5);
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm");
		String formattednext5min = nexthour.format(formatter2);
		AppointmentTime.sendKeys(formattednext5min);
	}
	
	@FindBy(xpath = "//input[@name=\"fName\"]")
	WebElement PatientName;
	
	public void patientFirstName(String name)
	{
		PatientName.sendKeys(name);
	}
	
	@FindBy(xpath = "//input[@name=\"lName\"]")
	WebElement PatientLastName;
	
	public void patientLastname(String LName)
	{
		PatientLastName.sendKeys(LName);
	}
	
	@FindBy(xpath = "//input[@id=\"doctor-dropdown\"]")
	WebElement AppointedDoctor;
	
	@FindBy(xpath = "//li[text()=\"Rushikesh Bhivate\"]")
	WebElement doctorName;
	
	public void appointedDoctor()
	{
		AppointedDoctor.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		doctorName.click();
	}
	
	@FindBy(xpath = "//input[@id=\"symptoms-auto-complte\"]")
	WebElement Symptoms;
	
	public void symptoms(String text) throws InterruptedException
	{
		Symptoms.sendKeys(text);
		Thread.sleep(1000);
		Actions actions  = new Actions(driver);
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	}
	
	@FindBy(xpath = "//button[text()=\"Submit\"]")
	WebElement submit;
	
	@FindBy(xpath = "//button[text()=\"Ok\"]")
	WebElement OK;
	public void Submit() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", submit);
		OK.click();
		Thread.sleep(3000);
	}
	
	@FindBy(xpath = "//table//tbody//tr[1]//td[2]")
	WebElement AppointmentPatientName;
	
	public void appointmentPatientName() throws InterruptedException
	{
		String patientName = AppointmentPatientName.getText();
		System.out.println("Book Appointment Patient Name : " +patientName);
		Thread.sleep(2000);
	}
	
	@FindBy(xpath = "//button[@id=\"appointment-tab-1\"]")
	WebElement Upcoming;
	
	public void upcoming()
	{
		Upcoming.click();
	}
	
	@FindBy(xpath = "//table//tbody//tr[1]//td[7]//button[2]")
	WebElement EditAppointment;
	
	@FindBy(xpath = "//table//tbody//tr[1]//td[2]")
	public WebElement PatientName1;
	
	@FindBy(xpath = "//table//tbody//tr[1]//td[4]")
	public WebElement AppointmentDate1;
	
	public void editAppointment() throws InterruptedException
	{
		String name = PatientName1.getText();
		System.out.println("Patient Name : " +name);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		EditAppointment.click(); 
		Thread.sleep(3000);
	}
	
	@FindBy(xpath = "//button[@id=\"appointment-tab-0\"]")
	WebElement Todays;
	
	public void todays()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Todays.click();
	}
	
	public void editappointmentDate(String date) throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		AppointmentDate.clear();
		Thread.sleep(1000);
		AppointmentDate.sendKeys(date);
	}
	
	public void editappointmentTime(String time) throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		AppointmentTime.clear();
		Thread.sleep(1000);
		AppointmentTime.sendKeys(time);
	}
	@FindBy(xpath = "//table//tbody//tr[1]//td[7]//button[3]")
	WebElement editTodaysAppointment;
	
	public void editTodaysAppointment()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		editTodaysAppointment.click();
	}
	
	@FindBy(xpath = "//button[text()=\"Update\"]")
	WebElement Update;
	
	public void update() throws InterruptedException
	{
		Thread.sleep(2000);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", Update);
		OK.click();
		Thread.sleep(3000);
	}
	
	@FindBy(xpath = "//table//tbody//tr[1]//td[5]")
	public WebElement appointTime;
	
	@FindBy(xpath = "//input[@type=\"checkbox\"]")
	WebElement SwitchToTableView;
	
	public void switchToTableView()
	{		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		SwitchToTableView.click();
	}
}
