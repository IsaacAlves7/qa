package com.automationexercise.tests;

import org.testng.annotations.Test;

import com.automationexercise.library.Base;
import com.automationexercise.pages.HomePage;

public class Test26VerifyScrollUpWithoutArrowButtonAndScrollDownFunctionality extends Base{

	@Test
	public void VerifyScrollUpUsingArrowButtonAndScrollDownFunctionality() {
		HomePage homePage = new HomePage();
		homePage.goToWebsite();
		homePage.scrollToButton();
		homePage.verifySubscription();
		homePage.clickScrollUpButtonUsingArrow();
		homePage.verifyFullFledgedText();
	}
	
}
