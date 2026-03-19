package com.automationexercise.pages;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.automationexercise.library.Base;

public class ProductPage extends Base {
	
	JavascriptExecutor executor = (JavascriptExecutor)driver;

	public void verifyProductPage() {
		WebElement element = driver.findElement(By.cssSelector("h2.title.text-center"));
		String text = element.getText().toLowerCase().trim();
		System.out.println(element.getText());   //gives "FEATURES ITEMS"
		assertTrue(text.equals("ALL PRODUCTS".toLowerCase().trim())
				|| text.equals("FEATURES ITEMS".toLowerCase().trim()), "All Products not Visible");
	}
	
	public void verifyAllProductList() {
		WebElement element = myLibrary.waitForElementVisibility(By.cssSelector(".features_items"));
		assertNotNull(element, "The All Product List is not visible after 30 Second wait time..");
		
	}
	
	public void verifySearchProduct() {
		WebElement element = driver.findElement(By.cssSelector("h2.title.text-center"));
		String string = element.getText().toUpperCase().trim();
		assertTrue(string.equals("SEARCHED PRODUCTS"), "Searched Product not Visible");
				
	}
	
	public ProductDetailPage clickProdut(int indexOnList) {
		List<WebElement>  elements = driver.findElements(By.cssSelector("div.choose li a"));
		WebElement element = elements.get(indexOnList);
		
		executor.executeScript("arguments[0].click()", element); 
		return new ProductDetailPage();
	}
	
	public void searchProducts(String string) {
		myLibrary.enterText(By.id("search_product"), string);
		myLibrary.clickButton(By.id("submit_search"));
	}
	
	public void verifySearchlListMatch(String string) {
		boolean value = myLibrary.checkSearchResults(By.cssSelector(".features_items .col-sm-4 div.productinfo p"), string);
		assertTrue(value);
	}
	
	public void hoverOverElement(int index) {
		List<WebElement> elements = driver.findElements(By.cssSelector("div.features_items .col-sm-4 .productinfo"));
		WebElement element = elements.get(index);
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
	
	public void AddToCart(int index) {
		List<WebElement> elements = driver.findElements(By.cssSelector("div.features_items .col-sm-4 .productinfo  a.add-to-cart"));
		WebElement element = elements.get(index);
		executor.executeScript("arguments[0].click()", element); 
		
	}
	public void AddAllProductToCart() {
		List<WebElement> elements = driver.findElements(By.cssSelector("div.features_items .col-sm-4 .productinfo  a.add-to-cart"));
		for (WebElement e: elements) {
			executor.executeScript("arguments[0].click()", e); 
			WebElement element = myLibrary.waitForElementVisibility(By.cssSelector(".modal-confirm .btn"));
			element = myLibrary.waitForElementToBeClickable(By.cssSelector(".modal-confirm .btn"));
			executor.executeScript("arguments[0].click()", element); 
	}
		
		
	}
	
	public ProductPage clickContinueShopping() {
		WebElement element = myLibrary.waitForElementVisibility(By.cssSelector(".modal-confirm .btn"));
		element = myLibrary.waitForElementToBeClickable(By.cssSelector(".modal-confirm .btn"));
		executor.executeScript("arguments[0].click()", element); 
		
		return this;
		
	}
	
	public CartPage clickViewCart() {
		WebElement element = myLibrary.waitForElementVisibility(By.cssSelector("div.modal-body a"));
		element = myLibrary.waitForElementToBeClickable(By.cssSelector("div.modal-body a"));
		executor.executeScript("arguments[0].click()", element); 
		
		return new CartPage();
	}
	
}
