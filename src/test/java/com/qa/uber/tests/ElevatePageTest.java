package com.qa.uber.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.uber.base.BaseTest;
import com.qa.uber.pages.ElevatePage;
import com.qa.uber.pages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Epic - 100 : Elevate features...")
@Feature("Uber - 101: Elevate popop Link value...")
public class ElevatePageTest extends BaseTest{
	
	ElevatePage elevatePage;
		
	@BeforeClass
	public void ElevateSetup()
	{
		elevatePage=homePage.goToElevatePage();		
	}
	
	
	@Description("verify Link Count Test on Elevate page popup....")
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=1)
	public void verifyLinkCount(){
		int linkcount = elevatePage.ElevatePopupLinkCount();
		System.out.println("ElevatePopup Link Count is: "+ linkcount);
		Assert.assertNotNull(linkcount);
	}
	
	
	
	

}
