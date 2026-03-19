package com.automationexercise.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.automationexercise.library.Base;
import com.automationexercise.pages.CartPage;
import com.automationexercise.pages.HomePage;

public class Test22AddToCartFromRecommendedItems extends Base{
	@Test
	public void AddToCartFromRecommendedItems() {
		HomePage homePage = new HomePage();
		homePage.goToWebsite();
		myLibrary.scrollToElement(By.id("footer"));
		homePage.verifyRecommendedItems();
		homePage.AddRecommendedItemsToCart(3);
		CartPage cartPage = homePage.clickViewCart();
		cartPage.verifyCartProductAddedToCart(1);
	}

}
