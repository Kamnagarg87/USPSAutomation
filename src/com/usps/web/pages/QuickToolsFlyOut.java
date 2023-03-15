package com.usps.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuickToolsFlyOut {
	
	final WebDriver driver;

	public QuickToolsFlyOut(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Track a Package")
	WebElement trackAPackage;
	
	public WebElement getTrackAPackage() {
		return trackAPackage;
	}

	public void clicktrackAPackage() {
		trackAPackage.click();
	}

}
