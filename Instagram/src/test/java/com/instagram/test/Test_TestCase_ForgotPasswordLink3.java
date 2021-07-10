package com.instagram.test;

import org.testng.Reporter;
import org.testng.annotations.Test;
import com.instagram.generic.BaseClass;
import com.instagram.generic.FrameWorkUtility;
import com.instagram.page.LoginPage;

public class Test_TestCase_ForgotPasswordLink3 extends BaseClass {
	@Test
	public void testForgotPasswordLink() {
		String forgotPasswordTitle=FrameWorkUtility.getXLData("./TestData/InstagramTestData.xlsx", "Link",2,1);
			LoginPage lp=new LoginPage(driver);
			lp.verifyForgotPasswordLink(driver, forgotPasswordTitle);
			Reporter.log("forgot password page opens by clicking forgot password link",true);
}
}