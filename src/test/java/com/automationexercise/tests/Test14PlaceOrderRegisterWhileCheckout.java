package com.automationexercise.tests;

import org.testng.annotations.Test;

import com.automationexercise.library.Base;
import com.automationexercise.pages.AccountConfirmationPage;
import com.automationexercise.pages.AccountDeletedConfirmationPage;
import com.automationexercise.pages.AccountInformationPage;
import com.automationexercise.pages.CartPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.LoginPage;
import com.automationexercise.pages.PaymentPage;

public class Test14PlaceOrderRegisterWhileCheckout extends Base{
	
	@Test
	public void PlaceOrderRegisterWhileCheckout() {
	HomePage homePage =  new HomePage();
	homePage.goToWebsite();
	homePage.AddToCart(3);
	CartPage cartPage = homePage.clickViewCart();
	cartPage.verifyCartPage();
	cartPage.clickProceedToCheckout();
	LoginPage loginPage = cartPage.clickRegisterOrLogin();
	loginPage.verifySignUpForm();
	loginPage.enterSignUpName("Prajjwal Subedi");
	loginPage.enterSignUpEmail("peter311112@gmail.com");
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
	cartPage = homePage.clickCart();
	cartPage.clickProceedToCheckout();
	cartPage.verifyAddressAndReviewYourOrder();
	cartPage.enterCommentToOrder("Place Order");
	PaymentPage paymentPage= cartPage.clickPlaceOrder();
	paymentPage.enterNameOnCard("Prajjwal Subedi");
	paymentPage.enterCardNumber("1234567890978");
	paymentPage.enterCVC("343");
	paymentPage.enterExpiration("03", "2026");
	paymentPage.clickPayAndConfirmOrder();
	AccountDeletedConfirmationPage deleteConfirmation = homePage.clickDeleteUser();
	deleteConfirmation.clickContinue();
	
	}
	

}