package com.instagram.test;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.instagram.generic.BaseClass;
import com.instagram.generic.FrameWorkUtility;
import com.instagram.page.HomePage;
import com.instagram.page.LoginPage;

public class Test_TestCase_Valid_Login extends BaseClass  {
	@Test
	public void test_Valid_Login() throws Throwable {
		int size=FrameWorkUtility.getLastRowNumberInExcel("./TestData/InstagramTestData.xlsx", "ValidLogin");
		for (int i=1;i<=size;i++) {
		String username=FrameWorkUtility.getXLData("./TestData/InstagramTestData.xlsx", "ValidLogin",i,0);
		String password=FrameWorkUtility.getXLData("./TestData/InstagramTestData.xlsx", "ValidLogin",i,1);
		LoginPage lpage=new LoginPage(driver);
		lpage.setUsername(username);
		Reporter.log(i+"-"+"The valid username  "+username+  "is entered",true);
		lpage.setPassword(password);
		Reporter.log("  The valid password "+password+  "is entered",true);
		lpage.clickLoginButton();
		Reporter.log("Clicked on login",true);
		lpage.verifySuccessfulLoginAndHomePageDisplayed();
		Reporter.log("   Successfully logged in",true);
		HomePage hpage=new HomePage(driver);
		hpage.clickProfile();
		Thread.sleep(2000);
		hpage.clickLogout();
	}
	}
	

}
