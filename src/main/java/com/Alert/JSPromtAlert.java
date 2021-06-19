package com.Alert;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class JSPromtAlert {

	public static void main(String[] args) throws InterruptedException {
		 WebDriver driver;
		 System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");

		ChromeOptions obj=new ChromeOptions();

		obj.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});

		driver=new ChromeDriver(obj);

		driver.get("https://the-internet.herokuapp.com/javascript_alerts");

		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button")).click();

		Thread.sleep(4000);

		//Type something on Alert
		driver.switchTo().alert().sendKeys("Selenium Test Automation.");

		Thread.sleep(4000);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		//Click OK on Alert
		//driver.switchTo().alert().accept();

		//Click Cancel on Alert
		driver.switchTo().alert().dismiss();


	}

}
