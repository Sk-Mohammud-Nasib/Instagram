package com.instagram.test;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.instagram.generic.BaseClass;
import com.instagram.generic.FrameWorkUtility;
import com.instagram.page.LoginPage;

public class Test_TestCase_Invalid_Login extends BaseClass {
	@Test
	public void test_Invalid_Login() {
		int size=FrameWorkUtility.getLastRowNumberInExcel("./TestData/InstagramTestData.xlsx", "InvalidLogin");
		for(int i=1;i<=size;i++) {

			String invalidUsername=FrameWorkUtility.getXLData("./TestData/InstagramTestData.xlsx", "InvalidLogin",i,0);
			String invalidPassword=FrameWorkUtility.getXLData("./TestData/InstagramTestData.xlsx", "InvalidLogin",i,1);
			LoginPage lpage=new LoginPage(driver);
			lpage.setUsername(invalidUsername);
			Reporter.log(i+"-"+"The invalid username "+invalidUsername+  " entered",true);
			lpage.setPassword(invalidPassword);
			Reporter.log("  The invalid password "+invalidPassword+  " entered",true);
			lpage.waitForLoginButtonToClickable(driver);
			lpage.clickLoginButton();
			Reporter.log("  clicked on login button");
			String expectedMsg=FrameWorkUtility.getXLData("./TestData/InstagramTestData.xlsx", "InvalidLogin",i,2);
			lpage.VerifyErrorMsg(driver, expectedMsg);
			Reporter.log("  The Expected Message displayed",true);
			driver.navigate().refresh();
		}
	}}
