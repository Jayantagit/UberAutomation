package com.qa.uber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.uber.base.BasePage;
import com.qa.uber.utils.Constants;
import com.qa.uber.utils.ElementUtil;
import com.qa.uber.utils.JavaScriptUtil;
import com.qa.uber.utils.TimeUtil;

public class HomePage extends BasePage
{
	private WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil jsUtil;
	
	//**********************Locators of UBER HomePage***************
	
	//By elevatorlnk=By.xpath("//div[@role='tablist']//a[@id='7']//span[text()='Elevate']");
	By elevatorlnk=By.xpath("//span[text()='Elevate']");
	By earnLink=By.xpath("//span[text()='Earn']");
	By locationLabel=By.id("location-banner-label");
	By signUpDriveLink=By.xpath("//a[text()='Sign up to drive']");
	
	
	public HomePage(WebDriver driver) 
	{
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
		jsUtil=new JavaScriptUtil(this.driver);
	}
	
	//**********************Page Actions of  HomePage***************
	
	public String getHomePageTitle(){
		return elementUtil.doGetPageTitleWithIsTitle(10, Constants.HOME_PAGE_TITLE);
	}
	
	public String getLocation()
	{
		jsUtil.scrollIntoView(elementUtil.getElement(locationLabel));
		if(elementUtil.doIsDisplayed(locationLabel))
			return elementUtil.doGetText(locationLabel);
		return null;		
		
	}
	
	public void clickOnElevate(){
		elementUtil.waitForElementPresent(signUpDriveLink, 30);
		elementUtil.waitForElementPresent(elevatorlnk, 30);
		TimeUtil.MediumWait();
		jsUtil.clickElementByJS(elementUtil.getElement(elevatorlnk));
		
		
			
	}

	
	public ElevatePage goToElevatePage(){
		clickOnElevate();
		return new ElevatePage(driver);
	}

	
	

}
