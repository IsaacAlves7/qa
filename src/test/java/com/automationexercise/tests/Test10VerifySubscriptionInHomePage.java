package com.automationexercise.tests;

import org.testng.annotations.Test;

import com.automationexercise.library.Base;
import com.automationexercise.pages.HomePage;

public class Test10VerifySubscriptionInHomePage extends Base{

	@Test
	public void VerifySubscriptionInHomePage() {
		HomePage homePage = new HomePage();
		homePage.goToWebsite();
		homePage.scrollToFooter();
		homePage.verifySubscription();
		homePage.enterSubsEmail("prax@gmail.com");
		homePage.clickSubscribe();
		homePage.verifySubscribedMessage();
		
	}
}
