package com.automationexercise.tests;

import org.testng.annotations.Test;

import com.automationexercise.library.Base;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.LoginPage;

public class Test4LogoutUser extends Base{

	@Test(enabled = true)
	public void TestUserLogOut() {
		HomePage homePage = new HomePage();
		homePage.goToWebsite();
		LoginPage loginPage = homePage.clickSignUpLogin();

		// Run Register User First so can login
		loginPage.verifyLogInForm();
		loginPage.enterLoginEmail("peter11111@gmail.com");
		loginPage.enterLoginPassword("peter11111@1234");
		HomePage loginConfirmation = loginPage.clickLogin();
		loginConfirmation.verifyLoggedIn();
		loginPage = loginConfirmation.logOut();
		loginPage.verifyLogInForm();
		
	}
	
}
