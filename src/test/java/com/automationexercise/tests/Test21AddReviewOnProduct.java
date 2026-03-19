package com.automationexercise.tests;

import org.testng.annotations.Test;

import com.automationexercise.library.Base;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.ProductDetailPage;
import com.automationexercise.pages.ProductPage;

public class Test21AddReviewOnProduct extends Base {

	@Test
	public void AddReviewOnProduct() {
		HomePage homePage = new HomePage();
		homePage.goToWebsite();
		ProductPage productpage = homePage.clickAllProduct();
		productpage.verifyProductPage();
		ProductDetailPage productDetailPage = productpage.clickProdut(3);
		productDetailPage.verifyWriteYourReview();
		productDetailPage.enterReview("Prajjwal Subedi", "Prajjwalsubedi@gmail.com", "This is the Test For a Review");
		productDetailPage.verifyReviewSubmittedMessage();
	}
	
	
}
