package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoProductsDisplayPage extends BasePage{
	
	WebDriver driver;
	
	public DemoProductsDisplayPage(WebDriver ldriver) {
	driver=ldriver;
	PageFactory.initElements(driver, this);
	}

	////table/tbody/tr/td[7]//a[@aria-label='Edit']
@FindBy(xpath="//*[@aria-label='Add New']")
WebElement addNew;


public void clickAddNewProduct() {
	
	addNew.click();
	System.out.println("Hello");
}


}
