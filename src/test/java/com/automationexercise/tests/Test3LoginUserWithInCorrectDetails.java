package com.automationexercise.tests;

import org.testng.annotations.Test;

import com.automationexercise.library.Base;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.LoginPage;

public class Test3LoginUserWithInCorrectDetails extends Base {

	@Test(enabled = true)
	public void TestUserUsingCorrectDetails() {
		HomePage homePage =  new HomePage();
		homePage.goToWebsite();
		LoginPage loginPage = homePage.clickSignUpLogin();
		
		loginPage.verifyLogInForm();
		loginPage.enterLoginEmail("peter00000@gmail.com"); // Wrong Email Provided
		loginPage.enterLoginPassword("1234567890@1234");
		loginPage.clickLogin(); // takes to homePage but on site never redirects as id and password is Wrong
		loginPage.checkWrongDetails();
		
	}
	
}
// need to be done