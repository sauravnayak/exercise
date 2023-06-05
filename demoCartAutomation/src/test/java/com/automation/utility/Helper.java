package com.automation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {

	
	
	public  static void captureScreenshot(WebDriver driver) {
		
		 File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 try {
			FileUtils.copyFile(src, new File("./Screenshot/Screenshot"+getCurrentDateTime() +".png"));
			System.out.println("Screenshot captured");
			
		} 
		 catch (IOException e) {
			
			System.out.println("Unable to capture Screenshot"+e.getMessage());
		}
		
	}
	
	public void handleFrames() {
		
	}
	
	public void handleAlerts() {
		
	}
	
	
	public void handleWindows() {
		
	}
	
	
	public static String getCurrentDateTime() {
		
	DateFormat customformat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
	Date currentdate=new Date();
	return customformat.format(currentdate);
	}
}
