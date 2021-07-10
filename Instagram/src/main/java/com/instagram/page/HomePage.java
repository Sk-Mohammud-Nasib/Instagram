package com.instagram.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePage {
	@FindBy(xpath="//span[contains(@class,'dbep qNELH')]")
	public WebElement profile;
	@FindBy(xpath="//div[contains(.,'Log Out') and contains(@class,'xLCgt')][1]")
	public WebElement logout;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);

	}

	public void clickProfile() {
		profile.click();
		Reporter.log("Clicked on profile");
	}
	public void clickLogout() {
		logout.click();
		Reporter.log("Clicked on Logout");
	}
}

