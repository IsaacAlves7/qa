package com.automationexercise.tests;

import org.testng.annotations.Test;

import com.automationexercise.library.Base;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.TestCasePage;

public class Test7VerifyTestCasesPage extends Base{
	
	@Test
	public void verifyTestCasePage() {
		HomePage homepage = new HomePage();
		homepage.goToWebsite();
		TestCasePage testCasePage = homepage.clickTestCase();
		testCasePage.verifyTestCase();
		
	}
}
