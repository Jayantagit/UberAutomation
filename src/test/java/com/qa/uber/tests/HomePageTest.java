package com.qa.uber.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.uber.base.BaseTest;
import com.qa.uber.pages.HomePage;
import com.qa.uber.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Epic - 100 : Home page features...")
@Feature("Uber - 101: home page title, location value...")
public class HomePageTest extends BaseTest
{
	@Description("verify Title Test on home page....")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String title = homePage.getHomePageTitle();
		System.out.println("Home page title is: "+ title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}
	
	@Description("verify Location Value Test on home page....")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=2)
	public void verifyLocationValueTest(){
		String location = homePage.getLocation();
		System.out.println("Location value is  : " + location);		
		Assert.assertNotNull(location);
	}

}
