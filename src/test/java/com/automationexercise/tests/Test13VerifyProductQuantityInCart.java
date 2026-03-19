package com.automationexercise.tests;

import org.testng.annotations.Test;

import com.automationexercise.library.Base;
import com.automationexercise.pages.CartPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.ProductDetailPage;

public class Test13VerifyProductQuantityInCart extends Base{
	
	@Test
	public void VerifyProductQuantityInCart() {
		
		HomePage homePage = new HomePage();
		homePage.goToWebsite();
		ProductDetailPage  productDetailPage= homePage.clickProdut(2);
		productDetailPage.updateQuantityOfProduct(4);
		productDetailPage.clickAddtoCart();
		CartPage cartPage = productDetailPage.clickViewCart();
		cartPage.verifyCartProductAddedToCart(4);
		
		
		
	}

}
