package com.automationexercise.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automationexercise.library.Base;

public class TestCasePage extends Base {

	
	public void verifyTestCase() {
		WebElement element = myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"form\"]/div/div[1]/div/h2"));
		assertEquals(element.getText(), "TEST CASES","Test Case page not loded properly.. ");
	}
	
	
}
