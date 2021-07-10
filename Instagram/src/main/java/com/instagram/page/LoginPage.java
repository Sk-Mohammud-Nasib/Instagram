package com.instagram.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import com.instagram.generic.FrameWorkUtility;

public class LoginPage {



	@FindBy(xpath="//input[@name='username']")
	public WebElement usernameTextBox;

	@FindBy(xpath= "//input[@name='password']")
	public WebElement passwordTextBox;

	@FindBy(xpath="//button/div[contains(.,'Log In')]")
	public WebElement loginButton;

	@FindBy(xpath="//a[.='Forgot password?']")
	public WebElement forgotPassword;

	@FindBy(xpath="//span[.='Sign up']")
	public WebElement signUp;

	@FindBy(xpath="//p[@role='alert']")
	public WebElement errorMsg;

	@FindBy(xpath="//div[@class='ctQZg']")
	public WebElement allHomepageOptions;
	
	@FindBy(xpath="//span[contains(.,'Log in with Facebook')]")
	public WebElement loginUsingFacebookLink;

	

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);

	}

	public void setUsername(String username) {
		usernameTextBox.sendKeys(username);
		
	}

	public void setPassword(String password) {
		passwordTextBox.sendKeys(password);
	}

	public void clickLoginButton() {
		loginButton.click();
	}

public void verifyLoginUsingFacebook(WebDriver driver, String expectedTitle) {
	loginUsingFacebookLink.click();
	Assert.assertEquals(driver.getTitle(),expectedTitle);
}
public void verifyForgotPasswordLink(WebDriver driver, String expectedTitle ) {
	forgotPassword.click();
	FrameWorkUtility.WaitForTitle(driver, expectedTitle);
	Assert.assertEquals(driver.getTitle(),expectedTitle);
}
public void verifySignUpInLoginPageLink(WebDriver driver, String expextedUrl) {
	signUp.click();
	String str=driver.getCurrentUrl();
	Assert.assertEquals(str,expextedUrl);
}
	public void verifySuccessfulLoginAndHomePageDisplayed() {
		Assert.assertTrue(allHomepageOptions.isDisplayed());

	}




	public void VerifyErrorMsg(WebDriver driver,String errorMessage ) {

		FrameWorkUtility.verifyMSG(errorMsg.getText(), errorMessage);

	}

	public void waitForLoginButtonToClickable(WebDriver driver) {
		WebDriverWait wait =new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(loginButton));
	}
	
}
