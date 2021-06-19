package com.ScreenshotDemo;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HighlightElementScreenshot {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver;
		 System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");		
		driver=new FirefoxDriver();
		
		driver.get("https://demo.opencart.com/");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(5000);
		
		//Locate image Element to Capture
		WebElement ScearchBox=driver.findElement(By.name("search"));

		
		JavascriptExecutor jsc=(JavascriptExecutor)driver;
		
		jsc.executeScript("arguments[0].style.border='3px solid red'",ScearchBox);
		
		Thread.sleep(3000);
		
		//Take Screenshot
		File SrcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		//save
		FileUtils.copyFile(SrcFile, new File(System.getProperty("user.dir")+"\\ScreenShots\\HighligtElement.png"),true);
		
		driver.close();
	}

}
