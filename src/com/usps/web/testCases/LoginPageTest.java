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
import com.usps.web.pages.LoginPage;

public class LoginPageTest extends BaseClass{
	
	@Parameters({"URL"})
	@BeforeClass(alwaysRun=true)
	public void openHomePage(String url) {
		driver.get(url);
		Reporter.log("=====Application Started=====", true);
	}
	
	 @Test
	 public void validateValidCredentials() {
		 HomePage homeObj = new HomePage(driver);
		 homeObj.clickSignIn();
		 LoginPage loginObj = new LoginPage(driver);
		 loginObj.clickLogin();
	 }
	 
}
