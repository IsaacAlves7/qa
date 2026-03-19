package com.automationexercise.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;

import com.automationexercise.library.Base;

public class PaymentPage extends Base{

	public void enterNameOnCard(String string) {
		myLibrary.enterText(By.cssSelector("#payment-form > div:nth-child(2) > div > input"), string);
	}
	public void enterCardNumber(String CardNumber) {
		myLibrary.enterText(By.cssSelector("#payment-form > div:nth-child(3) > div > input"), CardNumber);
	}
	public void enterCVC(String cvc) {
		myLibrary.enterText(By.cssSelector("#payment-form > div:nth-child(4) > div.col-sm-4.form-group.cvc > input"), cvc);
	}
	public void enterExpiration(String MM, String YYYY) {
		myLibrary.enterText(By.cssSelector("#payment-form > div:nth-child(4) > div:nth-child(2) > input"), MM);
		myLibrary.enterText(By.cssSelector("#payment-form > div:nth-child(4) > div:nth-child(3) > input"), YYYY);
	}	
	
	public void clickPayAndConfirmOrder() {
		myLibrary.clickButton(By.cssSelector("#submit"));
//		myLibrary.waitForElementVisibility(By.partialLinkText("Your order has been placed successfully!"));  // (redirects So Fast)
	}
	public void clickDownloadInvoice() {
		myLibrary.clickButton(By.linkText("Download Invoice"));
		
	}
	public HomePage clickContinue() {
		myLibrary.clickButton(By.linkText("Continue"));
		
		return new HomePage();
		
	}
	public void checkFileDownload(String downloadLocation, String expectedFileName) {
		boolean value = myLibrary.isFileAvailable(downloadLocation, expectedFileName);
		assertTrue(value, "The File is not avaliable.. ");
	}
	
}
