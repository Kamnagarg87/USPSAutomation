package com.usps.web.testCases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.usps.web.BaseClass;
import com.usps.web.pages.HomePage;
import com.usps.web.pages.QuickToolsFlyOut;
import com.usps.web.pages.TrackPackagePage;

public class TrackPackagePageTest extends BaseClass{
	
	@Parameters({"URL"})
	@BeforeClass(alwaysRun=true)
	public void openHomePage(String url) {
		driver.get(url);
		Reporter.log("=====Application Started=====", true);
	}
	
	@Test
	public void pageIsVisible() {
		HomePage homeObj = new HomePage(driver);
		homeObj.clickQuickTools();
		QuickToolsFlyOut quickToolFlyOutObj = new QuickToolsFlyOut(driver);
		quickToolFlyOutObj.clicktrackAPackage();
		TrackPackagePage trackPackagePageObj = new TrackPackagePage(driver);
		Assert.assertEquals(true, trackPackagePageObj.ifTrackingInputTextFieldIsAvailable());
	}
	
	
	@Test
	public void validateTrackingFieldEmptyError() {
		HomePage homeObj = new HomePage(driver);
		homeObj.clickQuickTools();
		QuickToolsFlyOut quickToolFlyOutObj = new QuickToolsFlyOut(driver);
		quickToolFlyOutObj.clicktrackAPackage();
		TrackPackagePage trackPackagePageObj = new TrackPackagePage(driver);
		trackPackagePageObj.clickOnTrackingButton();
		Assert.assertEquals(true, trackPackagePageObj.ifTrackingNumberMissingError());
	}
	

	@Test
	public void validateSampleTracingId() {
		HomePage homeObj = new HomePage(driver);
		homeObj.clickQuickTools();
		QuickToolsFlyOut quickToolFlyOutObj = new QuickToolsFlyOut(driver);
		quickToolFlyOutObj.clicktrackAPackage();
		TrackPackagePage trackPackagePageObj = new TrackPackagePage(driver);
		trackPackagePageObj.clickOnWhatDoesMyTrackingNoLookLike();
		Assert.assertEquals("9400 1000 0000 0000 0000 00", trackPackagePageObj.getSampleTrackingNumber());
	}
	
	@Test(dataProvider="getData")
	public void validateFindingPackage(String trackingId) {
		HomePage homeObj = new HomePage(driver);
		homeObj.clickQuickTools();
		QuickToolsFlyOut quickToolFlyOutObj = new QuickToolsFlyOut(driver);
		quickToolFlyOutObj.clicktrackAPackage();
		TrackPackagePage trackPackagePageObj = new TrackPackagePage(driver);
		trackPackagePageObj.ifTrackingInputTextFieldIsAvailable();
		trackPackagePageObj.addTrackingInput(trackingId);
		trackPackagePageObj.clickOnTrackingButton();
		Assert.assertEquals(true, trackPackagePageObj.ifTrackingStatusIsDisplayed());
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[3][1];
		data[0][0] = "9214490324478756964592";
		data[1][0] = "9214490324478756964593";
		data[2][0] = "9214490324478756964594";
		return data;
	}

}
