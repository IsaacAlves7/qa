package com.automationexercise.tests;

import org.testng.annotations.Test;

import com.automationexercise.library.Base;
import com.automationexercise.pages.CartPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.ProductPage;

public class Test12AddProductsInCart extends Base{
	@Test
	public void AddProductsInCart() {
		HomePage homePage = new HomePage();
		homePage.goToWebsite();
		ProductPage productPage = homePage.clickAllProduct();
		productPage.hoverOverElement(0);
		productPage.AddToCart(0);
		productPage.clickContinueShopping();
		productPage.hoverOverElement(1);
		productPage.AddToCart(1);
		CartPage cartPage= productPage.clickViewCart();
		cartPage.verifyCartProductAddedToCart(2);
		cartPage.verifyCartPricesQuantityAndTotalPrice();
	}
}
