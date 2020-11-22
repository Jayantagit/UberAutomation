package com.qa.uber.utils;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
		} catch (Exception e) {
			System.out.println("element could not be created..." + locator);
		}

		return element;
	}
	
	public void doClick(By locator){
		getElement(locator).click();
	}
	
	public void doSendKeys(By locator, String value){
		getElement(locator).sendKeys(value);
	}
	
	public String doGetText(By locator){
		return getElement(locator).getText();
	}
	
	public boolean doIsDisplayed(By locator){
		return getElement(locator).isDisplayed();
	}
	
	
	//**********************Actions Methods ********************
	public void doActionsClick(By locator){
		Actions ac = new Actions(driver);
		ac.moveToElement(getElement(locator)).click(getElement(locator)).build().perform();
	}
	
	public void doActionsSendKeys(By locator, String value){
		Actions ac = new Actions(driver);
		ac.sendKeys(getElement(locator), value).perform();
	}
	

	//************************Switch Frame***********
	
	public void doSwitchFrameByID(String frameid){
		driver.switchTo().frame(frameid);
		
	}
	
	//***************************wait utils ******************************
	
	public String doGetPageTitleWithIsTitle(int timeOut, String title) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.titleIs(title));
		return driver.getTitle();
	}
	
	public String doGetPageCurrentUrl(int timeOut, String urlValue) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.urlContains(urlValue));
		return  driver.getCurrentUrl();
	}
	
	public WebElement waitForElementPresent(By locator, int timeOut){
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public WebElement waitForElementToBeClickable(By locator, int timeOut){
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public WebElement waitForElementToBeVisible(By locator, int timeOut){
		WebElement element = getElement(locator);
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public List<WebElement> visibilityOfAllElements(By locator, int timeOut){
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	public void clickWhenReady(By locator, int timeOut){
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}
	
		
		
	public boolean isElementDisplayed(By locator, int timeout) {
		WebElement element = null;
		boolean flag = false;
		for (int i = 0; i < timeout; i++) {

			try {
				element = driver.findElement(locator);
				flag = element.isDisplayed();
				break;
			} catch (Exception e) {
				System.out.println("waiting for element to be present on the page -->" + i + "secs");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
				}
			}

		}
		return flag;

	}
}	
	
	
