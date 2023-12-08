package com.HMS.TestCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

import com.HMS.PageObject.DashboardPage;
import com.HMS.Utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	ReadConfig readConfig = new ReadConfig();
	String url = readConfig.getBaseUrl();
	String browser = readConfig.getBrowser();

	public static WebDriver driver;
	public static Logger logger;

	@BeforeClass
	public void setUp() {

		String browser = "CHROME";

		switch (browser.toUpperCase())
		{

		case "CHROME":
			
			ChromeOptions option = new ChromeOptions();
            option.addArguments("--remote-allow-origins=*");

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(option);
			break;

		case "FIREFOX":

			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();
			break;

		case "MSEDGE":

			WebDriverManager.chromedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			break;
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		logger = LogManager.getLogger("EMC1");

		driver.get(url);
		driver.manage().window().maximize();
		logger.info("Url Opened");
		
	
	}

	/*@AfterClass
	public void tearDown() {

		driver.close();
		driver.quit();
	}*/

	public void captureScreenshot(WebDriver driver, String testName) throws IOException
	{
		TakesScreenshot screenshot = ((TakesScreenshot)driver);

		File Source = screenshot.getScreenshotAs(OutputType.FILE);

		File desc = new File(System.getProperty("User.dir") + "//ScreenShots//" + testName + ".png");
		
		FileUtils.copyFile(Source, desc);
	}

}
