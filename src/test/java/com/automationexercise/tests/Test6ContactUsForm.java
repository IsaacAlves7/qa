package com.automationexercise.tests;

import org.testng.annotations.Test;

import com.automationexercise.library.Base;
import com.automationexercise.pages.ContactUsPage;
import com.automationexercise.pages.HomePage;

public class Test6ContactUsForm extends Base{
	
	@Test
	public void TestcontactUs() {
		HomePage homePage= new HomePage();
		homePage.goToWebsite();
		ContactUsPage contactUsPage = homePage.clickContactUs();
		contactUsPage.verifyContactPage();
		contactUsPage.enterName("Prajjwal Subedi");
		contactUsPage.enterEmail("Prajjwal100@gmail.com");
		contactUsPage.enterSubject("Hello Test Subject");
		contactUsPage.enterMessage("This is the test message from Prajjwal");
		contactUsPage.uploadFile("/Users/prajjwalsubedi/eclipse-workspace/MBSelenium/automationExercise/src/test/resources/sideguru.jpeg");
		contactUsPage.clickSubmit();
		myLibrary.acceptAlert();
		contactUsPage.verifyContactSumbission();
		homePage = contactUsPage.clickHomeButton();
		
	}
}
