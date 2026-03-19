package com.automationexercise.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automationexercise.library.Base;

public class ContactUsPage extends Base {
	
	public void verifyContactPage() {
		WebElement element = myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/h2"));
		assertEquals(element.getText(),"GET IN TOUCH", "GET IN TOUCH is not visible after 30 second of wait time...");	
	}
	
	public void enterName(String name) {
		myLibrary.enterText(By.xpath("//*[@id=\"contact-us-form\"]/div[1]/input"), name);
	}

	public void enterEmail(String email) {
		myLibrary.enterText(By.xpath("//*[@id=\"contact-us-form\"]/div[2]/input"), email);
	}
	
	public void enterSubject(String subject) {
		myLibrary.enterText(By.xpath("//*[@id=\"contact-us-form\"]/div[3]/input"), subject);
	}
	
	public void enterMessage(String message) {
		myLibrary.enterText(By.id("message"), message);
	}
	
	public void uploadFile(String fileAddress) {
		myLibrary.uploadFile(By.xpath("//*[@id=\"contact-us-form\"]/div[5]/input"), fileAddress);
	}
	
	public void clickSubmit() {
		myLibrary.clickButton(By.xpath("//*[@id=\"contact-us-form\"]/div[6]/input"));
	}
	
	public void verifyContactSumbission() {
		WebElement element = myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/div[2]"));
		assertEquals(element.getText(), "Success! Your details have been submitted successfully.", "Success! Your details have been submitted successfully.   was not visible after 30 Second of wait");
	}
	
	public HomePage clickHomeButton() {
		myLibrary.clickButton(By.xpath("//*[@id=\"form-section\"]/a"));
		
		return new HomePage();
	}
	
	
}
