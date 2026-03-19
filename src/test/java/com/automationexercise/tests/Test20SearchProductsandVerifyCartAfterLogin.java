package com.automationexercise.tests;

import org.testng.annotations.Test;

import com.automationexercise.library.Base;
import com.automationexercise.pages.CartPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.LoginPage;
import com.automationexercise.pages.ProductPage;

public class Test20SearchProductsandVerifyCartAfterLogin extends Base {

	@Test
	public void SearchProductsandVerifyCartAfterLogin() {
		HomePage homePage = new HomePage();
		homePage.goToWebsite();
		ProductPage productpage = homePage.clickAllProduct();
		productpage.verifyProductPage();
		productpage.searchProducts("White");
		productpage.verifySearchProduct();
		productpage.verifySearchlListMatch("White");
		productpage.AddAllProductToCart();
		CartPage cartPage= homePage.clickCart();
		cartPage.verifyCartProductAddedToCart(3);
		LoginPage loginPage = homePage.clickSignUpLogin();
		loginPage.enterLoginEmail("peter1111121@gmail.com");
		loginPage.enterLoginPassword("peter11111@1234");
		homePage = loginPage.clickLogin();
		cartPage = homePage.clickCart();
		cartPage.verifyCartProductAddedToCart(3);
		
		
		
	}
	
}
