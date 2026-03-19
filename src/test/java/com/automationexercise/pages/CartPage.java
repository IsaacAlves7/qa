package com.automationexercise.pages;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.automationexercise.library.Base;

public class CartPage  extends Base{
	JavascriptExecutor executor = (JavascriptExecutor)driver;
			
	public void verifyCartProductAddedToCart(int numberOfProductsAdded) {
		List<WebElement> elementList = driver.findElements(By.cssSelector("tbody tr"));
		int totalQuantity = 0;
		for (WebElement element : elementList) {
			String quantityStr = element.findElement(By.cssSelector("td.cart_quantity .disabled")).getText().trim();
			int quantity = Integer.valueOf(quantityStr);
			totalQuantity += quantity;
		}
		assertTrue(totalQuantity == numberOfProductsAdded, "The cout of product is not equal to the added products..");
		
	}
	
	public void verifyCartPricesQuantityAndTotalPrice() {
		List<WebElement> elementList = driver.findElements(By.cssSelector("tbody tr"));
		
		for (int i=0; i< elementList.size(); i++) {
			WebElement element = elementList.get(0);
			String str = element.findElement(By.className("cart_price")).getText().trim();
			StringBuilder string =  new StringBuilder(str);
			int price = Integer.valueOf(string.replace(0, 3, "").toString().trim());
			str = element.findElement(By.className("cart_total_price")).getText().trim();
			string =  new StringBuilder(str);
			int totalPrice = Integer.valueOf(string.replace(0, 3, "").toString().trim());
			String quantityStr = element.findElement(By.cssSelector("td.cart_quantity .disabled")).getText().trim();
			int quantity = Integer.valueOf(quantityStr);
			
			assertTrue(totalPrice == price * quantity, "The total of price * quantity was not equal to total price for "+ str);
		}
				
	}	
	
	public void verifyCartPage() {
		WebElement element = myLibrary.waitForElementVisibility(By.cssSelector("div.breadcrumbs ol li.active"));
		String text = element.getText().toLowerCase().trim();
		assertTrue(text.equals("shopping cart"), "The Shopping cart breadcrumb not visible in Cart Page");
	}
	public CheckOutPage clickProceedToCheckout() {
		myLibrary.clickButton(By.cssSelector("#do_action > div.container > div > div > a"));
		boolean value = myLibrary.checkVisibility(By.cssSelector(".modal-confirm .btn"));
		if (value == true) {
			return null;
		}else {
			return new CheckOutPage();
		}
	}
	public  LoginPage clickRegisterOrLogin() {
		myLibrary.clickButton(By.cssSelector("#checkoutModal  div.modal-body  a"));
		
		return new LoginPage();
		
	}
	public void verifyAddressAndReviewYourOrder() {
		WebElement element = myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"cart_items\"]/div/div[2]/h2"));
		String text = element.getText().toLowerCase().trim();
		assertTrue(text.equals("address details"), "Address details not visible in Cart Page");
		element = myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"cart_items\"]/div/div[4]/h2"));
		text = element.getText().toLowerCase().trim();
		assertTrue(text.equals("review your order"), "review your order not visible in Cart Page");
	}
	public void enterCommentToOrder(String string) {
		myLibrary.enterText(By.cssSelector("#ordermsg > textarea"), string);
	}
	
	public PaymentPage clickPlaceOrder() {
		myLibrary.clickButton(By.cssSelector("#cart_items > div > div:nth-child(7) > a"));
		
		return new PaymentPage();
	}
	public void removeEverythingOnCart() {
		List<WebElement> elementList = driver.findElements(By.cssSelector("td.cart_delete  a"));
		for (WebElement e : elementList) {
			e.click();
		}
	}
	public void verifyNoProductsInCart() {
		WebElement element = driver.findElement(By.xpath("//*[@id=\"empty_cart\"]/p/b"));
		System.out.println(element.getText());
		assertNotNull(element.getText() == "Cart is empty!", "There are some products in the Cart !!");
	}
}
