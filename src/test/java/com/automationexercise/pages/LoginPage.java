package com.automationexercise.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automationexercise.library.Base;

public class LoginPage extends Base {

	public static String userName;

	public LoginPage() {


	}
	
	public void verifySignUpForm() {
		
		WebElement element = myLibrary
				.waitForElementVisibility(By.cssSelector(".signup-form>h2"));
		assertEquals(element.getText(),"New User Signup!", "New User Signup!   Not visible...");
		
	}

	public void verifyLogInForm() {
		
		WebElement element = myLibrary
				.waitForElementVisibility(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2"));
		assertEquals(element.getText(),"Login to your account", "Login to your account   Not visible...");
		
	}

	public void enterSignUpName(String name) {
		userName = name;
		myLibrary.enterText(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]"), name);
	}

	public void enterSignUpEmail(String email) {
		myLibrary.enterText(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]"), email);
	}

	public AccountInformationPage clickSignUp() {
		myLibrary.clickButton(By.cssSelector(".signup-form button"));
		boolean value = myLibrary.checkVisibility(By.cssSelector("#form > div > div > div:nth-child(3) > div > form > p"));
		if (value == true) {
			System.out.println("Already registered  with same email!");
			return null;
		}else {
			return new AccountInformationPage();
		}

	}

	public void enterLoginEmail(String email) {
		myLibrary.enterText(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]"), email);
	}

	public void enterLoginPassword(String password) {
		myLibrary.enterText(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]"), password);
	}

	public HomePage clickLogin() {
		myLibrary.clickButton(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button"));
		boolean value = myLibrary.checkVisibility(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/p"));
		if (value == true) {
			System.out.println("Wrong Email or Password!");
			return null;
		}else {
			return new HomePage();
		}
			
	}
	
	
	public void checkWrongDetails() {
		WebElement element = myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/p"));
		assertNotNull(element, "Your email or password is incorrect! was not displayed after 30 Sec of Wait..");
	}
	
	
	public void checkSameEmail() {
		WebElement element = myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/p"));
		assertNotNull(element, "Your email or password is incorrect! was not displayed after 30 Sec of Wait..");
	}
}
