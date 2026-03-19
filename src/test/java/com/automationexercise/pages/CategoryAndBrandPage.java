package com.automationexercise.pages;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automationexercise.library.Base;

public class CategoryAndBrandPage extends Base{
	
	public void verifyCategoryPage() {
		String strUrl = driver.getCurrentUrl();
		assertTrue(strUrl.contains("category_products"));
	}
	
	public void verifyBrandPage() {
		String strUrl = driver.getCurrentUrl();
		assertTrue(strUrl.contains("brand_products"));
	}
	
	public void checkTitleOfCategoryAndBrandPage(String MainCategory, String SubCategory) {
		WebElement element = driver.findElement(By.xpath("/html/body/section/div/div[2]/div[2]/div/h2"));
		String text = element.getText().toLowerCase().trim();
		assertTrue(text.contains(MainCategory.toLowerCase()), "The title doesn't contains "+ MainCategory);
		assertTrue(text.contains(SubCategory.toLowerCase()), "The title doesn't contains "+ SubCategory);
		
				
	}
	
	public void CheckProductsAreVisible() {
		WebElement element = myLibrary.waitForElementVisibility(By.cssSelector(".features_items div.col-sm-4"));
		assertNotNull(element, "There are no products visible on Category or Brad Page");
	}
	
}
