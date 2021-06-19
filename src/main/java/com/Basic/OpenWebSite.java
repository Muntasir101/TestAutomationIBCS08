package com.Basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenWebSite {

	public static void main(String[] args) {
		WebDriver driver;
		
		//For Firefox launch
		 System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");	
		driver=new FirefoxDriver();
		
		//Online
		//driver.get("https://bbc.com/");
		
		
		//Offline
		driver.get("file:///C:/Users/munta/OneDrive/Desktop/Your Store.html");
		
		
	}

}
