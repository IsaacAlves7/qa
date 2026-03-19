package com.automationexercise.tests;

import org.testng.annotations.Test;

import com.automationexercise.library.Base;
import com.automationexercise.pages.AccountConfirmationPage;
import com.automationexercise.pages.AccountDeletedConfirmationPage;
import com.automationexercise.pages.AccountInformationPage;
import com.automationexercise.pages.CartPage;
import com.automationexercise.pages.CheckOutPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.LoginPage;

public class Test23VerifyAddressDetailsInCheckoutPage extends Base{

	@Test
	public void VerifyAddressDetailsInCheckoutPage() {
		HomePage homePage = new HomePage();
		homePage.goToWebsite();
		LoginPage loginPage = homePage.clickSignUpLogin();

		loginPage.verifySignUpForm();
		loginPage.enterSignUpName("Prajjwal Subedi");
		loginPage.enterSignUpEmail("peter11111210@gmail.com");
		AccountInformationPage accountInformation = loginPage.clickSignUp();

		accountInformation.selectTitle("mr");
		accountInformation.enterPassword("peter11111@1234");
		accountInformation.enterDOB(30, "October", 1996);
		accountInformation.tickSignUpNewsLetter();
		accountInformation.tickSpecialOffers();
		// Fill details: First name, Last name, Company, Address, Address2,
		// Country, State, City, Zipcode, Mobile Number
		accountInformation.enterFirstName("Prajjwal");
		accountInformation.enterLastName("Subedi");
		accountInformation.enterCompany("Logic Accountants");
		accountInformation.enterAddress1("2/4 cecil St");
		accountInformation.enterCity("Sydney");
		accountInformation.enterState("NSW");
		accountInformation.selectCountry("United States");
		accountInformation.enterZipCode(20137);
		accountInformation.enterMobileNumber("5715389808");
		AccountConfirmationPage accountConfirmation = accountInformation.clickCreateAccount();

		homePage = accountConfirmation.clickContinueAfterCretion();
		homePage.verifyLoggedIn();
		homePage.AddToCart(4);
		CartPage cartPage = homePage.clickViewCart();
		cartPage.verifyCartPage();
		cartPage.verifyCartProductAddedToCart(1);
		CheckOutPage checkOutPage = cartPage.clickProceedToCheckout();
		String[] AddressList= new String[]{"Prajjwal","Subedi","Logic Accountants","2/4 cecil St","Sydney",
				"United States","20137", "5715389808"};
		checkOutPage.verifyDeliveryAddress(AddressList);
		checkOutPage.verifyShippingAddress(AddressList);
		AccountDeletedConfirmationPage accountDeletedConfirmationPage=homePage.clickDeleteUser();
		accountDeletedConfirmationPage.clickContinue();
		
	}
	
}
