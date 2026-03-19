package com.automationexercise.library;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class Base {
	
	public static final Logger logger = LogManager.getLogger(Base.class);

	public static WebDriver driver;
	public static GlobalSelenium myLibrary;
	

	//
	@BeforeClass
	public void beforeClass() {
		// runs one time Before the test suite class
		
	}

	//
	@AfterClass
	public void afterClass() {
		// runs one time After all the test suite class
		// generate Test reports
		// Send test result email to the team

	}

	@BeforeMethod
	public void beforeEachTest() {
		try {
			myLibrary = new GlobalSelenium();
			driver = myLibrary.startChromeBrowser();
			myLibrary.delay(5);
			myLibrary.synchronize();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@AfterMethod
	public void afterEachTest() {
		try {
			Thread.sleep(5 * 1000);
			logger.info("Waiting for 5 Seconds.. ");
			if (driver != null) {
				driver.close();
				driver.quit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
