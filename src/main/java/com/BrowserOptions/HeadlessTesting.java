package com.BrowserOptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HeadlessTesting {

	public static void main(String[] args) {
		WebDriver driver;
		 System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
		FirefoxOptions obj=new FirefoxOptions();
		
		obj.setHeadless(true);
		
		driver=new FirefoxDriver(obj);
		
		driver.get("https://demo.opencart.com/");

		String ExpectedTitle="Your Store";

		String ActualPageTitle=driver.getTitle();


		if(ActualPageTitle.isEmpty())
		{
			System.out.println("Headless Testing.Title missing.Test failed.");
		}

		else if(ExpectedTitle.equals(ActualPageTitle)) {
			System.out.println("Headless Testing.Title matched. Test passed");	
		}

		else {
			System.out.println("Headless Testing.Title not matched.Test failed.Actual Title:"+ActualPageTitle);
		}

		driver.close();

	}

}
