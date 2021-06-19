package com.Iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class IFrameTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		 System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");		
		ChromeOptions obj=new ChromeOptions();		
		obj.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});		
		driver=new ChromeDriver(obj);
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/iframe");
		
		//Switch to iFrame
		driver.switchTo().frame("mce_0_ifr");
		
		WebElement iFrameTextEditor=driver.findElement(By.id("tinymce"));
		
		Thread.sleep(5000);
		
		//Clear text from TextEditor
		iFrameTextEditor.clear();
		
		//Type something on TextEditor
		iFrameTextEditor.sendKeys("Test Automation By selenium WebDriver");
		
		

	}

}
