package com.automationexercise.tests;

import org.testng.annotations.Test;

import com.automationexercise.library.Base;
import com.automationexercise.pages.ProductPage;
import com.automationexercise.pages.HomePage;

public class Test9SearchProduct extends Base {

	@Test
	public void searchProductTest() {
		HomePage homePage = new HomePage();
		homePage.goToWebsite();
		ProductPage allProductPage = homePage.clickAllProduct();
		allProductPage.verifyProductPage();
		allProductPage.searchProducts("dress");
		allProductPage.verifySearchProduct();
		allProductPage.verifySearchlListMatch("dress");
		
		
	}
	
}
