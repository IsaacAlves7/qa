package com.automationexercise.pages;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.automationexercise.library.Base;

public class HomePage extends Base {
	
	JavascriptExecutor executor = (JavascriptExecutor)driver;

	public void goToWebsite() {
		driver.get("https://automationexercise.com/");
		WebElement element = myLibrary
				.waitForElementVisibility(By.xpath("//*[@id=\"header\"]/div/div/div/div[1]/div/a/img"));
		assertNotNull(element, "HomePage not Loaded after 30 second wait.");
	}

	public LoginPage clickSignUpLogin() {
		myLibrary.clickButton(By.cssSelector("ul.nav.navbar-nav li a[href=\"/login\"]"));

		return new LoginPage();
	}
	
	public ContactUsPage clickContactUs() {
		myLibrary.clickButton(By.cssSelector("ul.nav.navbar-nav li a[href=\"/contact_us\"]"));
		
		return new ContactUsPage();
	}
	
	public void verifyLoggedIn() {
		WebElement element = myLibrary.waitForElementVisibility(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));
		boolean value = element.getText().contains("Logged in as ");
		assertTrue(value, "Loggedin as User not displayed after login");
	}

	public AccountDeletedConfirmationPage clickDeleteUser() {
		myLibrary.clickButton(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a"));
		
		return new AccountDeletedConfirmationPage();
	}
	
	public LoginPage logOut() {
		myLibrary.clickButton(By.cssSelector("ul.nav.navbar-nav li a[href=\"/logout\"]"));
		
		return new LoginPage();
		
	}
	
	public CartPage clickCart() {
		myLibrary.clickButton(By.cssSelector("ul.nav.navbar-nav li a[href=\"/view_cart\"]"));
		
		return new CartPage();
	}
	
	public TestCasePage clickTestCase() {
		myLibrary.clickButton(By.cssSelector("ul.nav.navbar-nav li a[href=\"/test_cases\"]"));
		
		return new TestCasePage();
	}
	
	public ProductPage clickAllProduct() {
		myLibrary.clickButton(By.cssSelector("ul.nav.navbar-nav li a[href=\"/products\"]"));
		
		return new ProductPage();
	}
	
	public void scrollToFooter () {
		myLibrary.scrollToElement(By.id("footer"));
	}
	
	public void verifySubscription() {
		WebElement element = myLibrary.waitForElementToBeClickable(By.cssSelector("div.single-widget h2"));
		String string = element.getText().toLowerCase();
		assertTrue(string.contains("Subscription".toLowerCase()), string);		
	}
	
	public void enterSubsEmail(String email) {
		myLibrary.enterText(By.id("susbscribe_email"), email);
	}
	
	public void clickSubscribe() {
		myLibrary.clickButton(By.id("subscribe"));
	}
	public void verifySubscribedMessage() {
		WebElement element = myLibrary.waitForElementVisibility(By.cssSelector(".alert-success.alert"));
		String string = element.getText().toLowerCase();
		assertTrue(string.contains("You have been successfully subscribed!".toLowerCase()), "The subscription Message was not displayed");
	}
	
	public ProductDetailPage clickProdut(int indexOnList) {
		List<WebElement>  elements = driver.findElements(By.cssSelector("div.choose li a"));
		WebElement element = elements.get(indexOnList);
		
		executor.executeScript("arguments[0].click()", element); 
		return new ProductDetailPage();
	}
	
	public void AddToCart(int index) {
		List<WebElement> elements = driver.findElements(By.cssSelector("div.features_items .col-sm-4 .productinfo  a.add-to-cart"));
		WebElement element = elements.get(index);
		executor.executeScript("arguments[0].click()", element); 
		
	}
	
	public HomePage clickContinueShopping() {
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

	public void verifyCategoryOnSideBar() {
		WebElement element = driver.findElement(By.cssSelector(".category-products"));
		assertNotNull(element, "The category products is not visible");
	}
	 
	public CategoryAndBrandPage clickCategory(String MainCategory, String SubCategory) {
		myLibrary.clickFromListExactMatch(By.cssSelector(".panel-heading h4 a"), MainCategory);
		myLibrary.delay(5);
		myLibrary.clickFromListExactMatch(By.cssSelector("#accordian div ul li a"), SubCategory);
		
		return new CategoryAndBrandPage();
		
	}
	
	public void verifyBrandsOnSideBar() {
		WebElement element = driver.findElement(By.cssSelector(".brands_products"));
		assertNotNull(element, "The category products is not visible");
	}
	
	public CategoryAndBrandPage clickBrand(String Brand) {
		myLibrary.clickFromListContains(By.cssSelector(".brands-name li a"), Brand);
		
		return new CategoryAndBrandPage();
		
	}
	
	public void verifyRecommendedItems() {
		WebElement element = myLibrary.waitForElementVisibility(By.cssSelector(".recommended_items h2.title"));
		String string = element.getText().toLowerCase();
		assertTrue(string.equals("recommended items".toLowerCase()), "The subscription Message was not displayed");
	}
	
	public void AddRecommendedItemsToCart(int index) {
		List<WebElement> elements = driver.findElements(By.cssSelector(".recommended_items .item div.single-products a.add-to-cart"));
		WebElement element = elements.get(index);
		executor.executeScript("arguments[0].click()", element); 
	}
	
	public void scrollToButton() {
		myLibrary.scrollToElement(By.cssSelector(".footer-bottom"));
	}
	
	public void clickScrollUpButtonUsingArrow() {
		myLibrary.clickButton(By.cssSelector(".fa.fa-angle-up"));
	}
	
	public void clickScrollUpButtonWithoutArrow() {
		myLibrary.clickButton(By.id("slider"));
	}
	
	public void verifyFullFledgedText() {
		WebElement element = myLibrary.waitForElementVisibility(By.cssSelector(".col-sm-6 h2"));
		
		assertNotNull(element.getText().toLowerCase().trim()=="Full-Fledged practice website for Automation Engineers".toLowerCase().trim(), "The Fullfledged Text was not visible");
	}
	
}


