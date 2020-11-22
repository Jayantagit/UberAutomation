package com.qa.uber.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.uber.base.BasePage;
import com.qa.uber.utils.ElementUtil;
import com.qa.uber.utils.JavaScriptUtil;

public class ElevatePage extends BasePage
{
	
	private WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil jsUtil;
	
	//**********************Locators of UBER ElevatePage***************
	
	By elevatorpopuplinkList=By.xpath("//div[contains(@class,'tab-content la ev bq br eo lb lc ld le f2 lf lg jp lh li jr ')]//div/a");
		
	
	public ElevatePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
		jsUtil=new JavaScriptUtil(this.driver);
	}
	
	//**********************Page Actions of  ElevatePage***************
	public int  ElevatePopupLinkCount() {
		
		List<WebElement> linkCount=elementUtil.visibilityOfAllElements(elevatorpopuplinkList, 30);
		linkCount.forEach(linkVal->System.out.println(linkVal.getText()));
		return linkCount.size();
		
	}


	
}
