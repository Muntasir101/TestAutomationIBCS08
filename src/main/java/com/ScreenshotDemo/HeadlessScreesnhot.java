package com.ScreenshotDemo;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HeadlessScreesnhot {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		 System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");	
		FirefoxOptions obj=new FirefoxOptions();

		obj.setHeadless(true);

		driver=new FirefoxDriver(obj);

		driver.get("https://demo.opencart.com/");

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(5000);

		//Take Screenshot
		File SrcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(SrcFile, new File(System.getProperty("user.dir")+"\\ScreenShots\\HeadlessScreenshot.png"));
		} 

		catch (IOException e) 
		{		
			e.printStackTrace();
		}

		driver.close();


	}

}
