package com.automationexercise.tests;


import org.testng.annotations.Test;

import com.automationexercise.library.Base;
import com.automationexercise.pages.CategoryAndBrandPage;
import com.automationexercise.pages.HomePage;

public class Test18ViewCategoryProducts extends Base{
	
	@Test
	public void ViewCategoryProducts() {
		HomePage homePage =  new HomePage();
		homePage.goToWebsite();
		homePage.verifyCategoryOnSideBar();
		CategoryAndBrandPage categoryPage = homePage.clickCategory("women", "dress");
//		categoryPage.verifyCategoryPage();
		categoryPage.checkTitleOfCategoryAndBrandPage("women", "dress");
		System.out.println("Women complete");
		categoryPage = homePage.clickCategory("men", "tshirts");
		categoryPage.checkTitleOfCategoryAndBrandPage("men", "tshirts");
		System.out.println("complete");
		categoryPage.verifyCategoryPage();
		
	}
	
	
}
