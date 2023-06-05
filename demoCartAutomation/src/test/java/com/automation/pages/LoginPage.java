package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	
	WebDriver driver;
	public LoginPage(WebDriver ldriver) {
		this.driver=ldriver;
	}
	
	///WebLocaters
	@FindBy(xpath="//*[@class='login']")
	WebElement signInLink;
	
	@FindBy(id="email") 
	WebElement emailAddress;
	
	@FindBy(name="passwd")
	WebElement pwdField;
	
	
	@FindBy(id="SubmitLogin")
	WebElement signInButton;
	
	@FindBy(xpath="//a[contains(@href,'abtest')]")
	WebElement linkABTEST;
	
	@FindBy(xpath="//*[contains(text(),'Add')]")
	WebElement linkAddRemove;
	
	@FindBy(linkText = "Basic Auth")
	WebElement linkBasicAuth;
	
	@FindBy(xpath = "//*[contains(text(),'table')]")
	WebElement linkTable;
	
	@FindBy(xpath = "//*[@id='input-username']")
	WebElement demoCartusername;
	
	@FindBy(xpath = "//*[@id='input-password']")
	WebElement demoCartpassword;
	
	@FindBy(xpath = "//*[@type='submit']")
	WebElement demoCartLogin;
	
	
	public void loginDemoCart() {
		String email= "demo";
		String password="demo";
		//demoCartusername.click();
		demoCartusername.sendKeys(email);
		demoCartpassword.sendKeys(password);
		demoCartLogin.click();
			
		}
	
}
