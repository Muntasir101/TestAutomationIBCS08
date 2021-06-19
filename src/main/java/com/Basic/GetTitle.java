package com.Basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetTitle {

	public static void main(String[] args) {
		WebDriver driver;
		 System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");	
		driver=new FirefoxDriver();

		driver.get("https://demo.opencart.com/");

		String ExpectedTitle="Your Store";

		String ActualPageTitle=driver.getTitle();


		if(ActualPageTitle.isEmpty())
		{
			System.out.println("Title missing.Test failed.");
		}

		else if(ExpectedTitle.equals(ActualPageTitle)) {
			System.out.println("Title matched. Test passed");	
		}

		else {
			System.out.println("Title not matched.Test failed.Actual Title:"+ActualPageTitle);
		}

		driver.close();



	}

}
