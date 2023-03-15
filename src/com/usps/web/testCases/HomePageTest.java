package com.usps.web.testCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.usps.web.BaseClass;
import com.usps.web.pages.HomePage;
import com.usps.web.pages.QuickToolsFlyOut;

public class HomePageTest extends BaseClass{
	
	@Parameters({"URL"})
	@BeforeClass(alwaysRun=true)
	public void openHomePage(String url) {
		driver.get(url);
		Reporter.log("=====Application Started=====", true);
	}

	
	 @Test(groups = {"Smoke"})
	 public void validateLoginIsDisplayed() {
		 HomePage homeObj = new HomePage(driver);
		 Assert.assertEquals(true, homeObj.getSignInButton().isDisplayed());
	 }
	 
	 @Test(groups = {"Smoke"})
	 public void validateQuickToolsExist() {
		 HomePage homeObj = new HomePage(driver);
		 Assert.assertEquals(true, homeObj.getQuickToolsLink().isDisplayed());
	 }
	 
	 @Test
	 public void validateTrackApackageExist() {
		 HomePage homeObj = new HomePage(driver);
		 homeObj.clickQuickTools();
		 QuickToolsFlyOut quickToolFlyOutObj = new QuickToolsFlyOut(driver);
		 Assert.assertEquals(true, quickToolFlyOutObj.getTrackAPackage().isDisplayed());
	 }
	 
	 
	 
}
