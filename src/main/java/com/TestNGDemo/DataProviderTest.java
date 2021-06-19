package com.TestNGDemo;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class DataProviderTest {
	WebDriver driver;

	@Test(dataProvider = "WebsiteList")
	public void OpenSite( String site) throws InterruptedException {

		driver.get(site);
		Thread.sleep(3000);
	}

	@DataProvider(name="WebsiteList")
	public Object[][] data() {

		Object[][] data=new Object [3][1];

		data [0][0]="https://google.com";
		data [1][0]="https://bbc.com";
		data [2][0]="https://cnn.com";

		return data;	  
	}

	@BeforeTest
	public void Browser_setup() {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");	
		driver=new FirefoxDriver();
	}

	@AfterTest
	public void TestClose() {
		driver.quit();
	}

}
