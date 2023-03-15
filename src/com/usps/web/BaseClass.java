package com.usps.web;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	protected WebDriver driver;
	
	@Parameters("browser")
	@BeforeClass(alwaysRun=true)
	public void setUpApplication(String browserType) {
		Reporter.log("=====Browser Session Started=====", true);
		if(browserType.equalsIgnoreCase("Firefox")){
			driver = new FirefoxDriver();
		}
		else if(browserType.equalsIgnoreCase("Chrome")){
		driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	 @AfterClass(alwaysRun=true)
		public void closeApplication()
		{
			driver.quit();
			Reporter.log("=====Browser Session End=====", true);
			
		}

	
}
