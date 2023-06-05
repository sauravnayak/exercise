package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver ldriver) {
		this.driver=ldriver;
		
	}
	
	//By abtest =By.xpath("//a[contains(@href,'abtest')]");
			
			
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
	
	@FindBy(linkText = "Checkboxes")
	WebElement linkCheckboxes;
	
	@FindBy(partialLinkText = "Drag")
	WebElement linkDragandDrop;
	
	
	@FindBy(partialLinkText = "Context")
	WebElement linkContextMenu;
	
	@FindBy(linkText = "//*[contains(text(),'Add Element')]")
	WebElement buttonAddElement;
	
	
	
	public void login(String email, String password) {
		
		signInLink.click();
		emailAddress.sendKeys(email);
		pwdField.sendKeys(password);
		signInButton.click();

	}
	
	public void clickABTest()
	
	{
		linkABTEST.click();
		
	}
	
public void clickAddRemove()
	
	{
		linkAddRemove.click();
		
	}

	public void clickAddElement()
	
	{
		buttonAddElement.click();
	}
	
	public void clickCheckboxes()
	
	{
		linkCheckboxes.click();
	}
	
	public void clickContextmenu()
	
	{
	linkContextMenu.click();
	}
	
	public void clickDragDrop()
	
	{
	linkDragandDrop.click();
	}
	
	
	
	

}
