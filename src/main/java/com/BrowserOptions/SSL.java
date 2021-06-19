package com.BrowserOptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class SSL {

	public static void main(String[] args) {
		WebDriver driver;
		 System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");	

		FirefoxOptions obj=new FirefoxOptions();

		obj.setAcceptInsecureCerts(true);

		driver=new FirefoxDriver();

		driver.get("https://www.cacert.org/");

	}

}
