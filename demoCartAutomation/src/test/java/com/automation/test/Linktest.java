package com.automation.test;


import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.naming.MalformedLinkException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.pages.HomePage;

public class Linktest extends BaseTest {
	
	
	@Test
	public void launchTest() throws Exception {
		
		
		HomePage launchpage = PageFactory.initElements(driver, HomePage.class);
		List<WebElement> l=driver.findElements(By.tagName("a"));
		String homepage="http://the-internet.herokuapp.com";
		System.out.println(l.size());
		HttpURLConnection huc;
		String url="";
		int respCode=200;
		for(int i=1;i<l.size();i++) {
			url=l.get(i).getAttribute("href");
			System.out.println(url);
			if(url==null ||url.isEmpty() ) {
				System.out.println("URL tag is not properly set");
			}
			if(!url.startsWith(homepage)) {
				System.out.println("URL Does not belong to same domain");
			}
			try {
				
				huc= (HttpURLConnection)(new URL(url).openConnection());
				huc.setRequestMethod("HEAD");
				huc.connect();
				respCode=huc.getResponseCode();
				if(respCode>400) {
					
					System.out.println(url +" The Link is broken");
				}
				else {
					System.out.println(url+" is a valid link");
				}
				
			}
			catch (Exception e) {
				e.getMessage();
			}
		}
		
		//launchpage.login(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));

	}
	


}
