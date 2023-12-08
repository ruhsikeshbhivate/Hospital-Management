package com.HMS.TestCases;

import java.util.Locale;

import org.testng.annotations.Test;

import com.HMS.PageObject.DashboardPage;
import com.HMS.PageObject.DoctorListPage;
import com.HMS.PageObject.PatientListPage;
import com.HMS.PageObject.loginPage;
import com.github.javafaker.Faker;

public class TC_CreatePatient extends BaseClass{

	Faker faker = new Faker(new Locale("en-IND"));
	@Test
	public void createPatient() throws InterruptedException
	{
		loginPage LoginPage = new loginPage(driver);
		LoginPage.enterUsername("rushi.bhivate@anveshak.com");
		LoginPage.enterPassword("12345");
		LoginPage.clickOnLoginButton();
		LoginPage.goToDashboard();
		
		DashboardPage dashboardPage = new DashboardPage(driver);
		dashboardPage.dashboard();
		dashboardPage.users();
		dashboardPage.patient();
		
		PatientListPage patientListPage = new PatientListPage(driver);
		patientListPage.addPatient();
		driver.findElement(patientListPage.FirstName).sendKeys(faker.name().firstName());
		driver.findElement(patientListPage.LastName).sendKeys(faker.name().lastName());
		driver.findElement(patientListPage.MobileNumber).sendKeys(faker.phoneNumber().phoneNumber());
		
		patientListPage.password("12345");
		patientListPage.confirmPassword("12345");
		patientListPage.Submit();
		patientListPage.ok();
	}
}
