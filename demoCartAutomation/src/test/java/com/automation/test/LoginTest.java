package com.automation.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.automation.pages.LoginPage;
import com.automation.utility.Helper;

public class LoginTest extends BaseTest {
	
	
	
	
	@Test
	public void loginTest() {
		
		LoginPage loginpage=PageFactory.initElements(driver, LoginPage.class);
		loginpage.loginDemoCart();
		Helper.captureScreenshot(driver);
		System.out.println(driver.getTitle());
	}
	
	

}
