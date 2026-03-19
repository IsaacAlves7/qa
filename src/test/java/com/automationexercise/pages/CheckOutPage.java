package com.automationexercise.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.automationexercise.library.Base;

public class CheckOutPage extends Base {
	
	JavascriptExecutor executor = (JavascriptExecutor)driver;

	public  LoginPage clickRegisterOrLogin() {
		WebElement element = myLibrary.waitForElementVisibility(By.cssSelector("#checkoutModal > div > div > div.modal-body > p:nth-child(2) > a > u"));
		element = myLibrary.waitForElementToBeClickable(By.cssSelector(".modal-confirm .btn"));
		executor.executeScript("arguments[0].click()", element); 
		
		return new LoginPage();
		
	}
	public void verifyDeliveryAddress(String[] List) {
		WebElement DeliveryAddress = driver.findElement(By.cssSelector(".address.item.box"));
		String address = DeliveryAddress.getText().toLowerCase().trim();
		System.out.println(address);
		for (String e: List) {
			assertTrue(address.contains(e.toLowerCase().trim()), "Cant find "+ e +" in Delivery Address at Checkout Page.");
		}
	}
	public void verifyShippingAddress(String[] List) {
		WebElement DeliveryAddress = driver.findElement(By.cssSelector(".address.alternate_item.box"));
		String address = DeliveryAddress.getText().toLowerCase().trim();
		System.out.println(address);
		for (String e: List) {
			assertTrue(address.contains(e.toLowerCase().trim()), "Cant find "+ e +" in Shipping Address at Checkout Page.");
		}
	}
	public PaymentPage clickPlaceOrder() {
		myLibrary.clickButton(By.cssSelector("#cart_items > div > div:nth-child(7) > a"));
		
		return new PaymentPage();
	}
}
