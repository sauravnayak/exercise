package com.automation.test;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.automation.utility.BrowserFactory;
import com.automation.utility.ConfigReader;
import com.automation.utility.ExcelDataProvider;
import com.automation.utility.Helper;

public class BaseTest {
	
	public WebDriver driver;
	
	public ExcelDataProvider excel;
	public ConfigReader config;
	
	
	@BeforeSuite
	public void setSuite() {
		excel=new ExcelDataProvider();
		config= new ConfigReader();

	}
	
	@BeforeClass
	public void setup() {
		driver=BrowserFactory.startApplication(config.getBrowser(), config.getURL(),driver);

	} 
	
	@AfterClass
	public void tearDown() {
		BrowserFactory.quitApplication(driver);

	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			Helper.captureScreenshot(driver);
		}

	}
	
	

}
