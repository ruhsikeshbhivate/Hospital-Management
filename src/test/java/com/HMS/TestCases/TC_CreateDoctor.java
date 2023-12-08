package com.HMS.TestCases;

import java.util.Locale;

import org.testng.annotations.Test;

import com.HMS.PageObject.DashboardPage;
import com.HMS.PageObject.DoctorListPage;
import com.HMS.PageObject.loginPage;
import com.github.javafaker.Faker;

public class TC_CreateDoctor extends BaseClass{
	
	Faker faker = new Faker(new Locale("en-IND"));
	@Test
	public void createDoctor() throws InterruptedException
	{
		loginPage LoginPage = new loginPage(driver);
		LoginPage.enterUsername("rushi.bhivate@anveshak.com");
		LoginPage.enterPassword("12345");
		LoginPage.clickOnLoginButton();
		LoginPage.goToDashboard();
		
		DashboardPage dashboardPage = new DashboardPage(driver);
		dashboardPage.dashboard();
		dashboardPage.users();
		dashboardPage.doctor();
		
		DoctorListPage doctorListPage = new DoctorListPage(driver);
		doctorListPage.addDoctor();
		driver.findElement(doctorListPage.FirstName).sendKeys(faker.name().firstName());
		driver.findElement(doctorListPage.LastName).sendKeys(faker.name().lastName());
		driver.findElement(doctorListPage.MobileNumber).sendKeys(faker.phoneNumber().phoneNumber());
		doctorListPage.education("BHMS");
		
		driver.findElement(doctorListPage.RegistrationNumber).sendKeys(faker.phoneNumber().cellPhone());
		doctorListPage.selectSpecialty();
		doctorListPage.password("12345");
		doctorListPage.confirmPassword("12345");
		doctorListPage.Submit();
		doctorListPage.ok();
		
	}
}
