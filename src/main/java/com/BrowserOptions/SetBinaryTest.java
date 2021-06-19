package com.BrowserOptions;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class SetBinaryTest {

	public static void main(String[] args) {
		WebDriver driver;
		 System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");

		FirefoxOptions obj=new FirefoxOptions();
		
		//Firefox default. Installed in C driver
	//	obj.setBinary(new FirefoxBinary(new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe")));
		
		
		//Firefox 78
		obj.setBinary(new FirefoxBinary(new File("E:\\Training\\IBCS\\IBCS 8th Batch\\Tools\\firefox.exe")));
		
		driver=new FirefoxDriver();
		
		driver.get("https://google.com");
		
	}

}
