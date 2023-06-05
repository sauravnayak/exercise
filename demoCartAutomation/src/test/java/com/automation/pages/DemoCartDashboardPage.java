package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DemoCartDashboardPage extends BasePage {
	
	WebDriver driver;
	public DemoCartDashboardPage(WebDriver ldriver) {
		driver=ldriver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath="//*[text()='Logout']")
	WebElement logout;
	
	@FindBy(xpath = "//*[@id='menu-dashboard']")
	WebElement Dashboard;
	
	@FindBy(className = "btn-close")
	WebElement close;
	
	
	@FindBy(xpath = "//*[@id='menu-catalog']")
	WebElement Catalog;
	
	@FindBy(xpath = "//*[text()='Products']")
	WebElement products;
	
	@FindBy(xpath="//*[@aria-label='Add New']")
	WebElement addNew;

	
	@FindBy(xpath="//*[text()='Data']")
	WebElement dataTab;
	
	@FindBy(id="input-model")
	WebElement textModel;
	
	@FindBy(id="input-sku")
	WebElement textSKU;
	
	@FindBy(id="input-upc")
	WebElement textUPC;
	
	@FindBy(id="input-ean")
	WebElement textEAN;
	
	@FindBy(id="input-jan")
	WebElement textJAN;
	
	@FindBy(id="input-isbn")
	WebElement textISBN;
	
	@FindBy(id="input-mpn")
	WebElement textMPN;
	
	
	@FindBy(id="input-location")
	WebElement textLocation;
	
	
	@FindBy(id="input-price")
	WebElement textPrice;
	
	@FindBy(id="input-tax-class")
	WebElement dropdownTaxCategory;
	
	@FindBy(id="input-quantity")
	WebElement textQuantity;
	
	@FindBy(id="input-quantity")
	WebElement textMinQuantity;
	
	@FindBy(xpath="//input[@name='subtract']")
	WebElement toggleSubtract;
	
	@FindBy(id="input-stock-status")
	WebElement dropdownOOS;
	
	@FindBy(xpath="//input[@name='date_available']")
	WebElement datePicker;
	
	@FindBy(xpath="(//*[@class='input-group-text'])[1]")
	WebElement datePickere;
	
	
	
	
	public void logout() {
		logout.click();

	}
	
	public void clickDashboard() {
		Dashboard.click();
		close.click();

	}
	public void clickCatalog() {
		Catalog.click();
	}
	
	public void clickProducts() {
		products.click();
	}
	
	public void clickAddNewProduct() {
		
		addNew.click();
		//System.out.println("Hello");
	}
	public void clickDataTab() {
		
		dataTab.click();
		//System.out.println("Hello");
	}
	
	public void enterDataEntries() throws InterruptedException {
		
		textModel.sendKeys("Iphone 11");
		textSKU.sendKeys("Sku1234");
		textUPC.sendKeys("1234");
		
		textEAN.sendKeys("EU1234");
		textJAN.sendKeys("J1234");
		textISBN.sendKeys("ISB1234");
		textMPN.sendKeys("M1234");
		textLocation.sendKeys("India");
		textPrice.sendKeys("101.11");
		Select taxselector=new Select(dropdownTaxCategory);
		
		taxselector.selectByVisibleText("Taxable Goods");
		textQuantity.sendKeys("10");
		textMinQuantity.sendKeys("2");
		
		// Selecting OOS option 
		
		Select oosSelection= new Select(dropdownOOS);
		oosSelection.selectByVisibleText("In Stock");
		
		//Date Picker Selection
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", datePicker);
		//datePickere.click();
		//datePicker.sendKeys("2010-10-11");
		
		
		String month="Mar 2024";
		String date="20";
		boolean flag=true;
		while(flag) {
			
			WebElement months=driver.findElement(By.xpath("//table[@class='table-condensed']/thead/tr/th[@class='month']"));
			String text=months.getText();
			if(text.contains(month)) {
				WebElement datexpath=driver.findElement(By.xpath("//table[@class='table-condensed']/tbody/tr/td[contains(text(),'14')]"));
				//WebElement datexpath=driver.findElement(By.xpath("//table[@class='table-condensed']/tbody/tr/td[contains(text(),'"+date+ "')]"));
				js.executeScript("arguments[0].click();", datexpath);
				//driver.findElement(By.xpath("//table[@class='table-condensed']/tbody/tr/td[contains(text(),'"+date+ "')]")).click();
				break;
			}
			else {
				WebElement nextbutt=driver.findElement(By.xpath("//table[@class='table-condensed']/thead/tr/th[@class='next available']"));
				js.executeScript("arguments[0].click();", nextbutt);
				//driver.findElement(By.xpath("//table[@class='table-condensed']/thead/tr/th[@class='next available']")).click();
			}
		}
		Thread.sleep(5000);
		driver.findElement(By.id("input-length")).sendKeys("1234");
		//Selecting Date  (//table[@class='table-condensed']/tbody/tr/td[contains(text(),'21')])[1]
		//table Month //table[@class='table-condensed']/thead/tr/th[@class='month']
		//Next month //table[@class='table-condensed']/thead/tr/th[@class='next available']
	}
	
	
	
	
}
