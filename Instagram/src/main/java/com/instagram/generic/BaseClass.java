package com.instagram.generic;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.google.common.io.Files;

public class BaseClass {
public WebDriver driver;
public static int pass,fail;
@BeforeTest
public void setPro() {
	System.setProperty("webdriver.gecko.driver", "./driver executable/geckodriver.exe");
	System.setProperty("webdriver.chrome.driver", "./driver executable/chromedriver.exe");
	
}
@BeforeMethod
public void openApp() throws Throwable{
	driver=new ChromeDriver();
	Reporter.log("ChromeDriver is lunched",true);
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://www.instagram.com/");
	Reporter.log("Website is opened",true);
}
@AfterMethod
public void closeApp(ITestResult result) throws IOException {
	if(result.getStatus()==2) {
	fail++;
	String name=result.getName();
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	File dst= new File("./ScreenShot/"+name+".png");
	Files.copy(src,dst);
	}
	driver.close();
}
}
