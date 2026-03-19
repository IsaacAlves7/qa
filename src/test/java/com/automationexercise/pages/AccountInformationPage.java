package com.automationexercise.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automationexercise.library.Base;

public class AccountInformationPage extends Base {

	public AccountInformationPage() {
		WebElement element = myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"form\"]/div/div/div/div/h2/b"));
		assertEquals(element.getText(),"ENTER ACCOUNT INFORMATION", "Account Information Page not loded after 30 Seconds of Wait...");
	}

	public void selectTitle(String title) {
		title = title.toLowerCase();
		if (title == "mr" | title == "mr.") {
			myLibrary.clickButton(By.id("uniform-id_gender1"));
		} else {
			myLibrary.clickButton(By.id("id_gender2"));
		}
	}

	public void enterPassword(String password) {
		myLibrary.enterText(By.xpath("//*[@id=\"password\"]"), password);
	}

	public void enterDOB(int day, String month, int year) {
		myLibrary.selectDropDown(By.id("days"), Integer.toString(day));
		myLibrary.selectDropDown(By.id("months"), month);
		myLibrary.selectDropDown(By.id("years"), Integer.toString(year));
	}

	public void tickSignUpNewsLetter() {
		myLibrary.clickButton(By.id("newsletter"));
	}

	public void tickSpecialOffers() {
		myLibrary.clickButton(By.id("optin"));
	}

	public void enterFirstName(String firstName) {
		myLibrary.enterText(By.id("first_name"), firstName);
	}

	public void enterLastName(String lastName) {
		myLibrary.enterText(By.id("last_name"), lastName);
	}

	public void enterCompany(String company) {
		myLibrary.enterText(By.id("company"), company);
	}

	public void enterAddress1(String address1) {
		myLibrary.enterText(By.id("address1"), address1);
	}

	public void enterAddress2(String address2) {
		myLibrary.enterText(By.id("address2"), address2);
	}

	public void selectCountry(String country) {
		myLibrary.selectDropDown(By.id("country"), country);
	}

	public void enterState(String state) {
		myLibrary.enterText(By.id("state"), state);
	}

	public void enterCity(String city) {
		myLibrary.enterText(By.id("city"), city);
	}

	public void enterZipCode(int zipCode) {
		myLibrary.enterText(By.id("zipcode"), Integer.toString(zipCode));
	}

	public void enterMobileNumber(String mobileNumber) {
		myLibrary.enterText(By.id("mobile_number"), mobileNumber);
	}

	public AccountConfirmationPage clickCreateAccount() {
		myLibrary.clickButton(By.cssSelector("#form button.btn.btn-default"));

		return new AccountConfirmationPage();
	}
}
