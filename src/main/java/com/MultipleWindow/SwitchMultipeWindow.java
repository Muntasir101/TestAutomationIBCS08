package com.MultipleWindow;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SwitchMultipeWindow {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		 System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");		
		ChromeOptions obj=new ChromeOptions();		
		obj.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});		
		driver=new ChromeDriver(obj);
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/windows");
		System.out.println("Parent/Base Window Title: "+driver.getTitle());
		
		String ParentGUID=driver.getWindowHandle();
		
		WebElement NewWindowBtn=driver.findElement(By.linkText("Click Here"));
		NewWindowBtn.click();
		
		//Get all GUID of the Browser
		Set<String> allGUID=driver.getWindowHandles();
		System.out.println(allGUID);
		
		//Count total open Window
		System.out.println("Total Window: "+allGUID.size());
		
		//Switch to Child
		for(String ChildGUID:allGUID)
		{
			if(!ChildGUID.equals(ParentGUID))
			{
				driver.switchTo().window(ChildGUID);
				System.out.println("Child Window Title: "+driver.getTitle());
				driver.navigate().to("https://google.com");
				Thread.sleep(5000);
				System.out.println("New Child Window Title after open Google :"+driver.getTitle());
				break;
			}
		}
		

		
		//Switch to Parent
		for(String ChildGUID:allGUID)
		{
			if(!ChildGUID.equals(ParentGUID))
			{
				driver.switchTo().window(ParentGUID);
				
				driver.navigate().to("https://bbc.com");
				Thread.sleep(5000);
				System.out.println("Parent Window Title after open BBC:"+driver.getTitle());
				
				break;
			}
		}
		
		driver.close();
		//driver.quit();

	}

}
