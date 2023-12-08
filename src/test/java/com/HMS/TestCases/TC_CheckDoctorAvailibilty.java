package com.HMS.TestCases;

import org.testng.annotations.Test;

import com.HMS.PageObject.DashboardPage;

public class TC_CheckDoctorAvailibilty extends BaseClass{

	@Test
	public void checkDoctorAvailibilty() throws InterruptedException
	{
		Tc_Login login = new Tc_Login();
		login.verifyLogin();
		
		DashboardPage dashboardPage = new DashboardPage(driver);
		dashboardPage.viewDoctorDetails();
		dashboardPage.doctorAvailibilty();
    }
}
