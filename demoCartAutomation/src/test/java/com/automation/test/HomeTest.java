package com.automation.test;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.pages.HomePage;

public class HomeTest extends BaseTest {

	@Test(enabled = false, priority = 0)
	public void launchTest() throws Exception {

		HomePage launchpage = PageFactory.initElements(driver, HomePage.class);
		String title = driver.getTitle();
		String expectedTitle = "The Internet";
		launchpage.clickABTest();
		driver.navigate().back();
		Thread.sleep(5000);
		Assert.assertEquals(title, expectedTitle);

		// launchpage.login(excel.getStringData("Login", 0, 0),
		// excel.getStringData("Login", 0, 1));

	}

	@Test(priority = 1,enabled = false)
	public void addRemoveElement() throws Exception {

		HomePage launchpage = PageFactory.initElements(driver, HomePage.class);

		launchpage.clickAddRemove();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement addbutton = wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//*[contains(text(),'Add Element')]"))));
		// ExternalWaitClick(driver.findElement(By.xpath("//*[contains(text(),'Add
		// Element')]")), driver);

		int frequency = 15;
		for (int i = 0; i < frequency; i++) {
			addbutton.click();
		}
		List<WebElement> DeleteButtonList = driver.findElements(By.xpath("//*[@id='elements']//button"));

		for (int i = frequency - 1; i > 0; i--) {
			try {
				DeleteButtonList.get(i).click();
				// Thread.sleep(2000);
			} catch (StaleElementReferenceException e) {
				WebElement el = driver.findElement(By.xpath("//*[@id='elements']//button"));
				el.click();
				// Thread.sleep(2000);
			}
			driver.navigate().back();
		}

	}
	
	@Test(enabled = false, priority =3)
	public void checkBox() throws Exception {

		HomePage launchpage = PageFactory.initElements(driver, HomePage.class);
		launchpage.clickCheckboxes();
		
		WebElement checkbox2=driver.findElement(By.xpath("(//*[@id='checkboxes']/input)[2]"));
		WebElement checkbox1=driver.findElement(By.xpath("(//*[@id='checkboxes']/input)[1]"));
		System.out.println(checkbox2.isSelected());
		checkbox1.click();
		System.out.println(checkbox1.isSelected());
		driver.navigate().back();
		
		Thread.sleep(2000);
		
	}
	
	@Test(enabled = false, priority =3)
	public void contextMenu() throws Exception {

		HomePage launchpage = PageFactory.initElements(driver, HomePage.class);
		launchpage.clickContextmenu();
		
		Actions act=new Actions(driver);
		//act.moveToElement(driver.findElement(By.xpath("//*[@id='hot-spot']")));
		act.contextClick(driver.findElement(By.xpath("//*[@id='hot-spot']")))		
		.build()
		.perform();
		driver.switchTo().alert().accept();
		
		//act.sendKeys(Keys.ESCAPE);
		//act.perform();
		
	driver.navigate().back();
		Thread.sleep(5000);
		
	}
	
	@Test(enabled = true, priority =3)
	public void dragAndDrop() throws Exception {

		HomePage launchpage = PageFactory.initElements(driver, HomePage.class);
		launchpage.clickDragDrop();
		
	
		Thread.sleep(5000);
		
	}

}
