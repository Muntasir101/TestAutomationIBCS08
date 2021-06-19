package com.Basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetURL {

	public static void main(String[] args) {
		WebDriver driver;
		 System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");		
		driver=new FirefoxDriver();

		driver.get("https://demo.opencart.com/");

		String ExpectedURL="www.google.com";

		String ActualPageURL=driver.getCurrentUrl();


		if(ActualPageURL.isEmpty())
		{
			System.out.println("URL missing.Test failed.");
		}

		else if(ExpectedURL.equals(ActualPageURL)) {
			System.out.println("URL matched. Test passed");	
		}

		else {
			System.out.println("URL not matched.Test failed.Actual URL: "+ActualPageURL);
		}

		driver.close();



	}

}
