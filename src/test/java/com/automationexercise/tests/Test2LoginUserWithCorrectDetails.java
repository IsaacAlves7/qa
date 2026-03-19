package com.automationexercise.tests;

import org.testng.annotations.Test;

import com.automationexercise.library.Base;
import com.automationexercise.pages.AccountDeletedConfirmationPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.LoginPage;

public class Test2LoginUserWithCorrectDetails extends Base {

	@Test(enabled = true)
	public void TestUserUsingIncorrectCorrectDetails() {
		HomePage homePage = new HomePage();
		homePage.goToWebsite();
		LoginPage loginPage = homePage.clickSignUpLogin();

		// Run Register User First so can login
		loginPage.verifyLogInForm();
		loginPage.enterLoginEmail("peter1111121@gmail.com");
		loginPage.enterLoginPassword("peter11111@1234");
		HomePage loginConfirmation = loginPage.clickLogin();
		loginConfirmation.verifyLoggedIn();
		AccountDeletedConfirmationPage deleteConfirmation = loginConfirmation.clickDeleteUser();
		deleteConfirmation.clickContinue();
	}
}
