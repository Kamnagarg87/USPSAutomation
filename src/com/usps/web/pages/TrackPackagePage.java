package com.usps.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrackPackagePage {

	final WebDriver driver;

	public TrackPackagePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="tracking-input")
	WebElement trackingInputTextBox;
	
	@FindBy(className="tracking-btn")
	WebElement trackingButton;
	
	@FindBy(xpath="//li[text()='Please enter a tracking number.']")
	WebElement trackingNumberMissingError;
	
	@FindBy(className="tb-status")
	WebElement trackingStatus;
	
	@FindBy(id= "headingOneAnchor")
	WebElement trackingNumberLookLikeLink;
	
	@FindBy(xpath="//span[text()='USPS Tracking']//following-sibling::span")
	WebElement uspsSampleTrackingNumber;
	
	public boolean ifTrackingInputTextFieldIsAvailable() {
		if(trackingInputTextBox.isDisplayed())
			return true;
	 return false;
	}
	
	public void clickOnTrackingButton() {
		trackingButton.click();
	}
	
	public String getSampleTrackingNumber() {
		return uspsSampleTrackingNumber.getText();
	}
	
	public void clickOnWhatDoesMyTrackingNoLookLike() {
		trackingNumberLookLikeLink.click();
	}
	
	public boolean ifTrackingNumberMissingError() {
		if(trackingNumberMissingError.isDisplayed())
			return true;
	 return false;
	}
	
	public boolean ifTrackingStatusIsDisplayed() {
		if(trackingStatus.isDisplayed())
			return true;
	 return false;
	}
	
	public void addTrackingInput(String trackingId) {
		trackingInputTextBox.clear();
		trackingInputTextBox.sendKeys(trackingId);
	}
}
