package com.automationexercise.pages;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.automationexercise.library.Base;

public class ProductDetailPage extends Base{
	
	JavascriptExecutor executor = (JavascriptExecutor)driver;
 
	public void VerifyProductDetailPage() {
		boolean value = myLibrary.checkCurrentUrl("product_details");
		 assertTrue(value, "It didn't direct to Product details page ");
	}
	
	
//	product name, category, price, availability, condition, brand
	public void VerifyProductDetailsOfProduct () {
		WebElement element = myLibrary.waitForElementVisibility(By.cssSelector("div.product-information h2"));
		assertNotNull(element, "The product Name is not loded.. ");
		element = myLibrary.waitForElementVisibility(By.cssSelector("div.product-information p:nth-child(3)"));
		assertNotNull(element, "The product Category is not loded.. ");
		element = myLibrary.waitForElementVisibility(By.cssSelector("div.product-information span span"));
		assertNotNull(element, "The product Price is not loded.. ");
		element = myLibrary.waitForElementVisibility(By.cssSelector("div.product-information p:nth-child(6)"));
		assertNotNull(element, "The product Availability is not loded.. ");
		element = myLibrary.waitForElementVisibility(By.cssSelector("div.product-information p:nth-child(7)"));
		assertNotNull(element, "The product condition is not loded.. ");
		element = myLibrary.waitForElementVisibility(By.cssSelector("div.product-information p:nth-child(8)"));
		assertNotNull(element, "The product brand is not loded.. ");
	}
	
	public void updateQuantityOfProduct(int noOfUnits) {
		String string = Integer.toString(noOfUnits);
		myLibrary.enterText(By.id("quantity"), string);
	}
	
	public void clickAddtoCart() {
		myLibrary.clickButton(By.cssSelector("button.btn.cart"));
	}
	
	public CartPage clickViewCart() {
		WebElement element = myLibrary.waitForElementVisibility(By.cssSelector("div.modal-body a"));
		element = myLibrary.waitForElementToBeClickable(By.cssSelector("div.modal-body a"));
		executor.executeScript("arguments[0].click()", element); 
		
		return new CartPage();
	}
	
	public void enterReview(String Name, String Email, String Review) {
		myLibrary.enterText(By.id("name"), Name);
		myLibrary.enterText(By.id("email"), Email);
		myLibrary.enterText(By.id("review"), Review);
		myLibrary.clickButton(By.id("button-review"));
	}
	
	public void verifyWriteYourReview() {
		WebElement element = driver.findElement(By.cssSelector("li.active a"));
		assertTrue(element.getText().toLowerCase().equals("write your review"), "The \"Write Your Review\" is not visible...");
	}
	
	public void verifyReviewSubmittedMessage() {
		WebElement element = myLibrary.waitForElementVisibility(By.cssSelector("#review-section  .alert-success"));
		assertTrue(element.getText().toLowerCase().equals("Thank you for your review.".toLowerCase()), "The \"Write Your Review\" is not visible...");
	}
	
}
