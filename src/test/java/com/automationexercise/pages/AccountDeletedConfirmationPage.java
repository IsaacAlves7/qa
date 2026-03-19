package com.automationexercise.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automationexercise.library.Base;

public class AccountDeletedConfirmationPage extends Base{

	public AccountDeletedConfirmationPage() {
		
		WebElement element = myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b"));
		assertEquals(element.getText(),"ACCOUNT DELETED!", "ACCOUNT DELETED! Confirmation not visible after 30 Second Wait...");
	}
	
	public void clickContinue() {
		myLibrary.clickButton(By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));
	}
}
