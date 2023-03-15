package com.usps.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginPage {

	final WebDriver driver;

	// Constructor that will be automatically called as soon as the object of the
	// class is created
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(id="btn-submit")
	WebElement loginButton;


	public WebElement getUsername() {
		return username;
	}

	// Method to enter username
	public void enterUsername(String user) {
		username.sendKeys(user);
	}

	// Method to enter password
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}

	// Method to click on Login button
	public void clickLogin() {
		loginButton.click();
	}

	// Method to click on Login button
	public String getPageUrl() {
		return driver.getCurrentUrl();
	}
}
