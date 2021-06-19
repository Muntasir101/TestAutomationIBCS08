package com.Basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserConfig {

	public static void main(String[] args) {
		
		/*
		 * WebDriver=Interface 
		 * driver=Reference Variable
		 * new=keyword
		 * FirefoxDriver=Constructor of FirefoxDriver Class
		 */
		WebDriver driver;
		
		//For Firefox launch
		// System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");		
		//driver=new FirefoxDriver();
		//Close Firefox browser
		//driver.close();
		
		//For Chrome launch
		 System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		
		//Full window
		driver.manage().window().maximize();
		
		//Close Chrome browser
		//driver.close();
		
		
		
		
	}

}
