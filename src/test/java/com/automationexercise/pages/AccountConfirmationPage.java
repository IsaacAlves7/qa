package com.automationexercise.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automationexercise.library.Base;

public class AccountConfirmationPage extends Base{

	public AccountConfirmationPage() {
		WebElement element = myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b"));
		assertEquals(element.getText(),"ACCOUNT CREATED!", "The Account Created page Was not loaded within 30 Second");
		
	}
	
	public HomePage clickContinueAfterCretion() {
		myLibrary.clickButton(By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));
		
		return new HomePage();
	}
	
}
