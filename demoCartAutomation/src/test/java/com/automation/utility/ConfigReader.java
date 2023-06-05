package com.automation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	Properties pro;

	public ConfigReader() {

		File src = new File("./Config/Config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);

		} catch (Exception e) {
			System.out.println("Unable to read Properties File" + e.getMessage());
		}

	}

	public String getCustomData(String key) {
		return pro.getProperty(key);

	}

	public String getBrowser() {
		return pro.getProperty("Browser");

	}

	public String getURL() {
		return pro.getProperty("URL");

	}
}
