package com.automation.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.automation.pages.DemoProductsDisplayPage;

public class DemoProductsTest  extends BaseTest{

	
	
	@Test(enabled=true)
	public void  addNewProductTest() throws InterruptedException {
		
		DemoProductsDisplayPage productDisplay=PageFactory.initElements(driver, DemoProductsDisplayPage.class);
		productDisplay.clickAddNewProduct();
		Thread.sleep(5000);
		
	}
}
