package com.automation.test;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.automation.pages.DemoCartDashboardPage;
import com.automation.pages.DemoCartLoginPage;

public class DemoHomeTest extends BaseTest {
	
	
	//DemoCartLoginPage launchpage = new DemoCartLoginPage(driver);
	
	@Test(enabled=false)
	public void tableTest() throws Exception {
		
		
		DemoCartLoginPage launchpage = PageFactory.initElements(driver, DemoCartLoginPage.class);
		
		launchpage.clickTable();
		List<WebElement> column=driver.findElements(By.xpath("//*[@id='table1']/thead/tr/th"));
		//System.out.print("No of table columns="+column.size());
		
		List<WebElement> rows=driver.findElements(By.xpath("//*[@id='table1']/tbody/tr"));
		//System.out.printl("No of table rows="+rows.size());
		
		
		for(int i=1;i<=rows.size();i++) {
			
			WebElement price=driver.findElement(By.xpath("//*[@id='table1']/tbody/tr["+i+"]/td[4]"));
			String amt=price.getText();
			String regex="[^0-9]";
			String [] amount=amt.split(regex);
			int am=Integer.parseInt(amount[1]);
			if(am>50) {
				WebElement name=driver.findElement(By.xpath("//*[@id='table1']/tbody/tr["+i+"]/td[2]"));
				System.out.println(name.getText());
			}
		}
		 
		//launchpage.login(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));

	}
	
	@Test(priority=0)
	public void demoCartLogin() throws Exception {
		
		
		
		DemoCartLoginPage launchpage = PageFactory.initElements(driver, DemoCartLoginPage.class);
		//login into Page
		launchpage.loginDemoCart();
		
		
		//Closing the Alert
		driver.findElement(By.xpath("//*[@class='btn-close']")).click();
		//driver.switchTo().alert().accept();
		
		System.out.println("The page Title is : "+driver.getTitle());
		
		
		/*
		 * //Navigate to order
		 * driver.findElement(By.xpath("//*[@id='menu-sale']")).click();
		 * driver.findElement(By.xpath("(//*[contains(@href,'order')])[1]")).click();
		 * 
		 * 
		 * //table //Total No Of pages in table String
		 * text=driver.findElement(By.xpath("//*[contains(text(),'Showing')]")).getText(
		 * ); String num=text.substring(text.indexOf("(")+1,text.indexOf("Pages")-1);
		 * //launchpage.login(excel.getStringData("Login", 0, 0),
		 * excel.getStringData("Login", 0, 1));
		 * System.out.println(Integer.valueOf(num));
		 */
	}
	
	
	@Test(priority=1,enabled=true)
	public void dashBoardTest() throws InterruptedException {
		
		DemoCartDashboardPage db= PageFactory.initElements(driver, DemoCartDashboardPage.class);
		db.clickDashboard();
		db.clickCatalog();
		db.clickProducts();
		db.clickAddNewProduct();
		
		// Adding Data into Products Specification 
		
		db.clickDataTab();
		db.enterDataEntries();
		Thread.sleep(2000);
		
	}
	
	
	


}
