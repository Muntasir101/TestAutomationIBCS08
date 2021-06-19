package com.Basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigateDemo {

	public static void main(String[] args) {
		WebDriver driver;
		 System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");	
		driver=new FirefoxDriver();
		
		driver.get("https://demo.opencart.com/");
		
		driver.navigate().to("https://google.com");
		
		driver.navigate().back();
		
		driver.navigate().forward();
		
		driver.navigate().to("https://bbc.com");
		
		driver.navigate().refresh();
	}

}
