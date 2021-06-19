package com.ScreenshotDemo;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PageScreenshot {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");		
		driver=new FirefoxDriver();
		
		driver.get("https://demo.opencart.com/");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(5000);
		
		//Take Screenshot
		File SrcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(SrcFile, new File(System.getProperty("user.dir")+"\\ScreenShots\\PageScreenshot.png"));
		} 
		
		catch (IOException e) 
		{		
			e.printStackTrace();
		}
		
		driver.close();

	}

}
