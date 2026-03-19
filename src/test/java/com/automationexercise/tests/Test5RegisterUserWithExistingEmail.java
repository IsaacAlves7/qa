package com.automationexercise.tests;

import org.testng.annotations.Test;

import com.automationexercise.library.Base;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.LoginPage;

public class Test5RegisterUserWithExistingEmail extends Base{
	
	@Test
	public void RegisterUserOnly() {
		
		HomePage homePage = new HomePage();
		homePage.goToWebsite();
		LoginPage loginPage = homePage.clickSignUpLogin();

		loginPage.verifySignUpForm();
		loginPage.enterSignUpName("Prajjwal Subedi");
		loginPage.enterSignUpEmail("peter11111@gmail.com");
		loginPage.clickSignUp();
		loginPage.checkSameEmail();
		
		
	}
}
