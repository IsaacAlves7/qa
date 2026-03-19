package com.automationexercise.tests;

import org.testng.annotations.Test;

import com.automationexercise.library.Base;
import com.automationexercise.pages.HomePage;

public class Test11VerifySubscriptionInCartPage extends Base {
	
	@Test
	public void VerifySubscriptionInCartPage() {
		HomePage homePage = new HomePage();
		homePage.goToWebsite();
		homePage.clickCart();
		homePage.scrollToFooter();
		homePage.enterSubsEmail("hello@gmail.com");
		homePage.clickSubscribe();
		homePage.verifySubscribedMessage();
	}
}
