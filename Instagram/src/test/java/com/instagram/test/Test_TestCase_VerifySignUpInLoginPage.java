package com.instagram.test;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.instagram.generic.BaseClass;
import com.instagram.generic.FrameWorkUtility;
import com.instagram.page.LoginPage;

public class Test_TestCase_VerifySignUpInLoginPage extends BaseClass {
	@Test
	public void testForgotPasswordLink() {
		String SignUpUrl=FrameWorkUtility.getXLData("./TestData/InstagramTestData.xlsx", "Link",3,1);
			LoginPage lp=new LoginPage(driver);
			lp.verifySignUpInLoginPageLink(driver, SignUpUrl);
			Reporter.log("sign up page opens by clicking Signup link",true);
}
}