package com.automationexercise.tests;

import org.testng.annotations.Test;

import com.automationexercise.library.Base;
import com.automationexercise.pages.AccountDeletedConfirmationPage;
import com.automationexercise.pages.CartPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.LoginPage;
import com.automationexercise.pages.PaymentPage;

public class Test16PlaceOrderLoginBeforeCheckout extends Base{
	
	@Test
	public void PlaceOrderRegisterWhileCheckout() {
	HomePage homePage =  new HomePage();
	homePage.goToWebsite();
	LoginPage loginPage =homePage.clickSignUpLogin();
	loginPage.enterLoginEmail("peter1111121@gmail.com");
	loginPage.enterLoginPassword("peter11111@1234");
	homePage = loginPage.clickLogin();
	homePage.verifyLoggedIn();
	homePage.AddToCart(3);
	CartPage cartPage = homePage.clickViewCart();
	cartPage.verifyCartPage();
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