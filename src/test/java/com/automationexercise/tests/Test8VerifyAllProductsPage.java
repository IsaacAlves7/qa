package com.automationexercise.tests;

import org.testng.annotations.Test;

import com.automationexercise.library.Base;
import com.automationexercise.pages.ProductPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.ProductDetailPage;

public class Test8VerifyAllProductsPage extends Base {

	@Test
	public void verifyAllProductPage() {

		HomePage homePage = new HomePage();
		homePage.goToWebsite();
		ProductPage allProductPage = homePage.clickAllProduct();
		allProductPage.verifyProductPage();
		allProductPage.verifyAllProductList();
		ProductDetailPage productDetailPage = allProductPage.clickProdut(0); // NOT WORKING
		productDetailPage.VerifyProductDetailPage();
		productDetailPage.VerifyProductDetailsOfProduct();

	}
}
