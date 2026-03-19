package com.automationexercise.tests;

import org.testng.annotations.Test;

import com.automationexercise.library.Base;
import com.automationexercise.pages.CategoryAndBrandPage;
import com.automationexercise.pages.HomePage;

public class Test19ViewCartBrandProducts extends Base{
	
	@Test
	public void ViewCartBrandProducts() {
		HomePage homePage = new HomePage();
		homePage.goToWebsite();
		homePage.clickAllProduct();
		CategoryAndBrandPage brandPage = homePage.clickBrand("h&m");
		brandPage.checkTitleOfCategoryAndBrandPage("Brand", "h&m");
		brandPage.CheckProductsAreVisible();
		brandPage = homePage.clickBrand("kookie kids");
		brandPage.checkTitleOfCategoryAndBrandPage("Brand", "kookie kids");
		brandPage.CheckProductsAreVisible();
		brandPage.verifyBrandPage();
		
	}
	
	
}
