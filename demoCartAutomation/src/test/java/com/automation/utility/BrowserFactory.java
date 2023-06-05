package com.automation.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	public static WebDriver startApplication(String browserName, String URL, WebDriver ldriver) {
		
		
		
		
		
		if (browserName.equals("Chrome")) {
			//System.setProperty("webdriver.chrome.driver", "./Drivers/Chrome/chromedriver.exe");
			ldriver = WebDriverManager.chromedriver().create();

		} else if (browserName.equals("Firefox")) {

		} else if (browserName.equals("IE")) {

		}
		ldriver.get(URL);
		ldriver.manage().window().maximize();
		ldriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		return ldriver;

	}

	public static void quitApplication(WebDriver driver) {

		driver.quit();
	}

}
