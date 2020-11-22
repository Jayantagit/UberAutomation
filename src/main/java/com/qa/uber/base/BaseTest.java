package com.qa.uber.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.uber.pages.HomePage;

public class BaseTest 
{
	public WebDriver driver;
	public Properties prop;
	public BasePage basePage;
	public HomePage homePage;
	

	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		homePage=new HomePage(driver);
		
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
