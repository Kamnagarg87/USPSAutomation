package com.usps.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	final WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login-register-header")
	WebElement signInButton;
	
	@FindBy(className="nav-first-element")
	WebElement quickToolsLink;
	
	

	public WebElement getSignInButton() {
		return signInButton;
	}

	// Method to click login button
	public void clickSignIn() {
		signInButton.click();
	}

	public WebElement getQuickToolsLink() {
		return quickToolsLink;
	}
	
	
	public void clickQuickTools() {
		quickToolsLink.click();
	}
	
}
