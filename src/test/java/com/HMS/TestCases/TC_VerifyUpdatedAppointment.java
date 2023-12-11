package com.HMS.TestCases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import com.HMS.PageObject.AppointmetsPage;
import com.HMS.PageObject.DashboardPage;

public class TC_VerifyUpdatedAppointment extends BaseClass{

	public String AppointPatientName;
	public boolean isLoginPerformed = false;
	@Test
	public void verifyUpdatedAppointment() throws InterruptedException, ParseException
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
		appointmetsPage.switchToTableView();
		appointmetsPage.upcoming();

		try {
			String AppointmentDate = driver.findElement(By.xpath("//table//tbody//tr[1]//td[4]")).getText();
			System.out.println("Appointment date before update: " +AppointmentDate);

			String AppointmentTime = driver.findElement(By.xpath("//table//tbody//tr[1]//td[5]")).getText();
			System.out.println("Appointment time before update: " +AppointmentTime);
			appointmetsPage.editAppointment();

		} catch (NoSuchElementException e) {

			appointmetsPage.todays();

			try {
				appointmetsPage.editTodaysAppointment();

			} catch (NoSuchElementException e2) {

				TC_AddAppointment AddAppointment = new TC_AddAppointment();
				AddAppointment.addAppointment();
				AddAppointment.bookUpcominAppointment();
				dashboardPage.appointmnets();

				try {
					appointmetsPage.editTodaysAppointment();
				} catch (NoSuchElementException e3) {
					appointmetsPage.upcoming();
					appointmetsPage.editAppointment();
				}
			}
		}


		/*
		Date DATE1 = new SimpleDateFormat("yyyy-dd-mm").parse(AppointmentDate);
		String appointDate= new SimpleDateFormat("mm-dd-yyyy").format(DATE1);

		Date DATE2 = new SimpleDateFormat("yyyy-dd-mm").parse(appointDate);

		String appointDate1= new SimpleDateFormat("mmm-dd-yyyy").format(DATE2);
		System.out.println(appointDate);
		System.out.println(appointDate1);*/

		appointmetsPage.appointmentTime();
		String time = appointmetsPage.AppointmentTime.getAttribute("value");
		Date DATE = new SimpleDateFormat("hh:mm").parse(time);
		String appointTime= new SimpleDateFormat("hh:mm aa").format(DATE);
		System.out.println("Appointment Time : " +appointTime);
		appointmetsPage.update();

		appointmetsPage.upcoming();
		String PatientNAME = driver.findElement(By.xpath("//table//tbody//tr[1]//td[2]")).getText();
		System.out.println("Updated Appointment Patient Name: " +PatientNAME);

		String AppointmentDate2 = driver.findElement(By.xpath("//table//tbody//tr[1]//td[4]")).getText();
		System.out.println("Appointment date After update: " +AppointmentDate2);
		System.out.println("Appointment time after update: "+appointTime);

	}

}
