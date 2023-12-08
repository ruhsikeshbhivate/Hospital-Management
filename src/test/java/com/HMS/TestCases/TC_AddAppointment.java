package com.HMS.TestCases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Locale;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.HMS.PageObject.AppointmetsPage;
import com.HMS.PageObject.DashboardPage;
import com.github.javafaker.Faker;

public class TC_AddAppointment extends BaseClass{


	public String AppointPatientName;
	public boolean isLoginPerformed = false;

	@BeforeMethod
	public void addAppointment() throws InterruptedException, ParseException
	{
		if (!isLoginPerformed) {
			Tc_Login tlhms = new Tc_Login();
			tlhms.verifyLogin();
			isLoginPerformed = true;
		}

		DashboardPage dashboardPage = new DashboardPage(driver);
		dashboardPage.dashboard();
		dashboardPage.appointmnets();

		AppointmetsPage appointmetsPage = new AppointmetsPage(driver);
		appointmetsPage.bookAppointment();

		appointmetsPage.PatientName();
		appointmetsPage.mobileNumber();
		String firstname = appointmetsPage.FirstName.getAttribute("value");
		String lastname = appointmetsPage.LastName.getAttribute("value");
		AppointPatientName = firstname + " " + lastname;
		System.out.println("Patient Name : " + AppointPatientName);

		appointmetsPage.appointedDoctor();
		appointmetsPage.symptoms("Fever");
	}
	
	@Test(priority = 1)
	public void currentDateAppointment() throws ParseException, InterruptedException
	{
		AppointmetsPage appointmetsPage = new AppointmetsPage(driver);
		appointmetsPage.currentDate();
		appointmetsPage.appointmentTime();
		String time = appointmetsPage.AppointmentTime.getAttribute("value");
		Date DATE = new SimpleDateFormat("hh:mm").parse(time);
		String appointTime= new SimpleDateFormat("hh:mm aa").format(DATE);
		System.out.println("Appointment Time : " +appointTime);
		appointmetsPage.Submit();
		DashboardPage dashPage = new DashboardPage(driver);
		dashPage.dashboard();
		DashboardPage dashboardPage = new DashboardPage(driver);

		dashboardPage.todaysAppointment();
		appointmetsPage.switchToTableView();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		String patientName = appointmetsPage.PatientName1.getText();
		System.out.println("Patient name in appointment list : " + patientName);
		String appointmentDate = appointmetsPage.AppointmentDate1.getText();
		System.out.println("Appointment Date : " + appointmentDate);
		String appointmentTime = appointmetsPage.appointTime.getText();
		System.out.println("Patient Appointment Time : " + appointmentTime);

		if (patientName.contentEquals(AppointPatientName)==true && appointmentTime.equalsIgnoreCase(appointTime)==true) {

			System.out.println("Appointment is created successfully........");
		} else {
			System.out.println("Appointment is not created successfully........");

		}
		System.out.println("========================================================================");
		System.out.println();
		
		System.out.println("Appointment is created for upcoming date:");
	}

	@Test(priority = 2)
	public void bookUpcominAppointment() throws InterruptedException, ParseException 
	{
		AppointmetsPage appointmentsPage = new AppointmetsPage(driver);
		appointmentsPage.upcomingDate();

		appointmentsPage.appointmentTime();
		String time = appointmentsPage.AppointmentTime.getAttribute("value");
		Date DATE = new SimpleDateFormat("hh:mm").parse(time);
		String appointTime= new SimpleDateFormat("hh:mm aa").format(DATE);
		System.out.println("Appointment Time : " +appointTime);

		appointmentsPage.Submit();
		DashboardPage dashPage = new DashboardPage(driver);
		dashPage.dashboard();
		DashboardPage dashboardPage = new DashboardPage(driver);

		dashboardPage.todaysAppointment();
		appointmentsPage.upcoming();
		String patientName = appointmentsPage.PatientName1.getText();
		System.out.println("Patient name in appointment list : " + patientName);

		String appointmentDate = appointmentsPage.AppointmentDate1.getText();
		System.out.println("Appointment Date : " + appointmentDate);

		String appointmentTime = appointmentsPage.appointTime.getText();
		System.out.println("Patient Appointment Time : " + appointmentTime);

		if (patientName.contentEquals(AppointPatientName)==true && appointmentTime.equalsIgnoreCase(appointTime)==true) {

			System.out.println("Appointment is created successfully........");
		} else {
			System.out.println("Appointment is not created successfully........");

		}
		System.out.println("========================================================================");
		System.out.println();

	}

	/*	@Test(priority = 2)
	public void attendAppointment()
	{
		DashboardPage dashboardPage = new DashboardPage(driver);
		dashboardPage.logout();
		loginPage LoginPage = new loginPage(driver);
		LoginPage.enterUsername("6837889333");
		LoginPage.enterPassword("12345");
		LoginPage.clickOnLoginButton();
		LoginPage.goToDashboard();

		dashboardPage.attend();
	}*/
}
