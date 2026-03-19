package com.automationexercise.tests;

import org.testng.annotations.Test;

import com.automationexercise.library.Base;
import com.automationexercise.pages.CartPage;
import com.automationexercise.pages.HomePage;

public class Test17RemoveProductsFromCart extends Base {
	
	@Test
	public void RemoveProductsFromCart() {
		HomePage homePage =  new HomePage();
		homePage.goToWebsite();
		homePage.AddToCart(4);
		CartPage cartPage = homePage.clickViewCart();
		cartPage.verifyCartPage();
		cartPage.removeEverythingOnCart();
		cartPage.verifyNoProductsInCart();
		
	}
	
}
