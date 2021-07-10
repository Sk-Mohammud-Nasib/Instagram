package com.instagram.test;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.instagram.generic.BaseClass;
import com.instagram.generic.FrameWorkUtility;
import com.instagram.page.LoginPage;

public class Test_TestCase_LoginUsingFacebook extends BaseClass {
	@Test
	public void testLoginUsingFaceBook() {
		String facebookTitle=FrameWorkUtility.getXLData("./TestData/InstagramTestData.xlsx", "Link",1,1);
			LoginPage lp=new LoginPage(driver);
			lp.verifyLoginUsingFacebook(driver, facebookTitle);
			Reporter.log("Login By using facebook link opens facebook page",true);
		}

	}

