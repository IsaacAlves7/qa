package com.automationexercise.library;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

// Use selenium library 4.14.x or later Version

public class GlobalSelenium {
	
	public static final Logger logger = LogManager.getLogger(GlobalSelenium.class);
	
	private WebDriver driver;
	private int waitTimeInSeconds = 30;
	private boolean isHeadless = false;
	private boolean isDemo = false;
	
	public enum Browsers {
		CHROME, FIREFOX, SAFARI, EDGE
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebDriver startChromeBrowser() {
		logger.info("Starting Chrome browser... ");
		ChromeOptions chromeOptions = new ChromeOptions();
		if (isHeadless) {
			logger.info("Chrome Browser is running in headless mode. ");
			chromeOptions.addArguments("--headless");
			chromeOptions.addArguments("--window-size=1400,800");
		}
		chromeOptions.addArguments("--start-maximized");
		driver = new ChromeDriver(chromeOptions);
		return driver;
	}

	public void highlightElement(WebElement element) {
		try {
			if (isDemo) {
				WrapsDriver wrappedElement = (WrapsDriver) element;
				JavascriptExecutor js = (JavascriptExecutor) wrappedElement.getWrappedDriver();

				for (int i = 1; i < 4; i++) {
					js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
							"color: red; border: 2px solid yellow");
					delay(0.5);
					js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
					delay(0.5);
				}
			}
		} catch (Exception e) {
			logger.error("Error: ", e);
		}
	}

	public void delay(double inSeconds) {
		try {
			// Changing Double to Long to get millisecond
			long miliSecond = (long) (inSeconds * 1000);
			Thread.sleep(miliSecond);
			logger.info("Waiting for 30 Seconds.. ");
		} catch (Exception e) {
			logger.error("Error: ", e);
		}
	}

	public void synchronize() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

	}

	public void enterText(By by, String inputString) {
		WebElement element = driver.findElement(by);
		element.clear();
		element.sendKeys(inputString);
		logger.info("Sending Text to :"+ by.toString()+ " and text is: "+ inputString);

	}

	public void selectDropDown(By by, String inputText) {
		WebElement element = driver.findElement(by);
		Select dropdownElement = new Select(element);
		dropdownElement.selectByVisibleText(inputText);
		logger.info("Selecting: "+ inputText);
	}

	public void clickButton(By by) {
		WebElement element = driver.findElement(by);
		logger.info("Clicking button: "+ element.getText());
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", element); 

	}
	
	public void uploadFile(By by, String filePath) {
		File uploadFile= new File(filePath);
		WebElement fileInput = driver.findElement(by);
	    fileInput.sendKeys(uploadFile.getAbsolutePath());
	    logger.info("Uploading file form: "+ filePath);
		
	}
	
	public WebElement waitForElementVisibility (By by) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeInSeconds));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		highlightElement(element);
		logger.info("Confirming Visibility of Element: "+ element.getText());
		
		return element;
	}
	
	public WebElement waitForElementToBeClickable (By by) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeInSeconds));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
		highlightElement(element);
		logger.info("Verify Element Clickable: "+ element.getText());
		
		return element;
	}
	
	public void switchToAlert() {
		driver.switchTo().alert();
		logger.info("Switching to Alert");
	}
	
	
	public void acceptAlert() {
		driver.switchTo().alert().accept();
		logger.info("Accepting to Alert");
	}
	
	
	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
		logger.info("Dismissing to Alert");
	}
	
	public boolean checkCurrentUrl(String containsString) {
		String url = driver.getCurrentUrl();
		boolean value = url.contains(containsString);
		logger.info("Checking current url: \""+url+"\" contains: "+containsString);
		return value;
	}
	
	public boolean checkSearchResults(By by, String string) {
		List<WebElement> elementName =	 driver.findElements(by);
		logger.info("Verifying Search Result for: " + string);
		int n = elementName.size();
		boolean value = false;
		if (n>0) {
			for (int i = 0; i < elementName.size(); i++) {
				String element = elementName.get(i).getText().toLowerCase();
				String string1 = string.toLowerCase();
		        if (element.contains(string1)) {
		        	value = true;
		            break;
		        }
		    }
		}
		return value;
		
	}
	
	
	public void scrollByXY(int x, int y) {
		logger.info("Scrolling by X: " + x +" and Y: "+y);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String string = "window.scrollBy(" + x + ","+ y +")";
		js.executeScript(string, "");
	}
	
	
	public void scrollToElement(By by) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(by);
		logger.info("Scrolling by Element: "+ by.toString());
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public void hoverOver(By by) {
		WebElement element = driver.findElement(by);
		logger.info("Hovering over Element: "+ by.toString());
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public boolean checkVisibility(By by) {
		
		try {
			WebElement element = driver.findElement(by);
			logger.info("Checking Visibility of Element: " + by.toString());
			if (element != null) {
				return true;
			}
			else {
				return false;
			}
		    
		  }
		catch (org.openqa.selenium.NoSuchElementException e) {
		    return false;
		  }	
	}
	public void clickFromListExactMatch(By by, String exactMatchString) {
		logger.info("Checking from list Exact Match of: " + exactMatchString);
		List<WebElement> elementList =	 driver.findElements(by);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (WebElement e : elementList) {
			if (e.getText().toLowerCase().trim().equals(exactMatchString.toLowerCase().trim())) {
				js.executeScript("arguments[0].scrollIntoView();", e);
				js.executeScript("arguments[0].click();", e);
				break;
			}
		}
	}
	
	public void clickFromListContains(By by, String containsString) {
		logger.info("Checking from list contains of: " + containsString);
		List<WebElement> elementList =	 driver.findElements(by);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (WebElement e : elementList) {
			if (e.getText().toLowerCase().trim().contains(containsString.toLowerCase().trim())) {
				js.executeScript("arguments[0].scrollIntoView();", e);
				js.executeScript("arguments[0].click();", e);
				break;
			}
		}
	}
	
	 public boolean isFileAvailable(String downloadLocation, String expectedFileName){
		logger.info("Checking file form folder: "+ downloadLocation+
				" And verifing the folder contains expected file: "+expectedFileName);
        File folder = new File(downloadLocation);
        File[] listOfFiles = folder.listFiles();
        boolean isFileAvailable = false;
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                if (fileName.matches(expectedFileName)) {
                    isFileAvailable = true;
                    listOfFile.delete();
                }
            }
        }
        return isFileAvailable;
    }

}
